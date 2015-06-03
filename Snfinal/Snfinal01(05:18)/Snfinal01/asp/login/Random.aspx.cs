using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;

using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Snfinal01.asp.login
{
    public partial class Random : System.Web.UI.Page
    {
       


        protected void Page_Load(object sender, EventArgs e)
        {
            string temp = getRandomNum(4);
            HttpCookie random = new HttpCookie("randomImg",temp);

            Response.Cookies.Add(random);

            this.ValidateCode(temp);
        }
        #region 随机数的生成
        /// <summary>
        /// 生成随机的图片
        /// </summary>
        /// <param name="num"></param>
        private void ValidateCode(String num)
        {
            Bitmap img = null;
            Graphics gra = null;
            MemoryStream ms = null;

            //生成随机构造器
            System.Random randoms = new System.Random(1000);

            int graW = num.Length * 14;
            img = new Bitmap(graW,25);
            gra = Graphics.FromImage(img);

            //图片的背景
            gra.Clear(Color.Orange);

            //生成背景噪点
            for (int i = 0; i < 100;i++ )
            {
                int x = randoms.Next(img.Width);
                int y = randoms.Next(img.Height);

                img.SetPixel(x,y,Color.FromArgb(randoms.Next()));
            }

            //设置字体
            Font font = new Font("Arial Black",12);
            //设置字的颜色
            SolidBrush sb = new SolidBrush(Color.White);
            //生成图片
            gra.DrawString(num,font,sb,3,3);
            ms = new MemoryStream();
            img.Save(ms,ImageFormat.Jpeg);

            Response.ClearContent();
            Response.ContentType = "image/Jpeg";
            Response.BinaryWrite(ms.ToArray());

            gra.Dispose();
            img.Dispose();
            Response.End();
        }
        /// <summary>
        /// 获取随机的数字/字母
        /// </summary>
        /// <param name="num"></param>
        /// <returns></returns>
        private string getRandomNum(int num)
        {
            string randomChar = "0,1,2,3,4,5,6,7,8,9,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
            string[] randomArray = randomChar.Split(new char[]{','});

            string randomNum = "";
            int temp = -1;
            System.Random random = new System.Random(1000);
           

            for (int i = 1; i < num + 1;i++ )
            {
                if (temp == -1)
                {
                    random = new System.Random(i*temp*unchecked((int)DateTime.Now.Ticks));
                }

                int t = random.Next(35);

                if (temp != -1 && temp == t)
                {
                    return getRandomNum(num);
                }
                temp = t;

                randomNum += randomArray[t];
            }

            return randomNum;
        }
        #endregion

    }
}
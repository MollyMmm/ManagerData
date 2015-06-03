using Snfinal01;
using System;
using System.Collections.Generic;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Snfinal01.src.service;

using Snfinal01.src.util;
namespace Snfinal01.asp.login
{
    public partial class login : System.Web.UI.Page
    {
        MD5Util md5Util = new MD5Util();

        protected void Page_Load(object sender, EventArgs e)
        {

            randImg.ImageUrl = "Random.aspx";
        }

        protected void submitBtm_Click(object sender, EventArgs e)
        {
            Admin admin = new Admin();
            AdminService adminS = new AdminService();


            string random = Request.Cookies["randomImg"].Value;
            if (random.Equals(randomTxt.Text))
            {
                admin.UserName = userNameTxt.Text;
                admin.Password =md5Util.getMD5(passwordTxt.Text);

                int isAdmin = adminS.isAdmin(admin);
                switch (isAdmin)
                {
                    case 1:
                        {
                            //超级管理员
                            admin.Identity = 1;
                            this.Session["admin"] = admin;

                            Response.Redirect("../superAdmin/index.apsx");
                            break;
                        }
                    case 0:
                        {
                            //普通管理员表
                            admin.Identity = 0;
                            this.Session["admin"] = admin;

                            Response.Redirect("../ordAdmin/backDeom.aspx");
                            break;
                        }
                    default:
                        {
                            //帐号或密码错误请重新输入                           
                            passwordLbl.Text = "帐号或密码错误,请您重新输入!";
                            passwordTxt.Text = "";
                            passwordTxt.Focus();
                            break;
                        }


                }
            }
            else
            { 
            //验证码错误
                randImg.ImageUrl = "Random.aspx?";
                passwordLbl.Text = "验证码错误,请您重新输入!";
                //清空密码
                passwordTxt.Text = "";
                passwordTxt.Focus();
            }

        }

        protected void randImg_Click(object sender, ImageClickEventArgs e)
        {
           randImg.ImageUrl = "Random.aspx?";
           
        }
    }
}
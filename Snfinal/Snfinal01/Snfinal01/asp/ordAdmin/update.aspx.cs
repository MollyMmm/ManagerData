using System;
using System.Collections.Generic;

using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Snfinal01.src.service;
using Snfinal01.src.model;
using System.Text;
using System.Collections;

namespace Snfinal01.asp.ordAdmin
{
    public partial class update : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            PageInfoService pageS = new PageInfoService();

            //获取上一个页面传递过来的信息
            string id = Request["id"];
            string pageInfo = Request["pageInfo"];

            //将id pageInfo放入前台相应kongjian zhong 
            idHid.Value = id;
            pageInfoHid.Value = pageInfo;

            //调用存储过程,获取到一个更新页面page
            PageBean page = pageS.getOnePage(pageInfo, id);

            PageHead[] pageTh = page.Body;
            StringBuilder sbBody = new StringBuilder();
            //动态生成界面
            sbBody.Append("<table>");
            for (int i = 0; i < pageTh.Length;i++ ) 
            {
                sbBody.Append("<tr><td>" + pageTh[i].TrName + "</td><td><input id=" + pageTh[i].Name + " runat='server' Text=" + page.Ones.Rows[0][pageTh[i].Name] + "><asp:TextBox></td></tr>");
            }
            sbBody.Append("<tr><td colspan='2'>");
            sbBody.Append("<asp:Button ID='sumbitBtn' runat='server' Text='确认修改' OnClick='sumbitBtn_Click' />");
            sbBody.Append("<input type='reset' value='重置'>");
            sbBody.Append("<asp:Button ID='cancelBtn' runat='server' Text='取消' OnClick='cancelBtn_Click' />");
            sbBody.Append("</td></tr>");
            sbBody.Append("</table>");

            bodyDiv.InnerHtml = sbBody.ToString();
        }
        #region 确认修改
        /// <summary>
        /// 确认修改
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        /// 
        protected void sumbitBtn_Click(object sender, EventArgs e)
        {
            PageInfoService pageS = new PageInfoService();
            PageHead[] page = null;

            string pageInfo = pageInfoHid.Value;
            
             page = pageS.getUpdateMethod(page,pageInfo);
            //存放更新后的信息
            Dictionary<string, string> beanInfo = new Dictionary<string, string>();
            for (int i = 0; i < page.Length;i++ )
            {
                beanInfo.Add(page[i].Name, page[i].TrName);
            }
        }
        #endregion
        
        /// <summary>
        /// 取消
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        protected void cancelBtn_Click(object sender, EventArgs e)
        {
            
        }

    }
}
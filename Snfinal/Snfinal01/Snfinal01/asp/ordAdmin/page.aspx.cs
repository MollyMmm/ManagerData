using System;
using System.Collections.Generic;

using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Snfinal01.src.model;
using Snfinal01.src.service;
using System.Text;
using System.Data;

namespace Snfinal01.asp.ordAdmin
{
    public partial class page : System.Web.UI.Page
    {
        public PageHead[] body { get; set; }
        protected void Page_Load(object sender, EventArgs e)
        {
            PageInfoService pageS = new PageInfoService();

            //获取从上一个页面传递过来的 模块名称
            string pageInfo = Request["page"];

            //前台中的隐藏字段存储名称
            pageHid.Value = pageInfo;



            
                        //从数据库中获取模板信息        
                        PageBean page = pageS.getPage(pageInfo);

                        PageHead[] head = page.Head;
                        PageHead[] body = page.Body;
                        DataTable bodyTable = page.Ones;
            /*
                        // Define the name and type of the client scripts on the page.
                        String csname1 = "PageScript";
                        Type cstype = this.GetType();

                        // Get a ClientScriptManager reference from the Page class.
                        ClientScriptManager cs = Page.ClientScript;

                        // Check to see if the startup script is already registered.
                        if (!cs.IsStartupScriptRegistered(cstype, csname1))
                        {

                            StringBuilder sbScript = new StringBuilder();

                            //javaScript
                            sbScript.Append("<script type='text/javascript'>");
                            sbScript.Append("function updateDialog(id){ art.dialog.open('./update.aspx?id='+id'&pageInfo='" + pageInfo + ", {"
                                + "title: '修改',"
                                + "time:1200,"
                                //遮罩层
                               + " lock:true,"
                                // 透明度
                                + "opacity: 0.87,"
                                //不许拖拽
                                + "drag: false,"
                                + "resize: false,"
                                + "width:'30%',"
                                + "height:'70%',"
                                + "init:function() {"
                                    + "var iframe = this.iframe.contentWindow;"
                                    + "var top = art.dialog.top;"
                                // 引用顶层页面window对象
                                + "},"
                            + "});"
                        + "}");


                            sbScript.Append("</script>");
                            cs.RegisterStartupScript(cstype, csname1, sbScript.ToString());
                        }
                        //搜索条件
                        StringBuilder sbHead = new StringBuilder();
                        sbHead.Append("<table align='center'><tr>");
                        for (int i = 0; i < head.Length; i++)
                        {
                            sbHead.Append("<td>" + head[i].TrName + "</td>");
                            sbHead.Append("<td><asp:TextBox ID='" + head[i].Name + "' runat='server'></asp:TextBox></td>");
               
                        }
                        sbHead.Append("</tr></table>");
                        pageHead.InnerHtml = sbHead.ToString();

                        StringBuilder sbTh = new StringBuilder();
                        if (bodyTable != null)
                        {

                        //th
                        sbTh.Append("<table class='altrowstable' id='alternatecolor'>");
                        sbTh.Append("<tr>");
                        for (int i = 0; i < body.Length; i++)
                        {
                            sbTh.Append("<th>"+body[i].TrName+"</th>");
                        }
                        sbTh.Append("<th>操作</th>");
                        sbTh.Append("</tr>");
           
                        //内容
                            for (int i = 0; i < body.Length; i++)
                            {
                                sbTh.Append("<tr>");

                                for (int j = 0; j < body.Length; j++)
                                {
                                    sbTh.Append("<td>" + bodyTable.Rows[i][body[j].Name] + "</td>");
                                }
                                sbTh.Append("<td><a href='javascript:void(0)' id=" + bodyTable.Rows[i]["ID"] + " onclick='updateDialog(this.id)'></a></td>");
                                sbTh.Append("</tr>");
                            }

                            sbTh.Append("</table>");
                        }
                        else
                        {
                            sbTh.Append("<table><tr><td>该页面内容不存在</td></tr></table>");
                        }

                        pageBody.InnerHtml = sbTh.ToString();
                    
             * */


            //给查询条件绑定数据
                        searchDlist.DataSource = page.Head;
                        searchDlist.DataBind();
        }

        protected void thNameDlist_DeleteCommand(object source, DataListCommandEventArgs e)
        {

        }

        protected void thNameDlist_UpdateCommand(object source, DataListCommandEventArgs e)
        {

        }
    }
}
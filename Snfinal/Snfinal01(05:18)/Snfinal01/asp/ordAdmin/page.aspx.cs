using System;
using System.Collections.Generic;

using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using Snfinal01;
using Snfinal01.src.model;
using Snfinal01.src.service;
using System.Text;
using System.Data;
namespace Snfinal01.asp.ordAdmin
{
    public partial class page : System.Web.UI.Page
    {
        /*页面信息*/
        public string pageInfo { get; set; }

        /*显示页*/
        public PageHead[] body { get; set; }
        public PageHead[] head { get; set; }
        public PageBean pagePage { get; set; }
        public string tdName { get; set; }

        /*编辑页*/
        public DataTable editPage { get; set; }
        public PageHead[] thNameS { get; set; }
        public string editThName { get; set; }
        public string editName { get; set; }
        public int type { get; set; }

        protected void Page_Load(object sender, EventArgs e)
        {
            PageInfoService pageS = new PageInfoService();


           // Response.Write("12345");

            //获取从上一个页面传递过来的 模块名称
            string pageInfo = Request["page"];

            if(pageInfo!=null)
            {
            //前台中的隐藏字段存储名称
            pageHid.Value = pageInfo;

            //从数据库中获取模板信息        
            pagePage = pageS.getPage(pageInfo);

            head = pagePage.Head;
            body = pagePage.Body;
            DataTable bodyTable = pagePage.Ones;
              
            //给查询条件绑定数据
            searchDlist.DataSource = pagePage.HeadTable;
            searchDlist.DataBind();

            
            //显示内容绑定数据
            bodylist.DataSource = pagePage.Ones;
            bodylist.DataBind();
            }

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





        }

        protected void thNameDlist_DeleteCommand(object source, DataListCommandEventArgs e)
        {

        }

        protected void thNameDlist_UpdateCommand(object source, DataListCommandEventArgs e)
        {
            switch (e.CommandName)
            {
                case "update":
                    {
                        
                        break;
                    }
                case "cancel":
                    {
                        bodylist.SelectedIndex = -1;
                        bodylist.DataBind();
                        break;
                    }
            }
        }

        protected void bodylist_EditCommand(object source, DataListCommandEventArgs e)
        {

            

            switch (e.CommandName)
            {
                case "edit":
                    {
                        PageInfoService pageS = new PageInfoService();                       

                        string id = Convert.ToString(e.CommandArgument);
                        pagePage = pageS.getOnePage(pageInfo,id);

                        editPage = pagePage.Ones;
                        thNameS = pagePage.Body;

                        bodylist.DataSource = editPage;
                        bodylist.DataBind();
                        break;
                    }
                case "delete": 
                    {
                        Client db = new Client();

                        string id = Convert.ToString(e.CommandArgument);

                        db.Delete_one(id,pageInfo);
                        DataSet delDs = db.Select_one(id,pageInfo);

                        if (delDs.Tables[0].Rows.Count == 0)
                        {
                            //删除操作成功
                            Response.Redirect("./page.aspx?page=" + pageInfo);
                        }
                        else
                        {
                            Response.Write("<script>alert('删除失败！请查找原因')</script>");

                        }


                        break;
                    }
            }
        }



/// <summary>
/// body绑定数据后 内容的表头绑定数据
/// </summary>
/// <param name="sender"></param>
/// <param name="e"> body </param>
        protected void bodylist_ItemDataBound(object sender, DataListItemEventArgs e)
        {
            DataList headDataList = (DataList)e.Item.FindControl("headDataList");
            //显示内容的表头绑定数据

            if (headDataList != null)
            {

                headDataList.RepeatColumns = head.Length;
                headDataList.DataSource = head;
                headDataList.DataBind();
            }
        }
    }
}
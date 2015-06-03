using System;
using System.Collections.Generic;

using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Snfinal01.asp.superAdmin.admin
{
    public partial class adminAdd : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

         if(   Request.Form["userName"]!=null)
            {
            
                Response.Clear();
                Response.Write("1");
                Response.End();
            
            
            }




        }
    }
}
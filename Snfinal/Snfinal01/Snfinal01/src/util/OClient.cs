using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CUST;
using System.Data;
using System.Data.OracleClient;
using Snfinal01;
using Snfinal01.src.model;
namespace Snfinal01
{
    public class OClient
    {
        /// <summary>
        /// 管理员登陆
        /// </summary>
        /// <param name="admin"></param>
        /// <returns></returns>
        protected DataSet Select_Admin(Admin admin)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {                              
                                           new OracleParameter("p_username",OracleType.VarChar,50),  
                                           new OracleParameter("p_password",OracleType.VarChar,50), 
                                           new OracleParameter("p_identity",OracleType.Int32),
                                           new OracleParameter ("p_mycurbm",OracleType.Cursor)
                                         };

                parameter[0].Value = admin.UserName;
                parameter[1].Value = admin.Password;
                parameter[2].Value = admin.Identity;
                parameter[3].Direction = ParameterDirection.Output;
                DataSet ds = db.RunProcedure("PACK_TEST.Select_admin_identity", parameter, "admin");
                return ds;

            }
            finally
            {
                db.Close();
            }
        }
        protected DataSet Select_page(PageHead page, string pageName)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = { 
                                          new OracleParameter ("p_ID",OracleType.Int32),
                                           new OracleParameter ("p_Name",OracleType .VarChar,20),
                                           new OracleParameter ("p_TrName",OracleType.VarChar,40),
                                           new OracleParameter ("p_Textbox",OracleType.Int32),
                                           new OracleParameter ("p_ThName",OracleType.Int32),
                                           new OracleParameter ("p_Type",OracleType.Int32)
                                         };
                parameter[0].Value = page.Id;
                parameter[1].Value = page.Name;
                parameter[2].Value = page.TrName;
                parameter[3].Value = page.TextBox;
                parameter[4].Value = page.ThName;
                parameter[5].Value = page.Type;
                parameter[6].Direction = ParameterDirection.Output;
                DataSet ds = db.RunProcedure("PACK_TEST.Select_" + pageName + "Table", parameter, pageName);

                return ds;
            }
            finally
            {
                db.Close();
            }
        }
    }
}

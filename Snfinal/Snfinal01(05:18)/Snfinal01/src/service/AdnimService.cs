using System;
using System.Collections.Generic;
using System.Web;


using Snfinal01.src.util;
using Snfinal01;
using System.Data;
namespace Snfinal01.src.service
{
    public class AdminService
    {
        Client db = new Client();

        /// <summary>
        /// 管理员登陆身份
        /// </summary>
        /// <param name="admin"></param>
        /// <returns>
        /// -1:不是管理员
        /// 1:超级管理员
        /// 0:普通管理员
        /// </returns>
        public int isAdmin(Admin admin)
        {
            DataSet dataset = db.Select_Admin(admin);
            if (dataset.Tables [0].Rows.Count == 0)
            {
                return -1;
            }
            else
            {
                return Convert.ToInt32(dataset.Tables["admin"].Rows[0]["identity"]);
            }
        }


    }
}
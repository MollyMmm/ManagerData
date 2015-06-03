using System;
using System.Collections.Generic;
using System.Web;

using System.Data;
using Snfinal01.src.model; 

namespace Snfinal01
{
    public class Client:OClient
    {
        public Client() { }

        public new DataSet Select_page(PageHead page, string pageName)
        {
            return base.Select_page(page,pageName);
        }

        public new DataSet Select_Admin(Admin admin)
        {
            return base.Select_Admin(admin);
        }
    }

}
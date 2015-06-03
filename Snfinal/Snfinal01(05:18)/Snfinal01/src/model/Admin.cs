using System;
using System.Collections.Generic;
using System.Web;

namespace Snfinal01
{
    public class Admin
    
    {
        private string _userName;
        private string _password;
        private int _id;
        private int _identity;
        private string _email;
        private string _tele;
        private string _sex;

        public string UserName
        {
            get { return _userName; }
            set { _userName = value; }
        }
        public string Email
        {
            get { return _email; }
            set { _email = value; }
        }
        public string Tele
        {
            get { return _tele; }
            set { _tele = value; }
        }
        public string Sex
        {
            get { return _sex; }
            set { _sex = value; }
        }
        public int Id
        {
            get { return _id;  }
            set { _id = value; }
        }
        public int Identity
        {
            get { return _identity; }
            set { _identity = value; }
        }
        public string Password
        {
            get { return _password; }
            set { _password = value; }
        }

    }
}
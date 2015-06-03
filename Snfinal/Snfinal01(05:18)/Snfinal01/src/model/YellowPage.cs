using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Snfinal01.src.model
{
    public class YellowPage
    {
        private int _id;
        private string _extendedid;
        private string _institutionName;
        private string _contactmethod;
        private string _location;
        private string _picture;
        public int Id 
        {
            get { return _id; }
            set { _id = value; }
        }
        public string Extendedid 
        {
            get { return _extendedid; }
            set { _extendedid = value; }
        }
        public string InstitutionName 
        {
            get { return _institutionName; }
            set { _institutionName = value; }
        }
        public string Contactmethod 
        {
            get { return _contactmethod; }
            set { _contactmethod = value; }
        }
        public string Location 
        {
            get { return _location; }
            set { _location = value; }
        }
        public string Picture 
        {
            get { return _picture; }
            set { _picture = value; }
        }
    }
}
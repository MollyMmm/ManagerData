using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Snfinal01.src.model
{
    public class Advertisment
    {
        private int _id;
        private int _extendedid;
        private String _title;
        private String _mainbody;
        private String _body;
        private String _picture;
        private String _publishtime;

        public int Id 
        {
            get { return _id; }
            set { _id = value; }
        }
        public int Extendedid 
        {
            get { return _extendedid; }
            set { _extendedid = value; }
        }
        public String Title 
        {
            get { return _title; }
            set { _title = value; }
        }
        public String Mainbody 
        {
            get { return _mainbody; }
            set { _mainbody = value; }
        }
        public String Body 
        {
            get { return _body; }
            set { _body = value; }
        }
        public String Picture 
        {
            get { return _picture; }
            set { _picture = value; }
        }
        public String PublishTime 
        {
            get { return _publishtime; }
            set { _publishtime = value; }
        }
    }
}
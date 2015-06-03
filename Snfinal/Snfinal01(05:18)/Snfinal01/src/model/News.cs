using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Snfinal01.src.model
{
    public class News
    {
        private int _id;
        private string _extendedid;
        private string _title;
        private string _mainbody;
        private string _body;
        private string _publishTime;
        private string _updateTime;
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
        public string   Title 
        {
            get { return _title; }
            set { _title = value; }
        }
        public string   Body 
        {
            get { return _body; }
            set { _body = value; }
        }
        public string   Mainbody 
        {
            get { return _mainbody; }
            set { _mainbody = value; }
        }
        public string   Publishtime 
        {
            get { return _publishTime; }
            set { _publishTime = value; }
        }
        public string   UpdateTime 
        {
            get { return _updateTime; }
            set { _updateTime = value; }
        }
    }
}
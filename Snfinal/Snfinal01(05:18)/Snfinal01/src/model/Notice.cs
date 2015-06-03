using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Snfinal01.src.model
{
    public class Notice
    {

        private int _id;
        private string _extendedid;
        private string _title;
        private string _body;
        private string _mainbody;
        private string _publishtime;
        private string _updatetime;
        private string _picture;
        private string _type;
        private string _editor;

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
        public string Title
        {
            get { return _title; }
            set { _title = value; }
        }
        public string Body
        {
            get { return _body; }
            set { _body = value; }
        }
        public string Mainbody
        {
            get { return _mainbody; }
            set { _mainbody = value; }
        }
        public string Publishtime
        {
            get { return _publishtime; }
            set { _publishtime = value; }
        }
        public string Updatetime
        {
            get { return _updatetime; }
            set { _updatetime = value; }
        }

        public string Picture
        {
            get { return _picture; }
            set { _picture = value; }

        }
        public string Type
        {
            get { return _type; }
            set { _type = value; }
        }
        public string Editor
        {
            get { return _editor; }
            set { _editor = value; }

        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Snfinal01.src.model
{
    public class Technical
    {
        private int _id;
        private int _extendedid;
        private string _title;
        private string _name;
        private string _body;
        private string _publishtime;
        private int _type;
        public int Id 
        {
            get { return _id; }
            set { Id = value; }
        }
        public int Extendedid 
        {
            get { return _extendedid; }
            set { Extendedid = value; }
        }
        public int Type 
        {
            get { return _type; }
            set { Type = value; }
        }
        public string Title 
        {
            get { return _title; }
            set { Title = value; }
        }
        public string Name 
        {
            get { return _name; }
            set { Name = value; }
        }
        public string Body 
        {
            get { return _body; }
            set { Body = value; }
        }
        public string Pulishtime 
        {
            get { return _publishtime; }
            set { Pulishtime = value; }
        }
    }
}
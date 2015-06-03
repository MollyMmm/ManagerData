using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Snfinal01.src.model
{
    public class Publicity
    {
        private int _id;
        public string _extended;
        private string _title;
        private string _bodys;
        private string _type;
        private int _startTime;
        private int _updateTime;
        private int _process;
        private string _name;
        private string _idItem;
        public int Id 
        {
            get { return _id; }
            set { _id = value; }
        }
        public string Extended
        {
            get { return _extended; }
            set { _extended = value; }
        }

        public string Title 
        {
            get { return _title; }
            set { _title = value; }
        }
        public string Bodys 
        {
            get { return _bodys; }
            set { _bodys = value; }
        }
        public string Type 
        {
            get { return _type; }
            set { _type = value; }
        }
        public int StartTime 
        {
            get { return _startTime; }
            set { _startTime = value; }
        }
        public int UpdateTime 
        {
            get { return _updateTime; }
            set { _updateTime = value; }
        }
        public int Process 
        {
            get { return _process; }
            set { _process = value; }
        }
        public string Name 
        {
            get { return _name; }
            set { _name = value; }
        }
        public string IdItem 
        {
            get { return _idItem; }
            set { _idItem = value; }
        }
    }
}
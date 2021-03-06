﻿using System;
using System.Collections.Generic;
using System.Web;
using Snfinal01.src.model;

using System.Data;

namespace Snfinal01.src.model
{
    public class PageBean
    {
        private DataTable _headTable;
        private PageHead[] _head;
        private PageHead[] _body;
        private DataTable _ones;


        public DataTable HeadTable
        {
            get { return _headTable; }
            set { _headTable = value; }
        }
        public PageHead[] Head
        {
            get { return _head; }
            set { _head = value; }
        }
        public PageHead[] Body
        {
            get { return _body; }
            set { _body = value; }
        }
        public DataTable Ones
        {
            get { return _ones; }
            set { _ones = value; }
        }

    }
}
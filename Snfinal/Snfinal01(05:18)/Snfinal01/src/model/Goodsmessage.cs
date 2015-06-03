using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Snfinal01.src.model
{
   public class Goodsmessage
    {
        private int _id;
        private int _extendedid;
        private string _names;
        private string _picture;
        private int _price;
        private int _preprice;
        private string _introduction;
        public int Id
        {
            get { return _id;  }
            set { _id = value; }

        }
        public int Extendedid
        {
            get { return _extendedid;  }
            set { _extendedid = value; }
        }
        public string Names
        {
            get { return _names;  }
            set { _names = value; }
        }
        public string Pictrue
        {
            get { return _picture;  }
            set { _picture = value; }

        }
        public int Preprice
        {
            get { return _preprice;  }
            set { _preprice = value; }
        }
        public int Price
        {
            get { return _price;  }
            set { _price = value; }
        }
        public string Introduction
        {
            get { return _introduction;  }
            set { _introduction = value; }

        }
    }
}

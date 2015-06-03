using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Snfinal01.src.model
{
    public class ExpertMessage
    {
            private int _id;
            private string _extendedid;
            private string _names;
            private string _headPortrait;
            private string _birth;
            private string _major;
            private string _dutytime;
            private string _info;

            public int Id
            {
                get { return _id; }
                set { _id = value; }
            }
            public string Extendedid
            {
                get { return _extendedid;  }
                set { _extendedid = value; }
            }
            public string Names
            {
                get { return _names;   }
                set { _names = value; }
            }
            public string HeadPortrait
            {
                get { return _headPortrait;   }
                set { _headPortrait = value; }
            }
            public string Birth
            {
                get { return _birth;  }
                set { _birth = value; }
            }
            public string Major
            {
                get { return _major;   }
                set { _major = value; }
            }
            public string Dutytime
            {
                get { return _dutytime;  }
                set { _dutytime = value; }
            }
            public string Info
            {
                get { return _info;  }
                set { _info = value; }
            }
        
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Snfinal01.src.model
{
    public class SoilMessage
    {
        private int _id;
        private string _extendedid;
        private string _names;
        private string _picture;
        private int _price;
        private string _conversionProperty;
        private string _soilarea;
        private string _negotiableYear;
        private string _surplusyear;
        private string _landWarrants;
        private string _soilusing;
        private string _type;
        private string _validdate;
        private string _soillocation;
        private string _contactway;
        private string _state;

        public int Id 
        {
            get { return _id;  }
            set { _id = value;  }
        }
        public string Extendedid 
        {
            get { return _extendedid;  }
            set { _extendedid = value;  }
        }
        public string Names 
        {
            get { return _names;  }
            set { _names = value;  }

        }
        public string Picture 
        {
            get { return _picture;  }
            set { _picture = value;  }
        }
        public int Price 
        {
            get { return _price;  }
            set { _price = value;  }
        }
        public string ConversionProperty 
        {
            get { return _conversionProperty;  }
            set { _conversionProperty = value;  }
        }
        public string Soilarea 
        {
            get { return _soilarea;  }
            set { _soilarea = value;  }
        }
        public string NegotiableYear 
        {
            get { return _negotiableYear;  }
            set { _negotiableYear = value;  }
        }
        public string Surplusyear 
        {
            get { return _surplusyear;  }
            set { _surplusyear = value;  }
        }
        public string LandWarrant 
        {
            get { return _landWarrants;  }
            set { _landWarrants = value;  }
        }
        public string Soilusing 
        {
            get { return _soilusing;  }
            set { _soilusing = value;  }
        }
        public string Type 
        {
            get { return _type;  }
            set { _type = value;  }
        }
        public string Validdate 
        {
            get { return _validdate;  }
            set { _validdate = value;  }
        }
        public string State 
        {
            get { return _state;  }
            set { _state = value;  }
        }
        public string Soillocation 
        {
            get { return _soillocation;  }
            set { _soillocation = value;  }
        }
        public string Contatway 
        {
            get { return _contactway;  }
            set { _contactway = value;  }
        }
    }
}

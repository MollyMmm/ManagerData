using System;
using System.Collections.Generic;
using System.Web;

namespace Snfinal01.src.model
{
    public class PageHead
    {
       private int _id;
       private string _name;
       private string _trname;
       private int _textbox;
       private int _thname;
       private int _type;

       public int Id
       {
           get { return _id; }
           set { _id = value; }
       }
       public String Name
       {
           get { return _name; }
           set { _name = value; }
       }
       public String TrName
       {
           get { return _trname; }
           set { _trname = value; }
       }
       public int TextBox
       {
           get { return _textbox; }
           set { _textbox = value; }
       }
       public int ThName
       {
           get { return _thname; }
           set { _thname = value; }
       }
       public int Type
       {
           get { return _type; }
           set { _type = value; }
       }
    }
}
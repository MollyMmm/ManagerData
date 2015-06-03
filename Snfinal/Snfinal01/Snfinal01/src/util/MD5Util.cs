using System;
using System.Collections.Generic;
using System.Web;

using System.Text;
using System.Security.Cryptography;
namespace Snfinal01.src.util
{
    public class MD5Util
    {

        public string getMD5(string oldStr)
        {

            byte[] result = Encoding.Default.GetBytes(oldStr);    //tbPass为输入密码的文本框
            MD5 md5 = new MD5CryptoServiceProvider();
            byte[] output = md5.ComputeHash(result);
            return output.ToString();
        }
    }
}
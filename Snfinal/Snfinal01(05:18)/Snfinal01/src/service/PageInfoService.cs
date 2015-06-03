using System.Collections.Generic;

using Snfinal01.src.model;
using System.Data;
using System;

namespace Snfinal01.src.service
{
    public class PageInfoService
    {
        /// <summary>
        /// 获取显示模板
        /// </summary>
        /// <param name="pageInfo">所选模块</param>
        /// <returns></returns>
        public PageBean getPage(string pageInfo)
        {

            PageHead pageHead = new PageHead();
            PageHead pageBody = new PageHead();
            PageBean page = new PageBean();

            Client dbUtil = new Client();

            //查询条件等
            pageHead.TextBox = 1;
            page.Head = getHeadBody(page.Head, pageHead, pageInfo);
            page.HeadTable = dbUtil.Select_page(pageHead, pageInfo).Tables[0];

            //显示内容的标题
            pageBody.ThName = 1;
            page.Body = getHeadBody(page.Body, pageBody, pageInfo);

            //获取显示内容
            page.Ones = getPageInfo(pageInfo);

            return page;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
        /// <summary>
        /// 获取更新页面的 用户名之类的那列
        /// </summary>
        /// <param name="page">要返回的也是这个对象</param>
        /// <param name="pageInfo">该页面的对象</param>
        /// <returns></returns>
        public PageHead[] getUpdateMethod(PageHead[] page, string pageInfo)
        {

            PageHead pageHead = new PageHead();

            //查询条件等
            pageHead.TextBox = 1;
            page = getHeadBody(page, pageHead, pageInfo);

            return page;
        }
        /// <summary>
        /// 从数据库中获取查询条件以及表头的内容
        /// </summary>
        /// <param name="headBody"> 显示内容</param>
        /// <param name="pageHead">查询条件等</param>
        /// <param name="pageInfo">所选模块</param>
        /// <returns></returns>
        public PageHead[] getHeadBody(PageHead[] headBody, PageHead pageHead, string pageInfo)
        {
            Client dbUtil = new Client();
            //调用存储过程查询
            DataTable headTable = dbUtil.Select_page(pageHead, pageInfo).Tables[0];

            headBody = new PageHead[headTable.Rows.Count];
            for (int i = 0; i < headTable.Rows.Count; i++)
            {
                //从查询到的DataTable中获取 值
                PageHead head = new PageHead();
                head.Name = (string)headTable.Rows[i]["NAME"];
                head.TrName = (string)headTable.Rows[i]["TRNAME"];
                head.TextBox =Convert.ToInt32( headTable.Rows[i]["TEXTBOX"]);
                //将每行中的PageHead添加到PageBean中
                headBody[i] = head;
            }

            return headBody;
        }
        /// <summary>
        /// 根据id获取一页信息(点击编辑后的查询)
        /// </summary>
        /// <param name="pageInfo"></param>
        /// <param name="id"></param>
        /// <returns></returns>
        public PageBean getOnePage(string pageInfo, string id)
        {
            Client dbUtil = new Client();

            PageHead pageBody = new PageHead();
            PageBean page = new PageBean();

            //显示内容的标题
            pageBody.ThName = 1;
            page.Body = getHeadBody(page.Body, pageBody, pageInfo);

            //调用含有条件(id)的查询的存储过程
            page.Ones = this.getOneTable(pageInfo, id);

            return page;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="pageInfo"></param>
        /// <returns></returns>
        public DataTable getOneTable(string pageInfo, string id)
        {
            Client dbUtil = new Client();


            //调用条件(id)查询的存储过程
            return dbUtil.Select_one(id,pageInfo).Tables[0];
        }

        /// <summary>
        /// 获取分页后的信息
        /// </summary>
        /// <param name="pageInfo"></param>
        /// <returns></returns>
        public DataTable getPageInfo(string pageInfo)
        {
            Client dbUtil = new Client();

            //调用无条件查询的存储过程            
            return dbUtil.Select_pageS(pageInfo).Tables[0];
        }

        /// <summary>
        /// 更新操作
        /// </summary>
        /// <param name="beanInfo">存储更新后的信息</param>
        /// <param name="pageInfo">要更新的对象名</param>
        /// <returns></returns>
        public DataTable updateInfo(Dictionary<string, string> beanInfo, string pageInfo)
        {
            return null;
        }
    }
}
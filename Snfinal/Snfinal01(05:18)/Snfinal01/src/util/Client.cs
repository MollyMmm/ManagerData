using System;
using System.Collections.Generic;
using System.Web;

using System.Data;
using Snfinal01.src.model; 

namespace Snfinal01
{
    public class Client:OClient
    {
        public Client() { }

        public new DataSet Select_page(PageHead page, string pageName)
        {
            return base.Select_page(page,pageName);
        }

        public new DataSet Select_Admin(Admin admin)
        {
            return base.Select_Admin(admin);
        } 

        public new DataSet Select_one(string id, string pageName)
        {
            return base.Select_one(id, pageName);
        }

        public new void Delete_one(string id, string pageName)
        {
            base.Delete_one(id, pageName);
        }

        public new DataSet Update_Goodsmessage(Goodsmessage goods)
        {
            return base.Update_Goodsmessage(goods); ;
        }
 /// <summary>
        /// 修改专家信息
        /// </summary>
        /// <returns></returns>
        public new DataSet Update_Expertmessage(ExpertMessage expert)
        {
            return base.Update_Expertmessage(expert);
        }

                /// <summary>
        /// 修改土地信息
        /// </summary>
        /// <returns></returns>
        public new DataSet Update_Soilmessage(SoilMessage soil)
        {
           return base.Update_Soilmessage(soil);
        }

                /// <summary>
        /// 修改公告信息
        /// </summary>
        /// <returns></returns>
        public new DataSet Update_Notice(Notice not)
        {
            return base.Update_Notice(not);
        }

        /// <summary>
        /// 修改广告信息
        /// </summary>
        /// <returns></returns>
        public new DataSet Update_Advertisment(Advertisment advert)
        {
            return base.Update_Advertisment(advert);
        }

        /// <summary>
        /// 修改新闻信息
        /// </summary>
        /// <returns></returns>
        public new  DataSet Update_News(News news)
        {
            return base.Update_News(news);
        }

                /// <summary>
        /// 修改黄页信息
        /// </summary>
        /// <returns></returns>
        public new DataSet Update_Yellow(YellowPage yellow)
        {
            return base.Update_Yellow(yellow);
        }
        /// <summary>
        /// 修改政策信息
        /// </summary>
        /// <returns></returns>
        public new DataSet Update_publicity(Publicity pub)
        {
            return base.Update_publicity(pub);
        }
                            /// <summary>
        /// 修改技术信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Technical(Technical tech)
        {
            return base.Update_Technical(tech);
        }
        /// <summary>
        /// 查询模板显示值
        /// </summary>
        /// <param name="pageName"></param>
        /// <returns></returns>
        public new DataSet Select_pageS(string pageName)
        {
            return base.Select_pageS(pageName);
        }
    }

}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CUST;
using System.Data;
using System.Data.OracleClient;
using Snfinal01;
using Snfinal01.src.model;
using Snfinal01.src.util;

namespace Snfinal01
{
    public class OClient
    {
        /// <summary>
        /// 管理员登陆
        /// </summary>
        /// <param name="admin"></param>
        /// <returns></returns>
        protected DataSet Select_Admin(Admin admin)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {                              
                                           new OracleParameter("p_username",OracleType.VarChar,50),  
                                           new OracleParameter("p_password",OracleType.VarChar,50), 
                                           new OracleParameter ("p_mycurbm",OracleType.Cursor)
                                         };

                parameter[0].Value = admin.UserName;
                parameter[1].Value = admin.Password;
                parameter[2].Direction = ParameterDirection.Output;
                DataSet ds = db.RunProcedure("PACK_TEST.Select_admin_identity", parameter, "admin");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 查询模板
        /// </summary>
        /// <param name="page"></param>
        /// <param name="pageName"></param>
        /// <returns></returns>
        protected DataSet Select_page(PageHead page, string pageName)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {                                                                          
                                           new OracleParameter ("p_Textbox",OracleType.Number),
                                           new OracleParameter ("p_ThName",OracleType.Number), 
                                           new OracleParameter ("p_Type",OracleType.Number),
                                           new OracleParameter ("p_mycurbm",OracleType.Cursor)
                                         };

                parameter[0].Value = page.TextBox;
                parameter[1].Value = page.ThName;
                parameter[2].Value = page.Type;
                parameter[3].Direction = ParameterDirection.Output;
                DataSet ds = db.RunProcedure("PACK_TEST.Select_" + pageName + "Table", parameter, pageName);

                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 根据id查询一个
        /// </summary>
        /// <param name="id"></param>
        /// <param name="pageName"></param>
        /// <returns></returns>
        protected DataSet Select_one(string id, string pageName)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = { 
                                          new OracleParameter ("i_id",OracleType.Number ),
                                          new OracleParameter ("p_mycurbm",OracleType.Cursor)
                                          };

                parameter[0].Value = id;
                parameter[1].Direction = ParameterDirection.Output;

                DataSet ds = db.RunProcedure("PACK_TEST.Select_" + pageName + "_id", parameter, pageName);

                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 根据id删除单条信息
        /// </summary>
        /// <param name="id"></param>
        /// <param name="pageName"></param>
        /// <returns></returns>
        protected void Delete_one(string id, string pageName)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = { 
                                          new OracleParameter ("i_id",OracleType.Number ),
                                          new OracleParameter ("p_mycurbm",OracleType.Cursor)
                                          };

                parameter[0].Value = id;
                parameter[3].Direction = ParameterDirection.Output;

                db.RunProcedure("PACK_TEST.Delete_" + pageName, parameter, pageName);


            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 修改商品信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Goodsmessage(Goodsmessage goods)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_extendedid",OracleType.Number),
                                           new OracleParameter ("p_names",OracleType.VarChar ,30),
                                           new OracleParameter ("p_picture",OracleType.VarChar ,1000),
                                           new OracleParameter ("p_price",OracleType.Number),
                                           new OracleParameter ("p_preprice",OracleType.Number),
                                           new OracleParameter ("p_introduction",OracleType .VarChar ,2000),
                                           new OracleParameter ("i_id",OracleType.Number)
                                           };
                parameter[0].Value = goods.Extendedid;
                parameter[1].Value = goods.Names;
                parameter[2].Value = goods.Pictrue;
                parameter[3].Value = goods.Price;
                parameter[4].Value = goods.Preprice;
                parameter[5].Value = goods.Introduction;
                parameter[6].Value = goods.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_goodsmessage", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 修改专家信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Expertmessage(ExpertMessage expert)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_names",OracleType .VarChar,30),
                                           new OracleParameter ("p_head_portraite",OracleType.VarChar,1000),
                                           new OracleParameter ("p_birth",OracleType .VarChar ,30),
                                           new OracleParameter ("p_major",OracleType.VarChar,30),
                                           new OracleParameter ("p_dutytime",OracleType.VarChar,20),
                                           new OracleParameter ("p_info",OracleType.VarChar,100),
                                           new OracleParameter ("i_id",OracleType.Number)
                                           };
                parameter[0].Value = expert.Extendedid;
                parameter[1].Value = expert.Names;
                parameter[2].Value = expert.HeadPortrait;
                parameter[3].Value = expert.Birth;
                parameter[4].Value = expert.Major;
                parameter[5].Value = expert.Dutytime;
                parameter[6].Value = expert.Info;
                parameter[7].Value = expert.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_expertmessage", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 修改土地信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Soilmessage(SoilMessage soil)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_names",OracleType .VarChar,30),
                                           new OracleParameter ("p_picture",OracleType.VarChar,1000),
                                           new OracleParameter ("p_price",OracleType .Number),
                                           new OracleParameter ("p_conversion_property",OracleType.VarChar,30),
                                           new OracleParameter ("p_soilarea",OracleType.VarChar,30),
                                           new OracleParameter ("p_negotiable_year",OracleType.VarChar,30),
                                           new OracleParameter ("p_surplusyear",OracleType.VarChar,30),
                                           new OracleParameter ("p_land_warrants",OracleType.VarChar,30),
                                           new OracleParameter ("p_soilusing",OracleType.VarChar,100),
                                           new OracleParameter ("p_type",OracleType.VarChar,20),
                                           new OracleParameter ("p_validdate",OracleType.VarChar,100),
                                           new OracleParameter ("p_soillocation",OracleType.VarChar,1000),
                                           new OracleParameter ("p_contactway",OracleType.VarChar,100),
                                           new OracleParameter ("p_state",OracleType.VarChar,6),
                                           new OracleParameter ("i_id",OracleType.Number)
                                           };
                parameter[0].Value = soil.Extendedid;
                parameter[1].Value = soil.Names;
                parameter[2].Value = soil.Picture;
                parameter[3].Value = soil.Price;
                parameter[4].Value = soil.ConversionProperty;
                parameter[5].Value = soil.Soilarea;
                parameter[6].Value = soil.NegotiableYear;
                parameter[7].Value = soil.Surplusyear;
                parameter[8].Value = soil.LandWarrant;
                parameter[9].Value = soil.Soilusing;
                parameter[10].Value = soil.Type;
                parameter[11].Value = soil.Validdate;
                parameter[12].Value = soil.Soillocation;
                parameter[13].Value = soil.Contatway;
                parameter[14].Value = soil.State;
                parameter[14].Value = soil.Id;

                DataSet ds = db.RunProcedure("PACK_TEST.Update_soilmessage", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }
        /// <summary>
        /// 修改公告信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Notice(Notice not)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_title",OracleType .VarChar,30),
                                           new OracleParameter ("p_body",OracleType.VarChar,2000),
                                           new OracleParameter ("p_mainbody",OracleType .VarChar,110),
                                           new OracleParameter ("p_publishtime",OracleType.VarChar,100),
                                           new OracleParameter ("p_updatetime",OracleType.VarChar,100),
                                           new OracleParameter ("p_picture",OracleType.VarChar,1000),
                                           new OracleParameter ("p_type",OracleType.Number),
                                           new OracleParameter ("p_editor",OracleType.VarChar,1000)  ,
                                           new OracleParameter ("i_id",OracleType.Number)
                                           };
                parameter[0].Value = not.Extendedid;
                parameter[1].Value = not.Title;
                parameter[2].Value = not.Body;
                parameter[3].Value = not.Mainbody;
                parameter[4].Value = not.Publishtime;
                parameter[5].Value = not.Updatetime;
                parameter[6].Value = not.Picture;
                parameter[7].Value = not.Type;
                parameter[8].Value = not.Editor;
                parameter[9].Value = not.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_notice", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 修改广告信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Advertisment(Advertisment advert)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_title",OracleType .VarChar,20),                                       
                                           new OracleParameter ("p_mainbody",OracleType .VarChar,30),
                                           new OracleParameter ("p_body",OracleType.VarChar,200),
                                           new OracleParameter ("p_picture",OracleType.VarChar,1000), 
                                           new OracleParameter ("p_publishtime",OracleType.VarChar,100),
                                           new OracleParameter ("i_id",OracleType.Number)                
                                           };
                parameter[0].Value = advert.Title;
                parameter[1].Value = advert.Mainbody;
                parameter[2].Value = advert.Body;
                parameter[3].Value = advert.Picture;
                parameter[4].Value = advert.PublishTime;
                parameter[5].Value = advert.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_Advertisment", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }
        /// <summary>
        /// 修改新闻信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_News(News news)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_title",OracleType .VarChar,50),
                                           new OracleParameter ("p_mainbody",OracleType .VarChar,100),
                                           new OracleParameter ("p_body",OracleType.VarChar,2000),
                                           new OracleParameter ("p_publishtime",OracleType.VarChar,100),
                                           new OracleParameter ("p_updatetime",OracleType.VarChar,100),
                                           new OracleParameter ("i_id",OracleType.Number)  
                                           };
                parameter[0].Value = news.Extendedid;
                parameter[1].Value = news.Title;
                parameter[2].Value = news.Mainbody;
                parameter[3].Value = news.Body;
                parameter[4].Value = news.Publishtime;
                parameter[5].Value = news.UpdateTime;
                parameter[5].Value = news.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_news", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }
        /// <summary>
        /// 修改黄页信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Yellow(YellowPage yellow)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_institution_name",OracleType .VarChar,50),
                                           new OracleParameter ("p_contactmethod",OracleType .VarChar,50),
                                           new OracleParameter ("p_location",OracleType.VarChar,100),
                                           new OracleParameter ("p_picture",OracleType.VarChar,1000),
                                           new OracleParameter ("i_id",OracleType.Number)
                                           };
                parameter[0].Value = yellow.Extendedid;
                parameter[1].Value = yellow.InstitutionName;
                parameter[2].Value = yellow.Contactmethod;
                parameter[3].Value = yellow.Location;
                parameter[4].Value = yellow.Picture;
                parameter[4].Value = yellow.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_yellowpage", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }
        /// <summary>
        /// 修改政策信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_publicity(Publicity pub)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                        
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_title",OracleType .VarChar,100),
                                           new OracleParameter ("p_bodys",OracleType .VarChar,100),
                                           new OracleParameter ("p_type",OracleType.VarChar,100),
                                           new OracleParameter ("p_start_time",OracleType.VarChar,100),
                                           new OracleParameter ("p_update_timee",OracleType.VarChar,100),
                                           new OracleParameter ("p_process",OracleType .VarChar,100),
                                           new OracleParameter ("p_name",OracleType .VarChar,100),
                                           new OracleParameter ("p_id_item",OracleType.VarChar,100),
                                           new OracleParameter ("i_id",OracleType.Number)
                                        
                                           };
                parameter[0].Value = pub.Extended;
                parameter[1].Value = pub.Title;
                parameter[2].Value = pub.Bodys;
                parameter[3].Value = pub.Type;
                parameter[4].Value = pub.StartTime;
                parameter[5].Value = pub.UpdateTime;
                parameter[6].Value = pub.Process;
                parameter[7].Value = pub.Name;
                parameter[8].Value = pub.IdItem;
                parameter[9].Value = pub.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_publicity", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }

        /// <summary>
        /// 修改技术信息
        /// </summary>
        /// <returns></returns>
        protected DataSet Update_Technical(Technical tech)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = {
                                        
                                           new OracleParameter ("p_extendedid",OracleType.VarChar,30),
                                           new OracleParameter ("p_title",OracleType .VarChar,30),
                                           new OracleParameter ("p_name",OracleType .VarChar,30),
                                           new OracleParameter ("p_body",OracleType.VarChar,200),
                                           new OracleParameter ("p_publishtime",OracleType.VarChar,100),
                                           new OracleParameter ("p_type",OracleType.Number),
                                           new OracleParameter ("i_id",OracleType.Number)
                                        
                                           };
                parameter[0].Value = tech.Extendedid;
                parameter[1].Value = tech.Title;
                parameter[2].Value = tech.Name;
                parameter[3].Value = tech.Body;
                parameter[4].Value = tech.Pulishtime;
                parameter[5].Value = tech.Type;
                parameter[6].Value = tech.Id;
                DataSet ds = db.RunProcedure("PACK_TEST.Update_technical", parameter, "table");
                return ds;
            }
            finally
            {
                db.Close();
            }
        }
/// <summary>
/// 查询模板显示值
/// </summary>
/// <param name="pageName"></param>
/// <returns></returns>
        protected DataSet Select_pageS(string pageName)
        {

            DBClass db = new DBClass();

            try
            {
                OracleParameter[] parameter = { 
                                          new OracleParameter ("myCur",OracleType.Cursor)
                                          };

                parameter[0].Direction = ParameterDirection.Output;

                DataSet ds = db.RunProcedure("PACK_TEST.Select_" + pageName, parameter, pageName);

                return ds;
            }
            finally
            {
                db.Close();
            }
        }

    }
}
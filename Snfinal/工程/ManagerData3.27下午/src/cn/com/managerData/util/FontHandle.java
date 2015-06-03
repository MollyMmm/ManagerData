package cn.com.managerData.util;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.Random;

/**
 * @author Adam.Z
 * @ClassName FontHandle
 * @Version 1.0
 * @ModifiedBy Adam.Z
 * @Copyright @ 2010 H&L Technology Inc.
 * @date 2010-10-4 14:21:19 PM
 * @description ��ȡttf�ļ������壬��Ҫ���ļ�������classpath��fonts���ڡ��������øð��е�������Ա�֤���岻��ϵͳ���ƺ�Ӱ��
 */
public class FontHandle{

   private static FileInputStream fi;
    private static BufferedInputStream fb;
    private static Font nf;
    
   
    public  Font getFont(String fileName){
	   
	   try{
		   String path = Thread.currentThread().getContextClassLoader().getResource("").getFile();
		   File file = new File(URLDecoder.decode(path,"UTF-8")+"fonts/"+fileName);
		   if(!file.exists()){
			   System.out.println("file not found");
			   return null;
		   }
		    fi = new FileInputStream(file);
			fb = new BufferedInputStream(fi);
			nf = Font.createFont(Font.TRUETYPE_FONT, fb);
			nf = nf.deriveFont(Font.BOLD, 22);
			return nf;
			
	   }catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   }finally{
		   try{
			   if(fb!=null)fb.close();
			   if(fi!=null)fi.close();
		   }catch(Exception e){
			   e.printStackTrace();
			   fb = null;
			   fi = null;
		   }
		   
	   }
	    
	    
   }
   
   public static void main(String args[]) {
	   System.out.println(new Random().nextInt(5)+1);
	/*  System.out.println(new FontHandle().getFont("1.ttf").getName());
	  System.out.println(new FontHandle().getFont("2.ttf").getName());
	  System.out.println(new FontHandle().getFont("5.ttf").getName());
	  System.out.println(new FontHandle().getFont("7.ttf").getName());
	  System.out.println(new FontHandle().getFont("13.ttf").getName());*/
   }
}

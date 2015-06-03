package cn.com.managerData.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

public class UploadFileUtil {
	public static Map<String, String> fileUpload(HttpServletRequest request) {
	
		Map<String, String> map = new HashMap<String, String>();
System.out.println("--------------上传1---------------");		
		String path = request.getSession().getServletContext().getRealPath(File.separator + "mdt_upload");
System.out.println(path);		
		File forlder = new File(path);
		
		if(!forlder.exists()) {
			forlder.mkdir();
		}
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setSizeMax(5 * 1024 * 1024);
			
			InputStream in = null;
			
			OutputStream out = null;
			
			FileItemIterator it = null;
			
			try {
				it = upload.getItemIterator(request);
				
				while(it.hasNext()) {
					FileItemStream item = it.next();
					
					String key = item.getFieldName();
System.out.println("-------key:-------"+key);					
					in = item.openStream();
					
					if(item.isFormField()) {
						String value = Streams.asString(in, "UTF-8");
						map.put(key, value);
					} else {
						if(in.available() < 5 * 1024 * 1024) {
							String fileName = item.getName();
							
							int start = fileName.lastIndexOf("\\");
							
							if(start > 0) {
								fileName = fileName.substring(start + 1);
							}
							
							String saveName = new Date().getTime() + "_" + fileName;
							String savePath = path+"\\"+saveName;
							map.put(key, savePath);
System.out.println("-------value:-------"+savePath);		
							out = new FileOutputStream(new File(path, saveName));
							
							byte[] buffer = new byte[512];
							
							int length = 0;
							
							while((length = in.read(buffer)) > 0) {
								out.write(buffer, 0, length);
							}
							
						} else {

							map.put(key, null);
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(in != null) {
						in.close();
					}
					if(out != null) {
						out.flush();
						out.close();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {

			return null;
		}
		
		return map;
	}
}
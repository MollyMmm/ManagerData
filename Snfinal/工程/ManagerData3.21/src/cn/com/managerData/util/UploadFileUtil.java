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
		/*创建map对象对request中的表单内容进行封装*/
		Map<String, String> map = new HashMap<String, String>();
		
		/*获得文件上传到服务器上的真实路径*/
		String path = request.getSession().getServletContext().getRealPath(File.separator + "mdt_upload");
		
		/*创建文件目录对象*/
		File forlder = new File(path);
		
		/*如果目录不存在*/
		if(!forlder.exists()) {
			/*创建一个*/
			forlder.mkdir();
		}
		
		/*获得请求是否是文件上传的类型，如果是，则进行文件上传 [表单中 enctype是否为 multipart/form-data]*/
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		/*如果是*/
		if(isMultipart) {
			/*创建磁盘工厂*/
			DiskFileItemFactory factory = new DiskFileItemFactory();
			/*创建ServletFileUpload对象 [暴露给程序员直接使用的工具类]*/
			ServletFileUpload upload = new ServletFileUpload(factory);
			/*定义文件最大不过5M*/
			upload.setSizeMax(5 * 1024 * 1024);
			/*声明输入流*/
			InputStream in = null;
			/*声明输出流*/
			OutputStream out = null;
			/*声明迭代器*/
			FileItemIterator it = null;
			
			try {
				/*分析请求中的表单,返回迭代器*/
				it = upload.getItemIterator(request);
				
				/*遍历迭代器 */
				while(it.hasNext()) {
					/*获得每个表单数据的流对象[每个输入的input标签]*/
					FileItemStream item = it.next();
					/*用标签中的name属性作为key值*/
					String key = item.getFieldName();
					/*将表单数据的流对象返回输入流*/
					in = item.openStream();
					
					/*判断是否是普通表单*/
					if(item.isFormField()) {//如果是
						/*存储普通表单的内容 */						
						if(map.containsKey(key)) {
							String value = map.get(key) + "," + Streams.asString(in, "UTF-8");
							map.put(key, value);
						} else {
							String value = Streams.asString(in, "UTF-8");
							map.put(key, value);
						}
						
					} else {//如果不是 就是 文件域标签
						if(in.available() < 5 * 1024 * 1024 && in.available() > 0) {//限制图片大小不超过5M
							/*获取选择文件的文件名称*/
							String fileName = item.getName();
							/*判断时候带有路径IE浏览器上传文件带绝对路径*/
							int start = fileName.lastIndexOf("\\");
							/*是IE上传的文件*/
							if(start > 0) {
								/*从绝对路径中,截取文件名*/
								fileName = fileName.substring(start + 1);
							}
							/*生成文件存储在服务器上的文件名称  当前时间 毫秒+文件名 */
							String saveName = new Date().getTime() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
							/*存储图片名*/
							map.put(key, saveName);
							/*实例化输出流对象*/
							out = new FileOutputStream(new File(path, saveName));
							/*
							 将输入流里的内容写入到输出流中，目的是在程序上下文的ly115_upload文件夹中创建用户上传的文件
							 流的输入输出 要借助于缓冲区，即使用字节数组,512为缓冲区大小-->512byte
							*/
							byte[] buffer = new byte[512];
							/*length代表读取的字节数量*/
							int length = 0;
							
							while((length = in.read(buffer)) > 0) {
								out.write(buffer, 0, length);
							}
							
						} else {
System.out.println("文件大小不符合规范");
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
					/*释放资源*/
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
System.out.println("表单内容类别不正确   可能是  method = 'post' 或 enctype = 'multipart/form-data'  属性定义不对");
			return null;
		}
		
		return map;
	}
}

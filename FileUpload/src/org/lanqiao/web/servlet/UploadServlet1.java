package org.lanqiao.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.utils.CommonUtils;

/**
 * 演示文件上传(处理了细节问题)
 * @author ronin
 *
 */
public class UploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		/**
		 * 上传三步
		 * 	1.得到工厂
		 * 	2.通过工厂创建解析器
		 * 	3.解析request,得到FileItem集合
		 * 	4.遍历FileItem集合,调用API完成文件的保存
		 */
		//1.创建工厂(上传文件时的缓存目录)
			//注意:文件大小为1*1024无法观察缓存效果
		DiskFileItemFactory factory = new DiskFileItemFactory(9*1024, new File("d:/temp"));
		//2.通过工厂创建解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		/**
		 * 此处设置文件大小
		 * 		注意:必须在解析开始之前调用
		 * 			解析方法:List<FileItem> fileItemList = sfu.parseRequest(request);
		 */
		//限制单个文件大小为100KB
		sfu.setFileSizeMax(100*1024);//FileSizeLimitExceededException
		//限制整个表单所有请求上传数据的大小//SizeLimitExceededException
		sfu.setSizeMax(100*1024);
		//3.得到list,解析list
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			FileItem file2 = fileItemList.get(1);
			//2.1获取文件的真实路径(磁盘路径)
			String root = this.getServletContext().getRealPath("/WEB-INF/files/");
			//System.out.println(root);
			//2.2生成二层目录
				//1)得到文件名称
				String filename = file2.getName();
				/*
				 * 处理文件名的绝对路径问题
				 */
				//System.out.println(filename);
				int index = filename.lastIndexOf("\\");
				if(index!=-1){
					filename = filename.substring(index+1);
				}
				/*
				 * 给文件名添加uuid前缀,处理文件同名问题
				 */
				String savename = CommonUtils.uuid()+"_"+filename;
				System.out.println("处理后的文件名:"+savename);
				//2.得到hashCode
				int hashCode = savename.hashCode();
				//3).转成16进制
				String hex = Integer.toHexString(hashCode);
				System.out.println("16进制的HashCode:"+hex);
				//4).获取前两个字符用来生成目录
				File dirFile = new File(root,hex.charAt(0)+"/"+hex.charAt(1));
				/**
				 * 创建目录链
				 */
				dirFile.mkdirs();
				/**
				 * 创建目录文件
				 */
				File descFile = new File(dirFile,savename);
				System.out.println("文件名:"+descFile.getName());
				System.out.println("文件路径:"+descFile.getPath());
				System.out.println(descFile.getAbsolutePath());
				/**
				 * 保存文件
				 */
				file2.write(descFile);
				System.out.println("文件大小:"+file2.getSize());
		} catch(FileUploadException e){
			if(e instanceof FileUploadBase.FileSizeLimitExceededException){
				response.getWriter().write("单个表单项上传的文件大小太大");
				e.printStackTrace();
			}else if(e instanceof FileUploadBase.SizeLimitExceededException){
				response.getWriter().write("整个表单上传的文件大小太大");
				e.printStackTrace();
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		} catch (FileSizeLimitExceededException e) {
//			response.getWriter().write("单个表单项上传的文件大小太大");
//			e.printStackTrace();
//		} catch(SizeLimitExceededException e){
//			response.getWriter().write("整个表单上传的文件大小太大");
//			e.printStackTrace();
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
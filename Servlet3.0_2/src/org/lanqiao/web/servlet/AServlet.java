package org.lanqiao.web.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示Servlet3.0的异步处理
 * @author ronin
 *
 */
@WebServlet(urlPatterns="/A",asyncSupported=true)
public class AServlet extends HttpServlet{
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		//注意:不设置编码会导致异步失败
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 非异步加载
		 */
		/*
		response.getWriter().write("Hello...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print("World");
		*/
		
		/**
		 * Servlet3.0实现异步加载 
		 * 	1.得到AsyncContext,异步上下文对象
		 * 	2.给上下文一个Runnable对象,启动它(给上下文一个任务,让它完成)
		 */
		
		
		/*
		 * 1.得到异步上下文
		 */
		AsyncContext asyncContext = request.startAsync(request,response);
		/*
		 * 2.给上下文一个Runnable对象,让它执行这个任务
		 */
		asyncContext.start(new Runnable(){

			@Override
			public void run() {
				println("现在马上开始:<br />",response);
				
				//线程休眠两秒钟
				sleep(2000);
				
				
				for(int i=0;i<10;i++){
					println(i+"",response);
					sleep(250);
				}
				
				//通知Tomcat异步结束
				asyncContext.complete();
			}
			
		});
		
	}
	
	public void println(String text,final HttpServletResponse resp){
		try {
			resp.getWriter().print(text);
			resp.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sleep(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

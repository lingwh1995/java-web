package org.lanqiao.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.lanqiao.entity.Product;
import org.lanqiao.services.ProductServices;
import org.lanqiao.utils.CommonUtils;


/**
 * 本项目演示使用令牌机制 避免表单数据重复提交
 * @author ronin
 *
 */
public class AddProductServlet extends HttpServlet {
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
		 * 令牌机制
		 */
		//1.获取session中的令牌和提交过来的令牌
			//session中的令牌
		String session_lingpai = (String) request.getSession().getAttribute("session_lingpai");
			//提交过来的令牌
		String r_lingpai = request.getParameter("r_lingpai");
		//2.移除session中的令牌
		request.getSession().removeAttribute("session_lingpai");
		//3.比较两个令牌
		if(session_lingpai==null||!session_lingpai.equals(r_lingpai)){
			//已经提交过
			System.out.println("页面已经提交过了...");
			//如果已经提交过了:就在这里使用return终止程序
			return ;
		}
		
		
		
		//1.封装数据
		Product product = new Product();
		try {
			//使用beanUtils封装来自页面中表单的数据(把数据先封装到一个map中)
			BeanUtils.populate(product, request.getParameterMap());
			/**
			 * 注意:Product这个javbean中有七个字段,页面只传来了四个，还有三个没有传过来,需要我们自己设置
			 */
			//1.1给商品设置id
			product.setPid(CommonUtils.getId());
			//1.2给商品设置时间
			product.setPdate(new Date());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//2.调用service层中方法完成添加操作
		ProductServices productServices = new ProductServices(); 
		try {
			productServices.addProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("添加商品失败...");
		}
		//3.跳转到查询所有商品的servlet
			//使用请求转发跳转会导致表单数据重复提交,解决方式有两种:
			//方式一:使用重定向而不是使用请求转发
		//response.sendRedirect(request.getContextPath()+"/QueryAllProductServlet");
		
		
		//方式二:令牌机制
		request.getRequestDispatcher("/QueryAllProductServlet").forward(request, response);
	}
}

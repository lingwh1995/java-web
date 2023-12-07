package org.lanqiao.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.utils.CookieUtils;

public class GetGoodsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.设置编码
		response.setContentType("text/html;charset=UTF-8");
		//2.获取指定的Cookie ids 和当前访问的商品id
		Cookie cookie = CookieUtils.getCookByName("ids", request.getCookies());
		String id = request.getParameter("id");
		String ids = "";//ids负责存放来自前台的多个id,所以叫ids
		//3.判断Cookie是否为空
			if(cookie==null){
				//Cookie为空,需要将当前商品id放在ids中
				ids = id;
			}else{
				//Cookie不为空,ids的值就是key为ids的cookie的value，继续判断ids中是否包含该商品的id
				//获取key为ids的cookie的value(这个value为String类型到的数据),并将这个value赋值给ids
				ids = cookie.getValue();
				//将ids(即key为ids的cookie的value)这个字符串转换为数组类型,再把数组转换为集合类型数据
					/*
					 * 数组转换为集合有两种方法:
					 * 		方法1.直接转换:Arrays.asList(数组名称)
					 * 		方法2.间接转换:
					 * 			 	List arrList = Arrays.asList(数组名称);//数组-->List
					 * 				LinkedList list = new LinkedList(arrList);//构造一个新的List
					 * 注意:为什么不直接把数组改转换为集合类型的数据,因为方法1生成的List本质还是一个数组,也就是说其长度是不可改变的
					 * 	      如果要生成一个长度可变的List,则需要再使用List的构造方法进行构造，这样才能得到一个新的长度可变的List
					 * 提升:在构造List集合的时候,要注意选择List集合的类型,合理到的选择ArrayList和LinkedList集合
					 */
				
				//字符串-->数组
				String[] idsArr = ids.split("-");
				//数组-->长度不可变到的List集合
				List<String> idsListTemp = Arrays.asList(idsArr);
				//长度不可变到的List集合-->正常的List集合(长度可变的)
				LinkedList<String> list = new LinkedList<String>(idsListTemp);
				if(list.contains(id)){
					//若ids包含id,将id移除放到最前面
					list.remove(id);
					list.addFirst(id);
				}else{
					//若ids不包含id,则继续判断是否大于2
					if(list.size()>2){
						//List的长度>=3移除最后一个,并且将id放在最前面(目的是为了控制最近浏览的商品的显示数量为3个)
						list.removeLast();
						list.addFirst(id);
					}else{
						//List的长度<3,直接将当前的id放在最前面
						list.addFirst(id);
					}
					ids = "";
				//将list转换成字符串，并赋值给ids((即赋值给key为ids的cookie的value)这个字符
					for(String s:list){
						ids += (s+"-");
					}
					ids = ids.substring(0,ids.length()-1);
				}
			}
			//将ids写回去
			cookie = new Cookie("ids",ids);//将xxx-格式化为xxx
			//设置访问路径(将Cookie的path设置为当前项目的路径,这样访问路径无论如何都包含Cookie的path，所以此访问都可更新Cookie)
			cookie.setPath(request.getContextPath()+"/");
			//设置存活时间
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		//4.跳转到指定的商品页面(不携带任何信息，这里使用重定向就可以了)
		response.sendRedirect(request.getContextPath()+"/product_info"+id+".htm");
	}

}

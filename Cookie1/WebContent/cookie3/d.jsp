<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>演示Cookie的路径和域</h1>
	<hr />
	<%--
		 Cookie不仅可以设置过期时间，也可以设置路径。
		
		 Cookie的path
		  浏览器在访问BServlet时，是否要带上AServlet保存的Cookie呢？这要看Cookie的path了。
		  现有资源如下：
		  * http://localhost:8080/day06_2/servlet/AServlet
		  * http://localhost:8080/day06_2/servlet/BServlet，保存名为xxx的Cookie
		  * http://loclahost:8080/day06_2/servlet/CServlet，保存名为yyy的Cookie
		  * http://loclahost:8080/day06_2/servlet/user/DServlet, 保存名为zzz的Cookie
	 --%>
	 <pre>
	 	 Cookie的path
		  浏览器在访问BServlet时，是否要带上AServlet保存的Cookie呢？这要看Cookie的path了。
		  现有资源如下：
		  * http://localhost:8080/day06_2/servlet/AServlet
		  * http://localhost:8080/day06_2/servlet/BServlet，保存名为xxx的Cookie
		  * http://loclahost:8080/day06_2/servlet/CServlet，保存名为yyy的Cookie
		  * http://loclahost:8080/day06_2/servlet/user/DServlet, 保存名为zzz的Cookie
		
		  // 没有设置Cookie的path
		  AServlet {
		     Cookie c = new Cookie("xxx", "XXX");
		     response.addCookie(c);
		  }
		  // 设置了Cookie的path为/day06_2
		  CServlet {
		     Cookie c = new Cookie("yyy", "YYY");
		     c.setPath="/day06_2";
		    response.addCookie(c);
		  }
		  DServlet {
		    Cookie c = new Cookie("zzz", "ZZZ");
		    resposne.addCookie(c);
		  }
		
		  
		  在BServlet中保存的Cookie没有设置path，那么它的path默认为当前BServlet的所在路径，即“/day06_2/servlet”。
		  在CServlet中保存的Cookie设置了path为/day06_2。
		  在DServlet中保存的Cookie没有设置path，那么它的path默认为DServlet的所在路径，即“day06_2/servlet/user”
		
		
		  当访问AServlet时，是否要带上xxx这个Cookie呢？因为AServlet的访问路径为/day06_2/servlet/BServlet，它包含了xxx的path，即/day06_2/servlet，所以需要带上。
		
		  当访问AServlet时，是否要带上yyy这个Cookie呢？因为AServlet的访问路径为/day06_2/servlet/BServlet，它包含了xxx的path，即/day06_2，所以需要带上。
		
		  当访问AServlet时，是否要带上zzz这个Cookie呢？因为AServlet的访问路径为/day06_2/servlet/BServlet，它不包含zzz的path，即/day06_2/servlet/user，所以不会带上。
		
		  
		 Cookie的domain
		  Cookie的path是在同一主机中指定共享Cookie，如果主机不同那么就一定不能共享Cookie，无论path是什么。
		  如果希望不同的二级域名中可以共享Cookie，那么就要设置Cookie的domain了。
		  例如：news.baidu.com、tieba.baidu.com、zhidao.baidu.com，它们的域名不同，但百度希望它们之间可以共享Cookie，那么就要设置domain了。
		
		  1). 设置Cookie的path为“/”，例如：cookie.setPath("/");
		  2). 设置Cookie的domain，例如：cookie.setDomain(".baidu.com")，其中domain中没有指定域名前缀！
		
		  在news.baidu.com主机中的某个项目中保存了Cookie
		  在tieba.baidu.com主机中某个项目中获取Cookie
		
		  当然这需要配置两个虚拟主机才行。
		  
	 </pre>
</body>
</html>
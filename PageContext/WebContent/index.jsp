<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>原生的pageContext域对象(pageContext.setAttribute()这个方法未重载)</h1>
	<%
		pageContext.setAttribute("pageContext", "原生的pageContext");
	%>
	<%="从原生的pageContext获取值---------"+pageContext.getAttribute("pageContext") %><br />
	
	<hr />
	
	
	<h1>pageContext作用1:通过pageContext给四个域对象赋值并取值,即通过pageContext操作其他域对象(一个顶四个,pageContext.setAttribute()这个方法重载了)</h1>
	<!-- 
		JSP中四大域对象及作用范围(从大到小):
		application        整个项目
        session            一次会话
        request            一次请求
        pageContext        一个页面(注意:1.四大域最小的域为pageContext,而不是page,page为9大内置对象之一2.pageContext也是九大内置对象之一)
        
        pagecontext作用:理解
        1.域对象
            xxxAttribute()
        2.操作其他域对象
                    方法:
                xxxAttribute(...,int scope);
                    scope取值:
                        APPLICATION_SCOPE
                        SESSION_SCOPE
                        REQUEST_SCOPE
                        PAGE_SCOPE
        3.获取其他的内置对象
            getXxx()
               注意:
                getRequest():获取request内置对象
        4.便捷查找,
            findAttribute(String key):
                依次从pagecontext,request,session,application四个域中,查找相应的属性,若查找到了返回值,且结束该次查找
                若查找不到,返回一个null
        
	 -->
	<%
		//设置域对象的范围为request,通过pageContext给request域中放一个值
		pageContext.setAttribute("pageKey", "pageValue", pageContext.PAGE_SCOPE);
	%>
	<!-- 从page域中获取值 -->
	<%="page域中的值是---------"+pageContext.getAttribute("pageKey") %><br />
	
	
	
	
	<%
		//设置域对象的范围为request,通过pageContext给request域中放一个值
		pageContext.setAttribute("requestKey", "requestValue", pageContext.REQUEST_SCOPE);
	%>
	<!-- 从request域中获取值 -->
	<%="request域中的值是---------"+request.getAttribute("requestKey") %><br />
	
	
	
	<%
		//设置域对象的范围为session,通过pageContext给session域中放一个值
		pageContext.setAttribute("sessiontKey", "sessionValue", pageContext.SESSION_SCOPE);
	%>
	<!-- 从session域中获取值 -->
	<%="session域中的值是---------"+session.getAttribute("sessiontKey") %><br />
	
	
	
	<%
		//设置域对象的范围为application,通过pageContext给application域中放一个值
		pageContext.setAttribute("applicationKey", "applicationValue", pageContext.APPLICATION_SCOPE);
	%>
	<!-- 从application域中获取值 -->
	<%="application域中的值是---------"+application.getAttribute("applicationKey") %><br />
	
	<hr />
	
	<h1>pageContext作用2:通过pageContext对象获取其他内置对象</h1>
	<%
		/*
		JSP九大内置对象及其对应的类型:
		out                JspWriter
        request            HttpServletRequest
        response           HttpServletResponse
        session            HttpSession

        exception          Throwable

        page               Servlet(this)
        config             ServletConfig
        application        ServletContext

        pageContext        PageContext
		*/
		//JSP通过pageC获取其他8大内置对象
		
	 	//1..获取page对象
	 	pageContext.getPage();
	
	 	//2.获取request对象
	 	pageContext.getRequest();
	 	
	 	//3.获取session对象
	 	pageContext.getSession();
	 	
	 	//4.获取application对象
	 	pageContext.getServletContext();
	 	
		//5.获取out对象
		pageContext.getOut();
		
	 	//6.获取response对象
	 	pageContext.getResponse();
	 	
	 	//7.获取exception对象
	 	pageContext.getException();
	 	
	 	//8.获取config
	 	pageContext.getServletConfig();
	%>
	<hr />
	<h1>pageContext作用3:全域查找</h1>
		<%
			/*
			pageContext全域查找:
			依次从pagecontext,request,session,application四个域中,查找相应的属性,若查找到了返回值,且结束该次查找
                        若查找不到,返回一个null

			*/
			//pageContext.setAttribute("key", "pageContext");
			request.setAttribute("key", "request");
			session.setAttribute("key", "session");
			application.setAttribute("key", "application");
		%>
		<%="pageContext的全域查找功能(查找的到:返回查找到的值)---------"+pageContext.findAttribute("key") %><br />
		<%="pageContext的全域查找功能(查找不到:返回null)---------"+pageContext.findAttribute("key1111") %><br />
</body>
</html>
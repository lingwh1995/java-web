<%@ page language="java" import="org.lanqiao.demo.*,java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//放置简单数据
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		//放置对象类型的数据
		User u1 = new User(1,"zhangsan");
		request.setAttribute("user", u1);
		//获取含有对象的对象
		Address address = new Address("西安","长安");
		u1.setAddress(address);
		//获取List集合元素
		List<User> list = new ArrayList<User>();
		User u2 = new User(2,"lisi");
		User u3 = new User(3,"wangwu");
		User u4 = new User(4,"zhaoliu");
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		request.setAttribute("list", list);
		//获取Map集合中的数据
		Map<String,User> map = new HashMap<String,User>();
		map.put("u1",u1);
		map.put("u2",u2);
		map.put("3",u3);
		map.put("4",u4);
		session.setAttribute("map", map);
		//综合练习，获取Map集合中的List集合
		Map<String,List<User>> ulistMap = new HashMap<String,List<User>>();
		ulistMap.put("1", list);
		request.setAttribute("ulistMap", ulistMap);
	%>
	
	<h3>使用EL表达式的目的：代替JSP页面中的java代码</h3>
	<h3>EL表达式秘诀：每一步完成之后要清楚的知道得到是哪个对象以及知道对象的类型</h3>
	<h4>获取简单的数据</h4>
	name:${name}<br />
	name:${name}
	<p>
	注意：1.使用EL表达式不需要引入任何第三方类库，直接就可以在JSP页面中使用
		2.使用EL表达式取值的时候，EL表达式不能书写在Java代码中
		3.EL表示默认搜索范围是从小范围到大范围
	</p>
	<h4>获取对象类型的数据</h4>	
	<h5>使用get/set方法来获取数据</h5>
	user_name:${user.getName()}<br />
	user_id:${user.getId()}<br />
	<h5>使用对象.属性来获取数据</h5>
	user_name:${user.name}<br />
	user_id:${user.id}<br />
	user_name:${user}
	<p>
	注意：1.可以使用get/set方法来获取数据，也可以通过   对象.属性来获取数据
		2.使用EL自带输出效果，不用在单独输出到页面
	</p>
	<h4>获取对象里面的对象(User中Address)</h4>	
	User_Address_city:${user.address.city }<br />
	User_Address_street:${user.address.street}
	<p>注意：获取对象中的对象类似于获取对象中的属性</p>
	<h4>获取List集合中的数据</h4>
	list_u1_name:${list[0].name }<br />
	list_u2_name:${list[1].name }<br />
	list_u3_name:${list[2].name }<br />
	list_u4_name:${list[3].name }<br />
	<p>注意:获取List中的每一个元素要通过下标获取，类似于访问数组的中的元素</p>
	<h4>获取Map集合中的数据</h4>
	<h5>当key为字符串的时候，通过map的key来获取，格式为：Map名称.Map里面包含的key名称.Map里面value包含的属性</h5>
	map_u1_id:${map.u1.id }<br />
	map_u1_name:${map.u1.name }<br />
	map_u2_id:${map.u2.id }<br />
	map_u2_name:${map.u2.name }
	<p>注意：当Map集合的key值为数字的时候，需要特殊处理，用中括号括起来，把对应键提供用引号引起来</p>
	map_u3_id:${map["3"].id }<br />
	map_u3_name:${map["3"].name }<br />
	<hr />
	map_u1_name:${map["u1"].id }<br />
	map_u1_name:${map["u1"].name }
	<p>注意：这种写法是万能的，不仅使用于Map的键是字符串类型的数字的情况，也适用于Map的键是字符串的情况</p>
	<hr />
	<h4>获取Map中的list中的u1的name属性</h4>
	map_list_user_name:${ulistMap["1"][0].name}
</body>
</html>
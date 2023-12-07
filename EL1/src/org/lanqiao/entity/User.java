package org.lanqiao.entity;
/**
 * JavaBean的注意事项:
 * 字段和属性的区别:
 * 
 * private String id;
 * private String username;
 * private String password;
 * 
 * 这里的 id、username、password称为字段
 * 
 * public String getId() {
 *	return id;
 * }
 * 将getId中的id才称为属性,同理getUsername中的username称为属性(方法名去掉get或者Set然后首字母小写,就称之为属性)
 * @author ronin
 *
 */
public class User {
	private String id;
	private String username;
	private String password;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	//注意这个get方法和自动生成的是不同的,用于测试属性和字段的区别
	public String getName() {
		return username;
	}

	//注意这个set方法和自动生成的是不同的,用于测试属性和字段的区别
	public void setName(String username) {
		this.username = username;
	}

	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

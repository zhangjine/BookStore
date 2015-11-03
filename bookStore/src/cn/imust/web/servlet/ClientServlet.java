package cn.imust.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.imust.domain.Customer;
import cn.imust.service.CustomerService;
import cn.imust.service.impl.CustomerServiceImpl;
import cn.imust.utils.IDGenerator;
/**
 * 前端控制器
 * @author yang
 *
 */
public class ClientServlet extends HttpServlet {

	private CustomerService customerService = new CustomerServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //1.解决乱码问题
		request.setCharacterEncoding("UTF-8");   //post乱码
		response.setContentType("text/html;charset=UTF-8");//响应结果没有乱码
		
		//2.用一个参数op代表用户的操作类型
		String op = request.getParameter("op");
		
		//3.判断用户的操作类型
		if("login".equals(op)){
			//登录
			login(request,response);
		}else if("logout".equals(op)){
			//注销
			logout(request,response);
		}else if("modifyUserinfo".equals(op)){
			//修改用户信息
			modifyUserinfo(request,response);
		}else if("register".equals(op)){
			register(request,response);
		}
	}
	// 注册
	private void register(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		//1.获取每个文本框的值   beanUtils框架实现封装  commons-beanutis.jar   commmons-logging-xx.jar
		Customer customer = new Customer ();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		//2.校验（省略，因为简单    但是它很重要）
		//3.判断用户输入的验证码是否正确
		String inputCode = request.getParameter("captchaImage");
		String code = (String) request.getSession().getAttribute("code");
		if(code.equals(inputCode)){
			//4.调用业务方法，实现添加功能 
			//对于没有赋值的属性进行手动赋值
			customer.setId(IDGenerator.genID());
			customer.setActived(0);//未激活
			customer.setCode(IDGenerator.genCode());
			customer.setRole(0);//普通用户
			customerService.regist(customer);
			//5.跳转到registersuccess.jsp
			response.sendRedirect(request.getContextPath()+"/registersuccess.jsp");
		}else {
			//6.验证码输入有误
			response.getWriter().write("对不起，验证码输入有误！请重试");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/register.jsp");
		}
	
	}
	//修改用户信息
	private void modifyUserinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//1.获取文本框 的取值
		 String password =  request.getParameter("password");
		 String sex =  request.getParameter("sex");
		 String telephone =  request.getParameter("telephone");
		String id =  request.getParameter("id");
		//2.更新对象中的属性值
		 HttpSession session = request.getSession();
		 Customer customer = (Customer) session.getAttribute("user");
		 customer.setPassword(password);
		 customer.setSex(sex);
		 customer.setTelephone(telephone);
		//3.调用业务方法，实现更新操作
		customerService.update(customer);
		//4.将session中用户信息更新
		//session.setAttribute("user", customer);//没有必要
		
		//5.跳转到更新成功页面
		response.sendRedirect(request.getContextPath()+"/modifyUserInfoSuccess.jsp");
	}
	//注销
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//1.就是将session域中的用户信息清除
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	//登录
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//1.获取用户名，密码两个框的值
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		//2.调用业务逻辑代码
		Customer customer  = customerService.login(username, password);
		//3.根据查询的结果，判断用户登录是否成功
		if(customer!=null){
			//4.1 如果成了，将用户信息保存到session中
			request.getSession().setAttribute("user", customer);
			//4.2 跳转到显示商品列表页面
			response.sendRedirect(request.getContextPath()+"/product_list.jsp");
		}else{
			//5.如果失败了
			response.getWriter().write("对不起，登录失败，请重新登录！");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/login.jsp");
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}

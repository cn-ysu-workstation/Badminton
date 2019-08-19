package cn.yd.badminton.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.yd.badminton.po.Administrator;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;





public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		//判断用户是否已经登陆（登陆的用户信息在session中）
		HttpSession session = request.getSession();
		//从session中取出用户身份信息
		Administrator administrator = (Administrator) session.getAttribute("Administrator");
		
		if(administrator != null){
			//已经登陆，放行
			return true;
		}else{
			//去登陆页面登陆
			request.getRequestDispatcher("/jsp/Login/login.jsp").forward(request, response);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		
	}
}

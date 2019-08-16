package cn.yd.badminton.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * 
 * Exception ex 就是系统抛出并截获的异常
 * */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		//Handler就是处理器适配器要执行的Handler对象（只有method）
		
		//解析出异常类型
		//如果该异常类型是自定义的异常，直接取出异常信息，在错误页面展示。（我们定义的异常）
		/*String message = null;
		if(ex instanceof CustomException){
			//((CustomException)ex)将系统自定义异常转换成自定义异常类型
			message = ((CustomException)ex).getMessage();
		}else{
			//如果该异常类型不是自定义的异常，构造一个自定义的异常类（信息为“未知错误”）
			//不是系统自定义异常，一般都是运行异常，原因一般都不明确，造成的原因很多，比如时间不同步
			//网络波动等等，提示“未知错误”即可
			message = "未知错误";
		}*/
		
		
		//上面的代码可以写成：
		/*	我们通过判断异常类型将异常放入CustomException中（是对象），
		 * 	在通过CustomException.getMessage()获取到信息
		 * */
		CustomException customException = null;
		if(ex instanceof CustomException){//如果异常类型是自定义异常类型
			customException = (CustomException)ex;//转换成自定义异常类型
		}else{//否则是运行异常的话
			customException = new CustomException("未知错误");//给构造函数赋值"未知错误"
		}
		
		//错误信息（不管什么异常，错误信息都放到了customException中）
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		
		//将错误信息传到页面
		modelAndView.addObject("message",message);
		
		//调用页面
		modelAndView.setViewName("error");

		return modelAndView;
	}

}

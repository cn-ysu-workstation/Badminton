package cn.yd.badminton.exception;

/**
 * 自定义异常类，针对预期的异常（就是自己判断可能出现的错误，比如：
 * 插入数据失败，我们想提示“插入失败”这些。在PHP中一般直接输出错误信息
 * 在java中通过异常来实现打印错误~~~）
 * 
 * 通过自定义的全局异常处理器CustomExceptionResolver获取到信息
 * 放入这里，在从该类对象中拿到message信息替换到页面输出。
 * */
public class CustomException extends Exception {
	
	//异常信息
	public String message;
	
	public CustomException(String message) {
		super(message);//调用父类的构造方法，以免重写父类构造中的内容
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

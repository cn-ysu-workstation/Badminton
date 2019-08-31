package cn.yd.badminton.webconfig;

import cn.yd.badminton.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/*
* 添加静态资源访问
* */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {


    /*
    * 重写父类WebMvcConfiguration中的addInterceptors方法可以实现添加拦截器
    * addPathPatterns 添加拦截器规则
    * excludePathPatterns 用户访问拦截排除
    * @parm registry
    * */
    public void addInterceptors(InterceptorRegistry registry)
    {
        /*InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        interceptorRegistration.excludePathPatterns("/error");
        interceptorRegistration.excludePathPatterns("/jsp/**");
        interceptorRegistration.excludePathPatterns("/Administrator/toLogin");
        interceptorRegistration.excludePathPatterns("/Administrator/Login");
        interceptorRegistration.addPathPatterns("/**");*/
    }

    /*
    * 重写父类WebMvcConfigurationSupport中的addResourceHandler方法可以实现对静态资源的访问
    * addResourceHandler 这里写的是指xxx项目下的所有资源(xxx代表当前项目)
    * addResourceLocations 这里写的是指所有资源会被解析为classpath:/
    * @param registry
    * */
   /* protected  void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry)
    {
        resourceHandlerRegistry.addResourceHandler("/jsp/**").addResourceLocations("classpath:/jsp/");
        logger.info("--------- addResiyceHandeler方法---");
        super.addResourceHandlers(resourceHandlerRegistry);
    }*/

   /* @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/Administrator/toLogin");
        super.addViewControllers(registry);
    }*/
}

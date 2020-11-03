package cn.tedu.store.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.store.interceptor.LoginInterceptor;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器
		HandlerInterceptor interceptor = new LoginInterceptor();
		//添加白名单
		List<String> patterns = new ArrayList<String>();
		patterns.add("/users/reg");
		patterns.add("/users/login");
		patterns.add("/web/register.html");
		patterns.add("/web/login.html");
		patterns.add("/css/**");
		patterns.add("/images/**");
		patterns.add("/js/**");
		patterns.add("/bootstrap3/**");
		
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
		
	}

	

}

package com.example.sbp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.sbp.interceptor.HelloInterceptor;

@Configuration
public class SbpWebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HelloInterceptor())
				.addPathPatterns("/hello");
	}

}

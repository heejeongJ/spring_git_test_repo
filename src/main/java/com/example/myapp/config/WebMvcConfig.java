package com.example.myapp.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class WebMvcConfig implements WebMvcConfigurer{

	@Bean(value = "localeResolver")
	LocaleResolver localeResolver() {
		
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.KOREAN);		// 기본 로케일을 한국어로 설정 
		
		return slr;
	}
	
	@Bean(value = "messageSource")
	MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = 
				new ResourceBundleMessageSource();
		
		messageSource.setBasenames("i18n/message");
		messageSource.setDefaultEncoding("UTF-8");	// 국제화 설정 파일의 위치 지정 및 인코딩 설정 
		
		return messageSource;
	}
	
	@Bean(value = "localeChangeIntercepter")
	LocaleChangeInterceptor lacaleChangeInterceptor() {
		
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");	// lang 파라미터를 이용해서 로케일 변경하는 인터셉터 빈 
		
		return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(lacaleChangeInterceptor());	// 인터셉터 추가 
	}
}

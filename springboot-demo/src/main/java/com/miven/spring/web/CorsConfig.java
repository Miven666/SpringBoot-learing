package com.miven.spring.web;

import com.miven.spring.context.XmzSampleBeanDefinitionRegistrar;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置类
 * @author mingzhi.xie
 * @date 2018/9/27
 */
@Configuration
@ConditionalOnClass(CorsFilter.class)
@Import(XmzSampleBeanDefinitionRegistrar.class)
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 指定授权访问的域
        corsConfiguration.addAllowedOrigin("*");
        // 授权请求的方法
        corsConfiguration.addAllowedMethod("*");
        // 授权请求的头
        corsConfiguration.addAllowedHeader("*");
        // 授权响应的头
        corsConfiguration.addExposedHeader("");
        // 凭证
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}

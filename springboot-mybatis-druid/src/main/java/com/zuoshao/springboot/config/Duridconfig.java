package com.zuoshao.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zuoshao
 * @date 2019/3/23 - 17:08
 */
@Configuration
public class Duridconfig {

    //将druid数据源注册到容器中
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }


    //配置监控
    //1，配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean staViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","zuoshao");//登录的用户名密码
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//允许谁访问  默认允许所有访问
//        initParams.put("deny","");//拒绝谁访问

        bean.setInitParameters(initParams);
        return bean;
    }

    //配置一个监控feilter

    //2、配置一个web监控的filter

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");//排除这些请求之外
        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));//拦截所有请求

        return bean;
    }


}


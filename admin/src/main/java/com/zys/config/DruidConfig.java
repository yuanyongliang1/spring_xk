package com.zys.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @USER 张英帅
 * @date 2020/10/17 - 14:49
 *
 * 访问路径
 * http://localhost:8001/druid/login.html
 */
@Configuration
public class DruidConfig {
    /**
     *  主要实现WEB监控的配置处理
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        // 现在要进行druid监控的配置处理操作
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet(), "/druid/*");
        /*
        //两种方式
            servletRegistrationBean.addInitParameter("allow", "127.0.0.1,172.29.32.54");    // 白名单,多个用逗号分割， 如果allow没有配置或者为空，则允许所有访问
            servletRegistrationBean.addInitParameter("deny", "192.168.1.110");              // 黑名单,多个用逗号分割 (共同存在时，deny优先于allow)
            servletRegistrationBean.addInitParameter("loginUsername", "admin");             // 控制台管理用户名
            servletRegistrationBean.addInitParameter("loginPassword", "eju1314");           // 控制台管理密码
            servletRegistrationBean.addInitParameter("resetEnable", "false");               // 是否可以重置数据源，禁用HTML页面上的“Reset All”功能
        */
        Map<String,String> initParams = new HashMap<>();

        initParams.put("loginUsername","admin");     // 控制台管理用户名
        initParams.put("loginPassword","123456"); // 控制台管理密码
        initParams.put("allow","");//默认就是允许所有访问
        initParams.put("deny","192.168.15.21");//拒绝xxx访问
        initParams.put("resetEnable","false");  //是否可以重置数据源

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean ;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean() ;
        /*
            filterRegistrationBean.setFilter(new WebStatFilter());
            //所有请求进行监控处理
            filterRegistrationBean.addUrlPatterns("/*");
            //添加不需要忽略的格式信息
            filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        */
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.jpg,*.css,/druid/*");
        bean.setInitParameters(initParams);     //添加不需要忽略的格式信息
        bean.setUrlPatterns(Arrays.asList("/*"));   //所有请求进行监控处理
        return bean ;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}

package com.walmart.ticket.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.walmart.ticket.TicketController;
import com.walmart.ticket.aop.LoggingAspect;

@Configuration
@ComponentScan(basePackageClasses = {LoggingAspect.class, TicketController.class},
    resourcePattern = "*Controller.class")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableWebMvc
public class TestWebConfig extends WebMvcConfigurerAdapter {

}

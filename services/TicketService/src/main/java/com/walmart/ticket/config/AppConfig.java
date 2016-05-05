package com.walmart.ticket.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/** Configures application using spring. **/
@Configuration
@ComponentScan(basePackages = {"com.walmart.ticket.*"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@PropertySources(@PropertySource({"classpath:properties/application.properties"}))
public class AppConfig {

  /**
   * Creates a bean for accessing messages and error messages.
   *
   * @return the message corresponding to the message / error key.
   */
  @Bean(name = "messageSource")
  @Scope("singleton")
  public MessageSource createMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("i18n/user-messages", "i18n/error-messages");
    messageSource.setUseCodeAsDefaultMessage(true);
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  /**
   * Property placeholder.
   *
   * @return Property placeholder.
   */
  @Bean(name = "propertySourcesPlaceholderConfigurer")
  @Scope("singleton")
  public static PropertySourcesPlaceholderConfigurer getPlaceHolderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  /**
   * RequestMappingHandlerAdapter.
   *
   * @return RequestMappingHandlerAdapter.
   */
  @Bean(name = "requestMappingHandlerAdapter")
  @Scope("singleton")
  public static RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
    return new RequestMappingHandlerAdapter();
  }

}

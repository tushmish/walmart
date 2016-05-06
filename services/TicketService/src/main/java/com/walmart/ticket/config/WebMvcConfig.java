package com.walmart.ticket.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The Class WebMvcConfig.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  /**
   * Customizes contents' MIME type for data exchange.
   *
   * @param configurer
   *          content negotiation configurer.
   */
  @Override
  public final void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false).favorParameter(true).parameterName("mediaType")
        .ignoreAcceptHeader(true).useJaf(false).defaultContentType(MediaType.APPLICATION_JSON);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
   * configureMessageConverters(java.util.List)
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converters.add(converter);
    super.configureMessageConverters(converters);
  }
}

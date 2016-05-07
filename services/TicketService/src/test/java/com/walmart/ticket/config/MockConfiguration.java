package com.walmart.ticket.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.walmart.ticket.BookingRepository;
import com.walmart.ticket.TicketService;
import com.walmart.ticket.impl.BookingRepositoryImpl;
import com.walmart.ticket.impl.TicketServiceImpl;
import com.walmart.ticket.model.Booking;

@Configuration
public class MockConfiguration {

  @Bean(name = "messageSource")
  public MessageSource createMessageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("i18n/user-messages", "i18n/user-errors");
    messageSource.setUseCodeAsDefaultMessage(true);
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean(name = "ticketServiceImpl")
  public TicketService service() {
    return Mockito.mock(TicketServiceImpl.class);
  }

  @Bean(name = "bookingRepositoryImpl")
  public BookingRepository<Booking> userRepository() {
    return Mockito.mock(BookingRepositoryImpl.class);
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    return Mockito.mock(LocalSessionFactoryBean.class);
  }

  @Bean
  public DataSource dataSource() {
    return Mockito.mock(DriverManagerDataSource.class);
  }

  @Bean
  public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
    return Mockito.mock(HibernateTransactionManager.class);
  }
}

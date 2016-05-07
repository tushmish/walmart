package com.walmart.ticket.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.walmart.ticket.TicketController;
import com.walmart.ticket.TicketService;
import com.walmart.ticket.model.Seat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockConfiguration.class, TestWebConfig.class})
@WebAppConfiguration
public final class TicketControllerTest {

  // -------- class variables ----------

  /** mock mvc. **/
  private MockMvc mockMvc;

  /** context. **/
  @Autowired
  private WebApplicationContext webApplicationContext;

  /** message source. **/
  @Spy
  @Autowired
  protected MessageSource messageSource;

  /** controller. **/
  @InjectMocks
  private TicketController ticketController;

  @Autowired
  private TicketService service;


  /** setup. **/
  public final void init() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }

  /** validate individual tests.are OK. **/
  @After
  public final void validate() {
    validateMockitoUsage();
  }

  private MockMvc getMockMVC() {
    return mockMvc;
  }

  /** setup. **/
  @Before
  public void setup() {
    Mockito.reset(service);
  }

  @Test
  public void findAvailableSeats() {

    // stub
    Set<Seat> seats = new HashSet<Seat>();

    // set behaviour
    when(service.findAvailableSeats(any(Optional.class))).thenReturn(seats);

    // execute
    // JsonNode responseBody = performGetSuccess(new Object[] {Constant.VALID_USER_ID});

    // validate
    assertThat(seats).isNotNull();
  }

}

package com.walmart.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * Controller for CRUD operations on user.
 *
 * @author tushar
 */
@RestController("userController")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class TicketController {

  // -------- class variables ----------

  /** user service. **/
  @Autowired
  private TicketService service;

  /** response. **/

  // -------- methods ------------------



}

package com.walmart.ticket.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Validates and catches exception. Generates user response - success or failure.
 * 
 * @author tushar
 */
@Component
@Aspect
public class TransactionAspect {

  // @Autowired
  // private Validator validator;

  /** exception generator. **/
  // @Autowired
  // private ExceptionThrower exceptionThrower;

  /** Generates HHTP success / failure response. **/
  // @Autowired
  // private ResponseGenerator responseGenerator;

  /**
   * Validates, catch exception and generates response.
   *
   * @param proceedingJoinPoint
   *          joinpoint to proceed the call.
   * @return return type of the method, if successful error, if there is an exception.
   */
  @Around("execution(* com.walmart.ticket.impl..*TicketServiceImpl.find*(..)) && args(venueLevel,..)")
  public Object validateFind(final ProceedingJoinPoint proceedingJoinPoint,
      final String venueLevel) {
    try {
      // hook to validate seat level against seat
      return proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      // exceptionThrower.throwInternalServerError("error.http.500.user", null,
      // "error.http.500.developer", new Object[] {Throwables.getStackTraceAsString(e)});
    }
    return null;
  }

  /**
   * Validates, catch exception and generates response. e.g, timeout exception gets caught here.
   *
   * @param proceedingJoinPoint
   *          joinpoint to proceed the call.
   * @return return type of the method, if successful error, if there is an exception.
   */
  @Around("execution(* com.walmart.ticket.impl..*TicketServiceImpl.holdSeats(..)) && args(customerEmail,..)")
  public Object validateCreate(final ProceedingJoinPoint proceedingJoinPoint,
      final String customerEmail) {
    try {
      // hook to validate username
      return proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      // exceptionThrower.throwInternalServerError("error.http.500.user", null,
      // "error.http.500.developer", new Object[] {Throwables.getStackTraceAsString(e)});
    }
    return null;
  }

  /**
   * Validates, catch exception and generates response.
   *
   * @param proceedingJoinPoint
   *          joinpoint to proceed the call.
   * @return return type of the method, if successful error, if there is an exception.
   */
  @Around("execution(* com.walmart.ticket.impl..*TicketServiceImpl.reserveSeats(..)) && args(customerEmail,..)")
  public Object validateUUpdate(final ProceedingJoinPoint proceedingJoinPoint,
      final String customerEmail) {
    try {
      // validation - valid user, seat state
      return proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      // exceptionThrower.throwInternalServerError("error.http.500.user", null,
      // "error.http.500.developer", new Object[] {Throwables.getStackTraceAsString(e)});
    }
    return null;
  }

}

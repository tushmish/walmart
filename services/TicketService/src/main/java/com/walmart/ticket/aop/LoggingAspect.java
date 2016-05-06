package com.walmart.ticket.aop;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Aspect class to log the methods invoked during a flow of control.
 *
 * @author tushar
 */
@Component
@Aspect
public class LoggingAspect {

  // -------- class variables ----------

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

  // -------- methods ------------------

  /**
   * An advice that logs the method details before execution.
   *
   * @param joinPoint
   *          the join point.
   */
  @Before("within(today.road.user..*)")
  public void logBeforeExecution(final JoinPoint joinPoint) {
    final StringBuilder message = new StringBuilder();
    message.append("Before ");
    addMethodDetails(joinPoint, message);
    LOGGER.info(message.toString());
    message.setLength(0);
    message.trimToSize();
  }

  /**
   * An advice that logs the method details after execution.
   *
   * @param joinPoint
   *          the join point.
   */
  @After("within(today.road.user..*)")
  public void logAfterExecution(final JoinPoint joinPoint) {
    final StringBuilder message = new StringBuilder();
    message.append("After ");
    addMethodDetails(joinPoint, message);
    LOGGER.info(message.toString());
    message.setLength(0);
    message.trimToSize();
  }

  /**
   * explodes method names, parameters to be logged.
   * 
   * @param joinPoint
   *          the join point
   * @param message
   *          logging message
   */
  private void addMethodDetails(final JoinPoint joinPoint, final StringBuilder message) {
    message.append("Class: " + joinPoint.getTarget().getClass().getSimpleName());
    message.append(", Method: " + joinPoint.getSignature().getName());
    final Object[] args = joinPoint.getArgs();
    if (args != null && args.length > 0) {
      message.append(", Arguments: " + StringUtils.join(args, ","));
    }
  }
}

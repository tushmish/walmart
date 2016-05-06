package com.walmart.ticket.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Initializes loading of application.
 *
 * @author tushar
 */
public class AppInitializer implements WebApplicationInitializer {

  // -------- class variables ----------

  /** config location. **/
  private static final String CONFIG_LOCATION = "com.walmart.ticket.config";

  /** mapping. **/
  private static final String MAPPING_URL = "/*";

  /**
   * initializes configurations on application startup.
   *
   * @param servletContext
   *          servlet Context
   * @throws ServletException
   *           exception.
   */
  @Override
  public void onStartup(final ServletContext servletContext) throws ServletException {
    // Create the 'root' Spring application context
    final WebApplicationContext context = getContext();
    // Manage the lifecycle of the root application context
    servletContext.addListener(new ContextLoaderListener(context));

    // Create the dispatcher servlet's Spring application context
    final ServletRegistration.Dynamic dispatcher =
        servletContext.addServlet("userDispatcherServlet", new DispatcherServlet(context));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping(MAPPING_URL);
  }

  /**
   * loads annotation based context.
   *
   * @return AnnotationConfigWebApplicationContext
   */
  private AnnotationConfigWebApplicationContext getContext() {
    final AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
    rootContext.setConfigLocations(new String[] {CONFIG_LOCATION});
    rootContext.register(AppConfig.class);
    return rootContext;
  }

}

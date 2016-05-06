package com.walmart.ticket.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * BaseRepository for CRUD operations.
 */
public abstract class BaseRepository {

  /** The session factory. */
  @Autowired
  private SessionFactory sessionFactory;

  /**
   * Gets the session.
   *
   * @return the session
   */
  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  /**
   * Persist.
   *
   * @param <T>
   *          the generic type
   * @param entity
   *          the entity
   */
  public <T> void persist(final T entity) {
    getSession().saveOrUpdate(entity);
  }

  /**
   * Delete.
   *
   * @param entity
   *          the entity
   */
  public void delete(final Object entity) {
    getSession().delete(entity);
  }
}

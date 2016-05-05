package com.walmart.ticket.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao {

  @Autowired
  private SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public <T> void persist(T entity) {
    getSession().saveOrUpdate(entity);
  }

  public void delete(Object entity) {
    getSession().delete(entity);
  }
}

package com.myservice.generic.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myservice.generic.dao.GenericDao;

public abstract class GenericDaoImpl<E extends Serializable, I extends Serializable> implements
GenericDao<E, I> {

   @Autowired
   private SessionFactory sessionFactory;

   private Session session;

   protected abstract Class<E> getEntityClass();

   public void delete(E persistentInstance) {

   }

   public void deleteById(final I id) {
      getSession().delete(getById(id));
   }

   @SuppressWarnings("unchecked")
   public List<E> findAll() {
      return getSession().createCriteria(getEntityClass()).list();
   }

   @SuppressWarnings("unchecked")
   public List<E> findAll(final int maxResults) {
      return getSession().createCriteria(getEntityClass()).setMaxResults(maxResults).list();
   }

   @SuppressWarnings("unchecked")
   public E getById(final I id) {

      return (E) getSession().get(getEntityClass(), id);
   }

   @SuppressWarnings("unchecked")
   public I getId(final E entity) {
      return (I) getSession().getIdentifier(entity);
   }

   @SuppressWarnings("unchecked")
   public I save(final E entity) {
      return (I) getSession().save(entity);

   }

   @SuppressWarnings("unchecked")
   public List<E> saveAll(final List<E> entities) {
      List<E> newRows = new ArrayList<E>();
      if (entities != null) {
         for (E entity : entities) {
            newRows.add((E) getSession().save(entity));
         }
      }
      return newRows;
   }

   public void update(final E transientInstance) {
      getSession().update(transientInstance);
   }

   @SuppressWarnings("unchecked")
   public E merge(E entity) {
      return (E) getSession().merge(entity);
   }

   public SessionFactory getSessionFactory() {
      if (sessionFactory == null) {

         throw new IllegalStateException("SessionFactory setup incomplete, null DAO instance");
      }

      return sessionFactory;
   }

   public void setSessionFactory(final SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public Session getSession() {
      if (getSessionFactory() != null) {
         setSession(getSessionFactory().getCurrentSession());
      }

      if (session == null) {

         throw new IllegalStateException("Session has not been set on DAO before usage");
      }

      return session;
   }

   public void setSession(Session s) {
      this.session = s;
   }

}

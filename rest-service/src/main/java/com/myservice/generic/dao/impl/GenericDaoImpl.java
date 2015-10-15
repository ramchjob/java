package com.myservice.generic.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.myservice.generic.dao.GenericDao;

public abstract class GenericDaoImpl<E extends Serializable, I extends Serializable> implements
GenericDao<E, I> {

   @Autowired
   private SessionFactory sessionFactory;

   private Session session;

   protected abstract Class<E> getEntityClass();

   @Override
   public void delete(final E entity) {
      getSession().delete(entity);
   }

   @Override
   public void deleteById(final I id) {
      getSession().delete(getById(id));
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<E> findAll() {
      return getSession().createCriteria(getEntityClass()).list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<E> findAll(final int maxResults) {
      return getSession().createCriteria(getEntityClass()).setMaxResults(maxResults).list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public E getById(final I id) {

      return (E) getSession().get(getEntityClass(), id);
   }

   @SuppressWarnings("unchecked")
   @Override
   public I getId(final E entity) {
      return (I) getSession().getIdentifier(entity);
   }

   @SuppressWarnings("unchecked")
   @Override
   public I save(final E entity) {
      return (I) getSession().save(entity);

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<E> saveAll(final List<E> entities) {
      List<E> newRows = new ArrayList<E>();
      if (entities != null) {
         for (E entity : entities) {
            newRows.add((E) getSession().save(entity));
         }
      }
      return newRows;
   }

   @Override
   public void update(final E transientInstance) {
      getSession().update(transientInstance);
   }

   @Override
   public E merge(E entity) {
      return (E) getSession().merge(entity);
   }

   @SuppressWarnings("unchecked")
   protected List<E> findByCriteria(Criterion... criterion) {
      Criteria crit = getSession().createCriteria(getEntityClass());
      for (Criterion c : criterion) {
         crit.add(c);
      }
      return crit.list();
   }

   @SuppressWarnings("unchecked")
   protected E findByCriteriaSingleResult(Criterion... criterion) {
      Criteria crit = getSession().createCriteria(getEntityClass());
      for (Criterion c : criterion) {
         crit.add(c);
      }
      return (E) crit.uniqueResult();
   }

   @SuppressWarnings("unchecked")
   public List<E> findByExample(E exampleInstance, String[] excludeProperty, MatchMode matchMode,
         boolean caseInsensitive, String[] order) {
      return createCriteria(exampleInstance, excludeProperty, true, matchMode, caseInsensitive,
            order).list();
   }

   @SuppressWarnings("unchecked")
   public List<E> findByExample(E exampleInstance, String[] excludeProperty, boolean wildcard,
         boolean caseInsensitive, String[] order) {
      return createCriteria(exampleInstance, excludeProperty, wildcard, MatchMode.ANYWHERE,
            caseInsensitive, order).list();
   }

   @SuppressWarnings("unchecked")
   public List<E> findByExample(E exampleInstance, String[] excludeProperty) {
      Criteria crit = getSession().createCriteria(getEntityClass());
      Example example = Example.create(exampleInstance);
      if (excludeProperty != null) {
         for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
         }
      }
      crit.add(example);
      return crit.list();
   }

   protected Criteria createCriteria(E exampleInstance, String[] excludeProperty, boolean wildcard,
         MatchMode matchMode, boolean caseInsensitive, String[] order) {
      Criteria criteria = getSession().createCriteria(getEntityClass());
      Example example = Example.create(exampleInstance);

      example.excludeZeroes();

      if (excludeProperty != null) {
         for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
         }
      }

      if (wildcard && !MatchMode.EXACT.equals(matchMode)) {
         example.enableLike(matchMode);
      }

      if (caseInsensitive) {
         example.ignoreCase();
      }

      criteria.add(example);

      if (order.length != 0) {
         for (String property : order) {
            criteria.addOrder(Order.asc(property));
         }
      }

      return criteria;
   }

   @SuppressWarnings("unchecked")
   protected List<E> findByORCriteria(Criterion... criterion) {
      Criteria crit = getSession().createCriteria(getEntityClass());
      Disjunction disjunction = Restrictions.disjunction();

      for (Criterion c : criterion) {
         disjunction.add(c);
      }

      crit.add(disjunction);

      return crit.list();
   }

   @SuppressWarnings("unchecked")
   protected List<E> findByORCriteria(Iterable<Criterion> criterion) {
      Criteria crit = getSession().createCriteria(getEntityClass());
      Disjunction disjunction = Restrictions.disjunction();

      for (Criterion c : criterion) {
         disjunction.add(c);
      }

      crit.add(disjunction);

      return crit.list();
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

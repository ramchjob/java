package com.myservice.generic.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<E extends Serializable, I extends Serializable> {

   void delete(E persistentInstance);

   void deleteById(I id);

   List<E> findAll();

   List<E> findAll(int maxResults);

   E getById(I id);

   I getId(E entity);

   I save(E transientInstance);

   List<E> saveAll(List<E> rows);

   void update(E transientInstance);

   E merge(E transientInstance);

}

package com.myservice.interceptor;

import java.io.Serializable;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class BaseObjectInterceptor extends EmptyInterceptor {

   @Override
   public boolean onSave(Object entity, Serializable id,
         Object[] state, String[] propertyNames,
         Type[] types) throws CallbackException {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean onFlushDirty(Object entity,
         Serializable id, Object[] currentState,
         Object[] previousState, String[] propertyNames,
         Type[] types) throws CallbackException {
      return false;
   }

}

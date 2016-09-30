package com.legend.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.legend.common.dao.BaseDao;


public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate	hibernateTemplate;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType)type;
			clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}else{
			clazz = null;
		}
	}

	@Override
	public void saveEntity(T t) {
		this.hibernateTemplate.save(t);
	}
	
	@Override
	public void saveOrUpdateEntity(T t) {
		this.hibernateTemplate.saveOrUpdate(t);
	}
	
	@Override
	public void updateEntity(T t) {
		this.hibernateTemplate.update(t);
	}
	
	@Override
	public void updateEntityByHql(String hql, Object... objects) {
		this.hibernateTemplate.execute(new HibernateCallback<T>(
				) {
					@Override
					public T doInHibernate(Session session) throws HibernateException {
						Query query = session.createQuery(hql);
						for(int i=0;objects!=null&&i<objects.length;++i){
							query.setParameter(i, objects[i]);
						}
						query.executeUpdate();
						return null; 
					}
		});
	}
	
	@Override
	public void deleteEntity(T t) {
		this.hibernateTemplate.delete(t);
	}
	
	@Override
	public T loadEntity(Serializable id) {
		return this.hibernateTemplate.load(clazz, id);
	}
	
	@Override
	public T loadEntityForUpdate(Serializable id) {
		return this.hibernateTemplate.load(clazz, id,LockMode.PESSIMISTIC_WRITE);
	}

	@Override
	public T getEntity(Serializable id) {
		return this.hibernateTemplate.get(clazz, id);
	}

	@Override
	public T getEntityForUpdate(Serializable id) {
		return this.hibernateTemplate.get(clazz, id, LockMode.PESSIMISTIC_WRITE);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByHql(String hql, Object... objects) {
		return (List<T>) this.hibernateTemplate.find(hql, objects);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByHqlForPage(String hql	,final int offset,final int length, Object... objects) {
		return (List<T>) this.hibernateTemplate.execute(new HibernateCallback<List<T> >() {
			@Override
			public List<T>   doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				for(int i=0;i<objects.length;++i){
					query.setParameter(i,objects[i]);
				}
				query.setFirstResult(offset);
				query.setMaxResults(length);
				return  query.list();
			}
		});
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByExample(T t) {
		return this.hibernateTemplate.findByExample(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByExampleForPage(T t, int offset, int length) {
		return this.hibernateTemplate.findByExample(t, offset, length);
	}

	@Override
	public Object countSumByHql(String hql, Object... objects) {
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		for(int i=0;objects!=null&&i<objects.length;++i){
			query.setParameter(i, objects[i]);
		}
		return query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeSqlQuery(Class<T> clazz,String sql, Object... objects) {
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		if(clazz!=null){
			sqlQuery.addEntity(clazz);
		}
		for(int i=0;objects!=null&&i<objects.length;++i){
			sqlQuery.setParameter(i, objects[i]);
		}
		return sqlQuery.list();
	}
	

}

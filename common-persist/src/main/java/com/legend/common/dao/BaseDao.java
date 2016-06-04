package com.legend.common.dao;

import java.util.List;

public interface BaseDao<T> {
	
	//写入方法
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void updateEntityByHql(String hql,Object...objects);
	public void deleteEntity(T t);
	
	//读取方法
	public T loadEntity(Integer i);
	public T loadEntityForUpdate(Integer i);
	public T getEntity(Integer i);
	public T getEntityForUpdate(Integer i);
	public List<T> findEntityByHql(String hql,Object...objects);
	public List<T> findEntityByExample(T t);
	public List<T> findEntityByExampleForPage(T t,final int offset,final int length);
	public Object countSumByHql(String hql,Object...objects);
	public List<T> executeSqlQuery(Class<T> clazz,String sql,Object...objects);
	
}

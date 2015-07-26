package com.wangwang.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	private Log log = LogFactory.getLog(this.getClass());

	public BaseDaoImpl() {
		// 通过反射的技术获得类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
		System.out.println(clazz);
	}

	/***
	 * 获得当前的Hibernate Session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 新增实体
	 */
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	/**
	 * 更新实体
	 */
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	/**
	 * 删除实体
	 */
	@Override
	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null)
			getSession().delete(obj);

	}

	/**
	 * 获得所有实体
	 */
	@Override
	public List<T> getAlls() {
		return getSession().createQuery("FROM " + clazz.getSimpleName()).list();

	}

	/**
	 * 根据IDs 获得实体集合
	 */
	@Override
	public List<T> getIds(Long[] ids) {

		List<T> list = getSession()
				.createQuery(
						"FROM " + clazz.getSimpleName() + " WHERE id in(:ids)"//
				).setParameterList("ids", ids).list();
		return list;
	}

	/**
	 * 根据ID 获得实体
	 */
	@Override
	public T getById(Long id) {
		List<T> list = getSession()
				.createQuery("FROM " + clazz.getSimpleName() + " WHERE id=:id")
				.setParameter("id", id).list();
		return list.size() > 0 ? list.get(0) : null;
	}

}

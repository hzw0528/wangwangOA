package com.wangwang.oa.base;

import java.util.List;
/**
 * Dao的基础接口
 * @author wangwang
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 保存信息
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 根据ID 更新信息
	 * @param entity 实体
	 * @param id id
	 */
	void update(T entity);
    /**
     * 根据ID 删除实体
     * @param id
     */
	void delete(Integer id);
    /**
     * 获得全部实体
     * @return
     */
	List<T> getAlls();
    /***
     * 根据IDs 获得所有实体
     * @param ids
     * @return
     */
	List<T> getIds(Integer[] ids);
	/**
	 * 根据ID 获得实体
	 * @param id
	 * @return
	 */
    T getById(Integer id);
}

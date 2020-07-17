
package com.colia.yorik.yorikcommon.domain.repository;


import com.colia.yorik.yorikcommon.domain.entity.Entity;

/**
 * 仓库服务
 * <p>
 * 只定义契约的接口，实际实现由infrastructure 下的 persistence 完成持久化操作
 * <p>
 * 资源库分为两种，一种是基于集合的，一种是基于持久化的。基于集合的参照InMemRepository的抽象实现
 *
 * @author david
 * @version 1.0
 * @created 2018/6/14 上午11:04
 **/
public interface Repository<T extends Entity, ID> {
    /**
     * 按业务唯一标识查找
     *
     * @param identity
     * @return
     */
    T find(ID identity);

    /**
     * 存储领域
     *
     * @param entity
     */
    void store(T entity);
}
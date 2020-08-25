package com.colia.yorik.common.domain.repository;


import com.colia.yorik.common.domain.entity.Entity;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 仓库服务-内存型
 * <p>
 * 该类仓库
 * <p>
 * 例如：字典数据
 *
 * @Author colia
 * @Date 2020/07/15 上午11:19
 **/
public abstract class InMemRepository<T extends Entity, ID> implements Repository<T, ID> {

    /**
     * 集合存储
     */
    private Map<ID, T> entitiesMap = new HashMap<ID, T>();

    /**
     * 安全锁
     */
    private Lock lock = new ReentrantLock();


    /**
     * 新增领域
     *
     * @param entity
     */
    @Override
    public void store(T entity) {
        lock.lock();
        entitiesMap.put((ID) entity.identity(), entity);
        lock.unlock();
    }

    /**
     * 按唯一业务标识查询
     *
     * @param identity
     * @return
     */
    @Override
    public T find(ID identity) {
        lock.lock();
        T entity = entitiesMap.get(identity);
        lock.unlock();
        return entity;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<T> findAll() {
        List<T> entities = new ArrayList();
        lock.lock();
        Iterator<ID> it = entitiesMap.keySet().iterator();
        while (it.hasNext()) {
            ID key = it.next();
            entities.add(entitiesMap.get(key));
        }
        lock.unlock();
        return entities;
    }

}
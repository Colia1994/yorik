package com.colia.yorik.common.domain.factory;


import com.colia.yorik.common.domain.entity.Entity;

/**
 * 领域对象工厂
 * <p>
 * 用于复杂领域对象创建或加持久化后后的领域对象重建
 *
 * @param <T>
 */
public interface DomainFactory<T extends Entity> {

    T toEntity(Object... objects);

}

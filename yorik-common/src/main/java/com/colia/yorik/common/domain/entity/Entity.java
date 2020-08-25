package com.colia.yorik.common.domain.entity;

/**
 * 领域实体
 * <p>
 * domain entity具有如下三个特征：
 * 唯一业务标识
 * 持有自己的业务属性和业务行为
 * 属性可变，有着自己的生命周期
 *
 * @param <T>
 * @param <ID>
 * @Author colia
 * @Date 2020/07/14 上午10:52
 **/
public interface Entity<T, ID> {

    boolean sameIdentityAs(T other);

    ID identity();

}
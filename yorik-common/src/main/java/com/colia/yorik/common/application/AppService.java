
package com.colia.yorik.common.application;

/**
 * 应用服务基类
 * <p>
 * 应用层中不应该包含有业务逻辑，否则就造成了领域逻辑的泄漏，
 * 该层而是很薄的一层，主要起到协调的作用，它所做的只是将业务操作代理给我们的领域模型。
 * 同时，如果我们的业务操作有事务需求，那么对于事务的管理应该放在应用层上，因为事务也是以业务用例为单位的。
 *
 * @author david
 * @version 1.0
 * @created 2018/6/14 上午10:52
 **/
public interface AppService {
    

}
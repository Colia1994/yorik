
package com.colia.yorik.yorikcommon.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * PO基类
 *
 * @Author colia
 * @Date 2020/07/15 下午3:45
 **/
@Setter
@Getter
public abstract class AbstractPO implements Serializable {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

}
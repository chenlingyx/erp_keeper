package com.weychain.erp.domain.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@TableName("jsh_tenant")
@Data
public class Tenant {

    private Long id;

    private Long tenantId;
    private String loginName;

    private Integer userNumLimit;

    private Integer billsNumLimit;

    private Date createTime;
}

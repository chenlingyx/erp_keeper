package com.weychain.erp.domain.DO;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class AccountItem {
    private Long id;

    private Long headerid;

    private Long accountid;

    private Long inoutitemid;

    private BigDecimal eachamount;

    private String remark;

    private Long tenantId;

    private String deleteFlag;

}
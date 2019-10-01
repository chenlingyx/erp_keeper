package com.weychain.erp.domain.DO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account extends  SuperEntity {

    private Long id;
    private String name;

    private String serialno;

    private BigDecimal initialamount;

    private BigDecimal currentamount;

    private String remark;

    private Boolean isdefault;





}
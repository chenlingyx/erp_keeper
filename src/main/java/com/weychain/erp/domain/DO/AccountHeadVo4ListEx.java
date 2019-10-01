package com.weychain.erp.domain.DO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountHeadVo4ListEx {

    private Long id;

    private String type;

    private Long organid;

    private Long handspersonid;

    private BigDecimal changeamount;

    private BigDecimal totalprice;

    private Long accountid;

    private String billno;

    private Date billtime;

    private String remark;

    private Long tenantId;

    private String deleteFlag;

    private String organname;

    private String handspersonname;

    private String accountname;
}
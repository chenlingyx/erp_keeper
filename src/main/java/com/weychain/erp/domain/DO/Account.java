package com.weychain.erp.domain.DO;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("jsh_account")
public class Account  {

    private Long id;
    private String name;

    private String serialno;

    private BigDecimal initialamount;

    private BigDecimal currentamount;

    private String remark;

    private Boolean isdefault;

    @TableLogic
    private String deleteFlag = "0";





}
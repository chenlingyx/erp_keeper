package com.weychain.erp.domain.DO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Supplier  extends SuperEntity{
    private Long id;

    private String supplier;

    private String contacts;

    private String phonenum;

    private String email;

    private String description;

    private Byte isystem;

    private String type;

    private Boolean enabled;

    private BigDecimal advancein;

    private BigDecimal beginneedget;

    private BigDecimal beginneedpay;

    private BigDecimal allneedget;

    private BigDecimal allneedpay;

    private String fax;

    private String telephone;

    private String address;

    private String taxnum;

    private String bankname;

    private String accountnumber;

    private BigDecimal taxrate;

}
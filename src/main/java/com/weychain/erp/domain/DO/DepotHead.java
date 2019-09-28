package com.weychain.erp.domain.DO;

import java.math.BigDecimal;
import java.util.Date;

public class DepotHead {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.SubType
     *
     * @mbggenerated
     */
    private String subtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.ProjectId
     *
     * @mbggenerated
     */
    private Long projectid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.DefaultNumber
     *
     * @mbggenerated
     */
    private String defaultnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Number
     *
     * @mbggenerated
     */
    private String number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.OperPersonName
     *
     * @mbggenerated
     */
    private String operpersonname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.CreateTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.OperTime
     *
     * @mbggenerated
     */
    private Date opertime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.OrganId
     *
     * @mbggenerated
     */
    private Long organid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.HandsPersonId
     *
     * @mbggenerated
     */
    private Long handspersonid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.AccountId
     *
     * @mbggenerated
     */
    private Long accountid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.ChangeAmount
     *
     * @mbggenerated
     */
    private BigDecimal changeamount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.AllocationProjectId
     *
     * @mbggenerated
     */
    private Long allocationprojectid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.TotalPrice
     *
     * @mbggenerated
     */
    private BigDecimal totalprice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.PayType
     *
     * @mbggenerated
     */
    private String paytype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Salesman
     *
     * @mbggenerated
     */
    private String salesman;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.AccountIdList
     *
     * @mbggenerated
     */
    private String accountidlist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.AccountMoneyList
     *
     * @mbggenerated
     */
    private String accountmoneylist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Discount
     *
     * @mbggenerated
     */
    private BigDecimal discount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.DiscountMoney
     *
     * @mbggenerated
     */
    private BigDecimal discountmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.DiscountLastMoney
     *
     * @mbggenerated
     */
    private BigDecimal discountlastmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.OtherMoney
     *
     * @mbggenerated
     */
    private BigDecimal othermoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.OtherMoneyList
     *
     * @mbggenerated
     */
    private String othermoneylist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.OtherMoneyItem
     *
     * @mbggenerated
     */
    private String othermoneyitem;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.AccountDay
     *
     * @mbggenerated
     */
    private Integer accountday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.Status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.LinkNumber
     *
     * @mbggenerated
     */
    private String linknumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.tenant_id
     *
     * @mbggenerated
     */
    private Long tenantId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_depothead.delete_Flag
     *
     * @mbggenerated
     */
    private String deleteFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Id
     *
     * @return the value of jsh_depothead.Id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Id
     *
     * @param id the value for jsh_depothead.Id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Type
     *
     * @return the value of jsh_depothead.Type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Type
     *
     * @param type the value for jsh_depothead.Type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.SubType
     *
     * @return the value of jsh_depothead.SubType
     *
     * @mbggenerated
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.SubType
     *
     * @param subtype the value for jsh_depothead.SubType
     *
     * @mbggenerated
     */
    public void setSubtype(String subtype) {
        this.subtype = subtype == null ? null : subtype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.ProjectId
     *
     * @return the value of jsh_depothead.ProjectId
     *
     * @mbggenerated
     */
    public Long getProjectid() {
        return projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.ProjectId
     *
     * @param projectid the value for jsh_depothead.ProjectId
     *
     * @mbggenerated
     */
    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.DefaultNumber
     *
     * @return the value of jsh_depothead.DefaultNumber
     *
     * @mbggenerated
     */
    public String getDefaultnumber() {
        return defaultnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.DefaultNumber
     *
     * @param defaultnumber the value for jsh_depothead.DefaultNumber
     *
     * @mbggenerated
     */
    public void setDefaultnumber(String defaultnumber) {
        this.defaultnumber = defaultnumber == null ? null : defaultnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Number
     *
     * @return the value of jsh_depothead.Number
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Number
     *
     * @param number the value for jsh_depothead.Number
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.OperPersonName
     *
     * @return the value of jsh_depothead.OperPersonName
     *
     * @mbggenerated
     */
    public String getOperpersonname() {
        return operpersonname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.OperPersonName
     *
     * @param operpersonname the value for jsh_depothead.OperPersonName
     *
     * @mbggenerated
     */
    public void setOperpersonname(String operpersonname) {
        this.operpersonname = operpersonname == null ? null : operpersonname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.CreateTime
     *
     * @return the value of jsh_depothead.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.CreateTime
     *
     * @param createtime the value for jsh_depothead.CreateTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.OperTime
     *
     * @return the value of jsh_depothead.OperTime
     *
     * @mbggenerated
     */
    public Date getOpertime() {
        return opertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.OperTime
     *
     * @param opertime the value for jsh_depothead.OperTime
     *
     * @mbggenerated
     */
    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.OrganId
     *
     * @return the value of jsh_depothead.OrganId
     *
     * @mbggenerated
     */
    public Long getOrganid() {
        return organid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.OrganId
     *
     * @param organid the value for jsh_depothead.OrganId
     *
     * @mbggenerated
     */
    public void setOrganid(Long organid) {
        this.organid = organid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.HandsPersonId
     *
     * @return the value of jsh_depothead.HandsPersonId
     *
     * @mbggenerated
     */
    public Long getHandspersonid() {
        return handspersonid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.HandsPersonId
     *
     * @param handspersonid the value for jsh_depothead.HandsPersonId
     *
     * @mbggenerated
     */
    public void setHandspersonid(Long handspersonid) {
        this.handspersonid = handspersonid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.AccountId
     *
     * @return the value of jsh_depothead.AccountId
     *
     * @mbggenerated
     */
    public Long getAccountid() {
        return accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.AccountId
     *
     * @param accountid the value for jsh_depothead.AccountId
     *
     * @mbggenerated
     */
    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.ChangeAmount
     *
     * @return the value of jsh_depothead.ChangeAmount
     *
     * @mbggenerated
     */
    public BigDecimal getChangeamount() {
        return changeamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.ChangeAmount
     *
     * @param changeamount the value for jsh_depothead.ChangeAmount
     *
     * @mbggenerated
     */
    public void setChangeamount(BigDecimal changeamount) {
        this.changeamount = changeamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.AllocationProjectId
     *
     * @return the value of jsh_depothead.AllocationProjectId
     *
     * @mbggenerated
     */
    public Long getAllocationprojectid() {
        return allocationprojectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.AllocationProjectId
     *
     * @param allocationprojectid the value for jsh_depothead.AllocationProjectId
     *
     * @mbggenerated
     */
    public void setAllocationprojectid(Long allocationprojectid) {
        this.allocationprojectid = allocationprojectid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.TotalPrice
     *
     * @return the value of jsh_depothead.TotalPrice
     *
     * @mbggenerated
     */
    public BigDecimal getTotalprice() {
        return totalprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.TotalPrice
     *
     * @param totalprice the value for jsh_depothead.TotalPrice
     *
     * @mbggenerated
     */
    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.PayType
     *
     * @return the value of jsh_depothead.PayType
     *
     * @mbggenerated
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.PayType
     *
     * @param paytype the value for jsh_depothead.PayType
     *
     * @mbggenerated
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Remark
     *
     * @return the value of jsh_depothead.Remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Remark
     *
     * @param remark the value for jsh_depothead.Remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Salesman
     *
     * @return the value of jsh_depothead.Salesman
     *
     * @mbggenerated
     */
    public String getSalesman() {
        return salesman;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Salesman
     *
     * @param salesman the value for jsh_depothead.Salesman
     *
     * @mbggenerated
     */
    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.AccountIdList
     *
     * @return the value of jsh_depothead.AccountIdList
     *
     * @mbggenerated
     */
    public String getAccountidlist() {
        return accountidlist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.AccountIdList
     *
     * @param accountidlist the value for jsh_depothead.AccountIdList
     *
     * @mbggenerated
     */
    public void setAccountidlist(String accountidlist) {
        this.accountidlist = accountidlist == null ? null : accountidlist.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.AccountMoneyList
     *
     * @return the value of jsh_depothead.AccountMoneyList
     *
     * @mbggenerated
     */
    public String getAccountmoneylist() {
        return accountmoneylist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.AccountMoneyList
     *
     * @param accountmoneylist the value for jsh_depothead.AccountMoneyList
     *
     * @mbggenerated
     */
    public void setAccountmoneylist(String accountmoneylist) {
        this.accountmoneylist = accountmoneylist == null ? null : accountmoneylist.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Discount
     *
     * @return the value of jsh_depothead.Discount
     *
     * @mbggenerated
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Discount
     *
     * @param discount the value for jsh_depothead.Discount
     *
     * @mbggenerated
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.DiscountMoney
     *
     * @return the value of jsh_depothead.DiscountMoney
     *
     * @mbggenerated
     */
    public BigDecimal getDiscountmoney() {
        return discountmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.DiscountMoney
     *
     * @param discountmoney the value for jsh_depothead.DiscountMoney
     *
     * @mbggenerated
     */
    public void setDiscountmoney(BigDecimal discountmoney) {
        this.discountmoney = discountmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.DiscountLastMoney
     *
     * @return the value of jsh_depothead.DiscountLastMoney
     *
     * @mbggenerated
     */
    public BigDecimal getDiscountlastmoney() {
        return discountlastmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.DiscountLastMoney
     *
     * @param discountlastmoney the value for jsh_depothead.DiscountLastMoney
     *
     * @mbggenerated
     */
    public void setDiscountlastmoney(BigDecimal discountlastmoney) {
        this.discountlastmoney = discountlastmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.OtherMoney
     *
     * @return the value of jsh_depothead.OtherMoney
     *
     * @mbggenerated
     */
    public BigDecimal getOthermoney() {
        return othermoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.OtherMoney
     *
     * @param othermoney the value for jsh_depothead.OtherMoney
     *
     * @mbggenerated
     */
    public void setOthermoney(BigDecimal othermoney) {
        this.othermoney = othermoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.OtherMoneyList
     *
     * @return the value of jsh_depothead.OtherMoneyList
     *
     * @mbggenerated
     */
    public String getOthermoneylist() {
        return othermoneylist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.OtherMoneyList
     *
     * @param othermoneylist the value for jsh_depothead.OtherMoneyList
     *
     * @mbggenerated
     */
    public void setOthermoneylist(String othermoneylist) {
        this.othermoneylist = othermoneylist == null ? null : othermoneylist.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.OtherMoneyItem
     *
     * @return the value of jsh_depothead.OtherMoneyItem
     *
     * @mbggenerated
     */
    public String getOthermoneyitem() {
        return othermoneyitem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.OtherMoneyItem
     *
     * @param othermoneyitem the value for jsh_depothead.OtherMoneyItem
     *
     * @mbggenerated
     */
    public void setOthermoneyitem(String othermoneyitem) {
        this.othermoneyitem = othermoneyitem == null ? null : othermoneyitem.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.AccountDay
     *
     * @return the value of jsh_depothead.AccountDay
     *
     * @mbggenerated
     */
    public Integer getAccountday() {
        return accountday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.AccountDay
     *
     * @param accountday the value for jsh_depothead.AccountDay
     *
     * @mbggenerated
     */
    public void setAccountday(Integer accountday) {
        this.accountday = accountday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.Status
     *
     * @return the value of jsh_depothead.Status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.Status
     *
     * @param status the value for jsh_depothead.Status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.LinkNumber
     *
     * @return the value of jsh_depothead.LinkNumber
     *
     * @mbggenerated
     */
    public String getLinknumber() {
        return linknumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.LinkNumber
     *
     * @param linknumber the value for jsh_depothead.LinkNumber
     *
     * @mbggenerated
     */
    public void setLinknumber(String linknumber) {
        this.linknumber = linknumber == null ? null : linknumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.tenant_id
     *
     * @return the value of jsh_depothead.tenant_id
     *
     * @mbggenerated
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.tenant_id
     *
     * @param tenantId the value for jsh_depothead.tenant_id
     *
     * @mbggenerated
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_depothead.delete_Flag
     *
     * @return the value of jsh_depothead.delete_Flag
     *
     * @mbggenerated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_depothead.delete_Flag
     *
     * @param deleteFlag the value for jsh_depothead.delete_Flag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}
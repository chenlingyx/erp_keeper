package com.weychain.erp.domain.DO;

import java.util.Date;

public class SerialNumber {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.material_Id
     *
     * @mbggenerated
     */
    private Long materialId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.serial_Number
     *
     * @mbggenerated
     */
    private String serialNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.is_Sell
     *
     * @mbggenerated
     */
    private String isSell;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.delete_Flag
     *
     * @mbggenerated
     */
    private String deleteFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.create_Time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.creator
     *
     * @mbggenerated
     */
    private Long creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.update_Time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.updater
     *
     * @mbggenerated
     */
    private Long updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.depothead_Id
     *
     * @mbggenerated
     */
    private Long depotheadId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_serial_number.tenant_id
     *
     * @mbggenerated
     */
    private Long tenantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.id
     *
     * @return the value of jsh_serial_number.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.id
     *
     * @param id the value for jsh_serial_number.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.material_Id
     *
     * @return the value of jsh_serial_number.material_Id
     *
     * @mbggenerated
     */
    public Long getMaterialId() {
        return materialId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.material_Id
     *
     * @param materialId the value for jsh_serial_number.material_Id
     *
     * @mbggenerated
     */
    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.serial_Number
     *
     * @return the value of jsh_serial_number.serial_Number
     *
     * @mbggenerated
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.serial_Number
     *
     * @param serialNumber the value for jsh_serial_number.serial_Number
     *
     * @mbggenerated
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.is_Sell
     *
     * @return the value of jsh_serial_number.is_Sell
     *
     * @mbggenerated
     */
    public String getIsSell() {
        return isSell;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.is_Sell
     *
     * @param isSell the value for jsh_serial_number.is_Sell
     *
     * @mbggenerated
     */
    public void setIsSell(String isSell) {
        this.isSell = isSell == null ? null : isSell.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.remark
     *
     * @return the value of jsh_serial_number.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.remark
     *
     * @param remark the value for jsh_serial_number.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.delete_Flag
     *
     * @return the value of jsh_serial_number.delete_Flag
     *
     * @mbggenerated
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.delete_Flag
     *
     * @param deleteFlag the value for jsh_serial_number.delete_Flag
     *
     * @mbggenerated
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.create_Time
     *
     * @return the value of jsh_serial_number.create_Time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.create_Time
     *
     * @param createTime the value for jsh_serial_number.create_Time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.creator
     *
     * @return the value of jsh_serial_number.creator
     *
     * @mbggenerated
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.creator
     *
     * @param creator the value for jsh_serial_number.creator
     *
     * @mbggenerated
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.update_Time
     *
     * @return the value of jsh_serial_number.update_Time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.update_Time
     *
     * @param updateTime the value for jsh_serial_number.update_Time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.updater
     *
     * @return the value of jsh_serial_number.updater
     *
     * @mbggenerated
     */
    public Long getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.updater
     *
     * @param updater the value for jsh_serial_number.updater
     *
     * @mbggenerated
     */
    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.depothead_Id
     *
     * @return the value of jsh_serial_number.depothead_Id
     *
     * @mbggenerated
     */
    public Long getDepotheadId() {
        return depotheadId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.depothead_Id
     *
     * @param depotheadId the value for jsh_serial_number.depothead_Id
     *
     * @mbggenerated
     */
    public void setDepotheadId(Long depotheadId) {
        this.depotheadId = depotheadId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_serial_number.tenant_id
     *
     * @return the value of jsh_serial_number.tenant_id
     *
     * @mbggenerated
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_serial_number.tenant_id
     *
     * @param tenantId the value for jsh_serial_number.tenant_id
     *
     * @mbggenerated
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}
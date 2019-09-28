package com.weychain.erp.domain.DO;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.loginame
     *
     * @mbggenerated
     */
    private String loginame;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.position
     *
     * @mbggenerated
     */
    private String position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.department
     *
     * @mbggenerated
     */
    private String department;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.phonenum
     *
     * @mbggenerated
     */
    private String phonenum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.ismanager
     *
     * @mbggenerated
     */
    private Byte ismanager;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.isystem
     *
     * @mbggenerated
     */
    private Byte isystem;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.Status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jsh_user.tenant_id
     *
     * @mbggenerated
     */
    private Long tenantId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.id
     *
     * @return the value of jsh_user.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.id
     *
     * @param id the value for jsh_user.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.username
     *
     * @return the value of jsh_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.username
     *
     * @param username the value for jsh_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.loginame
     *
     * @return the value of jsh_user.loginame
     *
     * @mbggenerated
     */
    public String getLoginame() {
        return loginame;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.loginame
     *
     * @param loginame the value for jsh_user.loginame
     *
     * @mbggenerated
     */
    public void setLoginame(String loginame) {
        this.loginame = loginame == null ? null : loginame.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.password
     *
     * @return the value of jsh_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.password
     *
     * @param password the value for jsh_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.position
     *
     * @return the value of jsh_user.position
     *
     * @mbggenerated
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.position
     *
     * @param position the value for jsh_user.position
     *
     * @mbggenerated
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.department
     *
     * @return the value of jsh_user.department
     *
     * @mbggenerated
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.department
     *
     * @param department the value for jsh_user.department
     *
     * @mbggenerated
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.email
     *
     * @return the value of jsh_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.email
     *
     * @param email the value for jsh_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.phonenum
     *
     * @return the value of jsh_user.phonenum
     *
     * @mbggenerated
     */
    public String getPhonenum() {
        return phonenum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.phonenum
     *
     * @param phonenum the value for jsh_user.phonenum
     *
     * @mbggenerated
     */
    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum == null ? null : phonenum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.ismanager
     *
     * @return the value of jsh_user.ismanager
     *
     * @mbggenerated
     */
    public Byte getIsmanager() {
        return ismanager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.ismanager
     *
     * @param ismanager the value for jsh_user.ismanager
     *
     * @mbggenerated
     */
    public void setIsmanager(Byte ismanager) {
        this.ismanager = ismanager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.isystem
     *
     * @return the value of jsh_user.isystem
     *
     * @mbggenerated
     */
    public Byte getIsystem() {
        return isystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.isystem
     *
     * @param isystem the value for jsh_user.isystem
     *
     * @mbggenerated
     */
    public void setIsystem(Byte isystem) {
        this.isystem = isystem;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.Status
     *
     * @return the value of jsh_user.Status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.Status
     *
     * @param status the value for jsh_user.Status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.description
     *
     * @return the value of jsh_user.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.description
     *
     * @param description the value for jsh_user.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.remark
     *
     * @return the value of jsh_user.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.remark
     *
     * @param remark the value for jsh_user.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jsh_user.tenant_id
     *
     * @return the value of jsh_user.tenant_id
     *
     * @mbggenerated
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jsh_user.tenant_id
     *
     * @param tenantId the value for jsh_user.tenant_id
     *
     * @mbggenerated
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}
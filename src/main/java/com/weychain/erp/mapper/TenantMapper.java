package com.weychain.erp.mapper;

import java.util.List;

import com.weychain.erp.domain.example.TenantExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.Tenant;
@Mapper
public interface TenantMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int countByExample(TenantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int deleteByExample(TenantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int insert(Tenant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int insertSelective(Tenant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    List<Tenant> selectByExample(TenantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    Tenant selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Tenant record, @Param("example") TenantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Tenant record, @Param("example") TenantExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Tenant record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jsh_tenant
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Tenant record);
}
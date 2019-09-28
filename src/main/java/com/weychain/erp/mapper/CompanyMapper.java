package com.weychain.erp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.Company;

import java.util.List;

import com.weychain.erp.domain.example.CompanyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int countByExample(CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int deleteByExample(CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer companyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int insert(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int insertSelective(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    List<Company> selectByExample(CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    Company selectByPrimaryKey(Integer companyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table erp_company
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Company record);
}
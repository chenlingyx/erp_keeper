package com.weychain.erp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

    int countByExample(Company example);


    int deleteByExample(Company example);


    int deleteByPrimaryKey(Integer companyId);


    int insert(Company record);


    int insertSelective(Company record);


    List<Company> selectByExample(Company example);


    Company selectByPrimaryKey(Integer companyId);


    int updateByExampleSelective(@Param("record") Company record, @Param("example") Company example);


    int updateByExample(@Param("record") Company record, @Param("example") Company example);


    int updateByPrimaryKeySelective(Company record);


    int updateByPrimaryKey(Company record);
}
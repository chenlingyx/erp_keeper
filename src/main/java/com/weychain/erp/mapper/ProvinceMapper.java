package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ProvinceMapper {

    int countByExample(Province example);


    int deleteByExample(Province example);


    int deleteByPrimaryKey(Integer id);


    int insert(Province record);


    int insertSelective(Province record);


    List<Province> selectByExample(Province example);


    Province selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") Province record, @Param("example") Province example);


    int updateByExample(@Param("record") Province record, @Param("example") Province example);


    int updateByPrimaryKeySelective(Province record);


    int updateByPrimaryKey(Province record);
}
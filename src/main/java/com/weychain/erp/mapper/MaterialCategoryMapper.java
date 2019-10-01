package com.weychain.erp.mapper;


import com.weychain.erp.domain.DO.MaterialCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MaterialCategoryMapper {

    int countByExample(MaterialCategory example);


    int deleteByExample(MaterialCategory example);


    int deleteByPrimaryKey(Long id);


    int insert(MaterialCategory record);


    int insertSelective(MaterialCategory record);


    List<MaterialCategory> selectByExample(MaterialCategory example);


    MaterialCategory selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") MaterialCategory record, @Param("example") MaterialCategory example);


    int updateByExample(@Param("record") MaterialCategory record, @Param("example") MaterialCategory example);


    int updateByPrimaryKeySelective(MaterialCategory record);


    int updateByPrimaryKey(MaterialCategory record);
}
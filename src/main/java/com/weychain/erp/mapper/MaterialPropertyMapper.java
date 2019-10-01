package com.weychain.erp.mapper;


import com.weychain.erp.domain.DO.MaterialProperty;
import com.weychain.erp.domain.example.MaterialPropertyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MaterialPropertyMapper {

    int countByExample(MaterialProperty example);


    int deleteByExample(MaterialProperty example);


    int deleteByPrimaryKey(Long id);


    int insert(MaterialProperty record);


    int insertSelective(MaterialProperty record);


    List<MaterialProperty> selectByExample(MaterialProperty example);


    MaterialProperty selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") MaterialProperty record, @Param("example") MaterialProperty example);


    int updateByExample(@Param("record") MaterialProperty record, @Param("example") MaterialProperty example);


    int updateByPrimaryKeySelective(MaterialProperty record);



    int updateByPrimaryKey(MaterialProperty record);
}
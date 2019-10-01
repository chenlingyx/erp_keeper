package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MaterialMapper {

    int countByExample(Material example);


    int deleteByExample(Material example);


    int deleteByPrimaryKey(Long id);


    int insert(Material record);


    int insertSelective(Material record);


    List<Material> selectByExample(Material example);


    Material selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Material record, @Param("example") Material example);


    int updateByExample(@Param("record") Material record, @Param("example") Material example);


    int updateByPrimaryKeySelective(Material record);


    int updateByPrimaryKey(Material record);
}
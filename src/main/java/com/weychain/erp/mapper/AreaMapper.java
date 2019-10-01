package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AreaMapper {

    int countByExample(Area example);


    int deleteByExample(Area example);


    int deleteByPrimaryKey(Integer id);


    int insert(Area record);


    int insertSelective(Area record);


    List<Area> selectByExample(Area example);


    Area selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") Area record, @Param("example") Area  example);


    int updateByExample(@Param("record") Area record, @Param("example") Area example);


    int updateByPrimaryKeySelective(Area record);


    int updateByPrimaryKey(Area record);
}
package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UnitMapper {

    int countByExample(Unit example);


    int deleteByExample(Unit example);


    int deleteByPrimaryKey(Long id);


    int insert(Unit record);


    int insertSelective(Unit record);


    List<Unit> selectByExample(Unit example);


    Unit selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Unit record, @Param("example") Unit example);


    int updateByExample(@Param("record") Unit record, @Param("example") Unit example);


    int updateByPrimaryKeySelective(Unit record);


    int updateByPrimaryKey(Unit record);
}
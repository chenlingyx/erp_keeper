package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Depot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DepotMapper {

    int countByExample(Depot example);


    int deleteByExample(Depot example);


    int deleteByPrimaryKey(Long id);


    int insert(Depot record);


    int insertSelective(Depot record);


    List<Depot> selectByExample(Depot  example);


    Depot selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Depot record, @Param("example") Depot example);


    int updateByExample(@Param("record") Depot record, @Param("example") Depot example);


    int updateByPrimaryKeySelective(Depot record);


    int updateByPrimaryKey(Depot record);
}
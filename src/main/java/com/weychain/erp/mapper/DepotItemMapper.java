package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.DepotItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DepotItemMapper {

    int countByExample(DepotItem example);


    int deleteByExample(DepotItem example);


    int deleteByPrimaryKey(Long id);


    int insert(DepotItem record);


    int insertSelective(DepotItem record);


    List<DepotItem> selectByExample(DepotItem example);


    DepotItem selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") DepotItem record, @Param("example") DepotItem example);


    int updateByExample(@Param("record") DepotItem record, @Param("example") DepotItem example);


    int updateByPrimaryKeySelective(DepotItem record);


    int updateByPrimaryKey(DepotItem record);
}
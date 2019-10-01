package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SupplierMapper {

    int countByExample(Supplier example);


    int deleteByExample(Supplier example);


    int deleteByPrimaryKey(Long id);


    int insert(Supplier record);


    int insertSelective(Supplier record);


    List<Supplier> selectByExample(Supplier example);


    Supplier selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") Supplier example);


    int updateByExample(@Param("record") Supplier record, @Param("example") Supplier example);


    int updateByPrimaryKeySelective(Supplier record);


    int updateByPrimaryKey(Supplier record);
}
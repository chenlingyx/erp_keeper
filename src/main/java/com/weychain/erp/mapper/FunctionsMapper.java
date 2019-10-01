package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Functions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface FunctionsMapper {

    int countByExample(Functions example);


    int deleteByExample(Functions example);


    int deleteByPrimaryKey(Long id);


    int insert(Functions record);


    int insertSelective(Functions record);


    List<Functions> selectByExample(Functions example);


    Functions selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Functions record, @Param("example") Functions example);


    int updateByExample(@Param("record") Functions record, @Param("example") Functions example);


    int updateByPrimaryKeySelective(Functions record);


    int updateByPrimaryKey(Functions record);
}
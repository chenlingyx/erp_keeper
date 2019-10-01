package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LogMapper {


    int countByExample(Log example);



    int deleteByExample(Log example);



    int deleteByPrimaryKey(Long id);



    int insert(Log record);



    int insertSelective(Log record);



    List<Log> selectByExample(Log example);



    Log selectByPrimaryKey(Long id);



    int updateByExampleSelective(@Param("record") Log record, @Param("example") Log example);



    int updateByExample(@Param("record") Log record, @Param("example") Log example);



    int updateByPrimaryKeySelective(Log record);



    int updateByPrimaryKey(Log record);
}
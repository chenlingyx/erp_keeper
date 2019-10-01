package com.weychain.erp.mapper;


import com.weychain.erp.domain.DO.SystemConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SystemConfigMapper {

    int countByExample(SystemConfig example);


    int deleteByExample(SystemConfig example);


    int deleteByPrimaryKey(Long id);


    int insert(SystemConfig record);


    int insertSelective(SystemConfig record);


    List<SystemConfig> selectByExample(SystemConfig example);


    SystemConfig selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") SystemConfig record, @Param("example") SystemConfig example);


    int updateByExample(@Param("record") SystemConfig record, @Param("example") SystemConfig example);


    int updateByPrimaryKeySelective(SystemConfig record);



    int updateByPrimaryKey(SystemConfig record);
}
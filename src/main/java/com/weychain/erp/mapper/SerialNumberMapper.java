package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.SerialNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SerialNumberMapper {

    int countByExample(SerialNumber example);


    int deleteByExample(SerialNumber example);


    int deleteByPrimaryKey(Long id);


    int insert(SerialNumber record);


    int insertSelective(SerialNumber record);


    List<SerialNumber> selectByExample(SerialNumber example);


    SerialNumber selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") SerialNumber record, @Param("example") SerialNumber example);


    int updateByExample(@Param("record") SerialNumber record, @Param("example") SerialNumber example);


    int updateByPrimaryKeySelective(SerialNumber record);


    int updateByPrimaryKey(SerialNumber record);
}
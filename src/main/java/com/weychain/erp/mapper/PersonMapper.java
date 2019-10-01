package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PersonMapper {

    int countByExample(Person example);


    int deleteByExample(Person example);


    int deleteByPrimaryKey(Long id);


    int insert(Person record);


    int insertSelective(Person record);


    List<Person> selectByExample(Person example);


    Person selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Person record, @Param("example") Person example);


    int updateByExample(@Param("record") Person record, @Param("example") Person example);


    int updateByPrimaryKeySelective(Person record);


    int updateByPrimaryKey(Person record);
}
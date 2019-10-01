package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.App;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AppMapper {

    int countByExample(App  example);


    int deleteByExample(App example);


    int deleteByPrimaryKey(Long id);


    int insert(App record);


    int insertSelective(App record);


    List<App> selectByExample(App example);


    App selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") App record, @Param("example") App example);


    int updateByExample(@Param("record") App record, @Param("example") App example);


    int updateByPrimaryKeySelective(App record);


    int updateByPrimaryKey(App record);
}
package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CityMapper {

    int countByExample(City example);


    int deleteByExample(City example);


    int deleteByPrimaryKey(Integer id);


    int insert(City record);


    int insertSelective(City record);


    List<City> selectByExample(City example);


    City selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") City record, @Param("example") City example);


    int updateByExample(@Param("record") City record, @Param("example") City example);


    int updateByPrimaryKeySelective(City record);


    int updateByPrimaryKey(City record);
}
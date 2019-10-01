package com.weychain.erp.mapper;


import com.weychain.erp.domain.DO.InOutItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InOutItemMapper {

    int countByExample(InOutItem example);


    int deleteByExample(InOutItem example);

    int deleteByPrimaryKey(Long id);


    int insert(InOutItem record);


    int insertSelective(InOutItem record);


    List<InOutItem> selectByExample(InOutItem example);

    InOutItem selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") InOutItem record, @Param("example") InOutItem example);


    int updateByExample(@Param("record") InOutItem record, @Param("example") InOutItem example);


    int updateByPrimaryKeySelective(InOutItem record);



    int updateByPrimaryKey(InOutItem record);
}
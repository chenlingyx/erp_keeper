package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MsgMapper {

    int countByExample(Msg example);


    int deleteByExample(Msg example);


    int deleteByPrimaryKey(Long id);


    int insert(Msg record);


    int insertSelective(Msg record);


    List<Msg> selectByExample(Msg example);


    Msg selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Msg record, @Param("example") Msg example);


    int updateByExample(@Param("record") Msg record, @Param("example") Msg example);


    int updateByPrimaryKeySelective(Msg record);


    int updateByPrimaryKey(Msg record);
}
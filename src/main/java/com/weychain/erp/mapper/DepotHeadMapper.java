package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.DepotHead;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DepotHeadMapper {

    int countByExample(DepotHead example);


    int deleteByExample(DepotHead example);


    int deleteByPrimaryKey(Long id);


    int insert(DepotHead record);


    int insertSelective(DepotHead record);


    List<DepotHead> selectByExample(DepotHead example);


    DepotHead selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") DepotHead record, @Param("example") DepotHead example);


    int updateByExample(@Param("record") DepotHead record, @Param("example") DepotHead example);


    int updateByPrimaryKeySelective(DepotHead record);

    int updateByPrimaryKey(DepotHead record);
}
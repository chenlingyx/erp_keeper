package com.weychain.erp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.OrganTypeName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrganTypeNameMapper extends BaseMapper<OrganTypeName> {
    /**
     * 查询机构类型名称列表
     * @return
     */
    List<OrganTypeName> queryOrganTypeNameList();

    int countByExample(OrganTypeName example);


    int deleteByExample(OrganTypeName example);


    int deleteByPrimaryKey(Integer id);


    int insert(OrganTypeName record);


    int insertSelective(OrganTypeName record);


    List<OrganTypeName> selectByExample(OrganTypeName example);


    OrganTypeName selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") OrganTypeName record, @Param("example") OrganTypeName example);


    int updateByExample(@Param("record") OrganTypeName record, @Param("example") OrganTypeName example);


    int updateByPrimaryKeySelective(OrganTypeName record);


    int updateByPrimaryKey(OrganTypeName record);
}
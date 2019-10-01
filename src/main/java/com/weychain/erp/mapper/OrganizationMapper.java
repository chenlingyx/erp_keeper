package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface OrganizationMapper {

    int countByExample(Organization example);


    int deleteByExample(Organization example);


    int deleteByPrimaryKey(Long id);


    int insert(Organization record);

    int insertSelective(Organization record);


    List<Organization> selectByExample(Organization example);


    Organization selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Organization record, @Param("example") Organization example);


    int updateByExample(@Param("record") Organization record, @Param("example") Organization example);


    int updateByPrimaryKeySelective(Organization record);


    int updateByPrimaryKey(Organization record);
}
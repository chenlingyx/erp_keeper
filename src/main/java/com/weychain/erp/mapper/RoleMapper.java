package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper {

    int countByExample(Role example);


    int deleteByExample(Role example);


    int deleteByPrimaryKey(Long id);


    int insert(Role record);


    int insertSelective(Role record);


    List<Role> selectByExample(Role example);


    Role selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Role record, @Param("example") Role example);


    int updateByExample(@Param("record") Role record, @Param("example") Role example);


    int updateByPrimaryKeySelective(Role record);


    int updateByPrimaryKey(Role record);
}
package com.weychain.erp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.Tenant;
import com.weychain.erp.domain.example.TenantExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

public interface TenantMapper {

    int countByExample(Tenant example);


    int deleteByExample(Tenant example);


    int deleteByPrimaryKey(Long id);


    int insert(Tenant record);


    int insertSelective(Tenant record);


    List<Tenant> selectByExample(Tenant example);


    Tenant selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Tenant record, @Param("example") Tenant example);


    int updateByExample(@Param("record") Tenant record, @Param("example") Tenant example);


    int updateByPrimaryKeySelective(Tenant record);


    int updateByPrimaryKey(Tenant record);
}


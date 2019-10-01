package com.weychain.erp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.ERP_Account;

import java.util.List;

import com.weychain.erp.domain.example.ERP_AccountExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ERP_AccountMapper extends BaseMapper<ERP_Account> {

    /**
     * 查询账户信息
     * @return
     */

    List<ERP_Account> queryErpAccountList ();
    /**
     * 新增账户信息
     */


    int countByExample(ERP_Account example);


    int deleteByExample(ERP_Account example);


    int deleteByPrimaryKey(Integer id);


    int insert(ERP_Account record);


    int insertSelective(ERP_Account record);


    List<ERP_Account> selectByExample(ERP_Account example);


    ERP_Account selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") ERP_Account record, @Param("example") ERP_Account example);


    int updateByExample(@Param("record") ERP_Account record, @Param("example") ERP_Account example);


    int updateByPrimaryKeySelective(ERP_Account record);


    int updateByPrimaryKey(ERP_Account record);
}
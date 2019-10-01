package com.weychain.erp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    int countByExample(Account example);


    int deleteByExample(Account example);


    int deleteByPrimaryKey(Long id);

    int insert(Account record);


    int insertSelective(Account record);


    List<Account> selectByExample(Account example);


    Account selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") Account record, @Param("example") Account example);


    int updateByExample(@Param("record") Account record, @Param("example") Account example);


    int updateByPrimaryKeySelective(Account record);


    int updateByPrimaryKey(Account record);
}
package com.weychain.erp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.AccountItem;
@Mapper
public interface AccountItemMapper {

    int countByExample(AccountItem example);


    int deleteByExample(AccountItem example);


    int deleteByPrimaryKey(Long id);


    int insert(AccountItem record);


    int insertSelective(AccountItem record);


    List<AccountItem> selectByExample(AccountItem example);


    AccountItem selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") AccountItem record, @Param("example") AccountItem example);


    int updateByExample(@Param("record") AccountItem record, @Param("example") AccountItem example);


    int updateByPrimaryKeySelective(AccountItem record);


    int updateByPrimaryKey(AccountItem record);
}
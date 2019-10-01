package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.AccountHead;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AccountHeadMapper {

    int countByExample(AccountHead example);


    int deleteByExample(AccountHead example);


    int deleteByPrimaryKey(Long id);


    int insert(AccountHead record);


    int insertSelective(AccountHead record);


    List<AccountHead> selectByExample(AccountHead example);


    AccountHead selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") AccountHead record, @Param("example") AccountHead example);


    int updateByExample(@Param("record") AccountHead record, @Param("example") AccountHead example);


    int updateByPrimaryKeySelective(AccountHead record);


    int updateByPrimaryKey(AccountHead record);
}
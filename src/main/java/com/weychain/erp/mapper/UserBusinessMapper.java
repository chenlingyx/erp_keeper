package com.weychain.erp.mapper;

import com.weychain.erp.domain.DO.UserBusiness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserBusinessMapper {

    int countByExample(UserBusiness example);


    int deleteByExample(UserBusiness example);


    int deleteByPrimaryKey(Long id);


    int insert(UserBusiness record);


    int insertSelective(UserBusiness record);


    List<UserBusiness> selectByExample(UserBusiness example);


    UserBusiness selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") UserBusiness record, @Param("example") UserBusiness example);


    int updateByExample(@Param("record") UserBusiness record, @Param("example") UserBusiness example);


    int updateByPrimaryKeySelective(UserBusiness record);


    int updateByPrimaryKey(UserBusiness record);
}
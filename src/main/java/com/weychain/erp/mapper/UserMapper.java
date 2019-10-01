package com.weychain.erp.mapper;


import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.example.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int countByExample(User example);


    int deleteByExample(User example);


    int deleteByPrimaryKey(Long id);


    int insert(User record);


    int insertSelective(User record);


    List<User> selectByExample(User example);


    User selectByPrimaryKey(Long id);


    int updateByExampleSelective(@Param("record") User record, @Param("example") User example);


    int updateByExample(@Param("record") User record, @Param("example") User example);


    int updateByPrimaryKeySelective(User record);



    int updateByPrimaryKey(User record);
}
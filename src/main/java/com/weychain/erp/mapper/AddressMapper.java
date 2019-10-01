package com.weychain.erp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weychain.erp.domain.DO.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    /**
     * 遍历查询地址列表
     * @param
     * @return
     */
    List<Address> queryAddressList ();

    int countByExample(Address example);


    int deleteByExample(Address example);


    int deleteByPrimaryKey(Integer id);


    int insert(Address record);


    int insertSelective(Address record);


    List<Address> selectByExample(Address example);


    Address selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") Address record, @Param("example") Address  example);


    int updateByExample(@Param("record") Address record, @Param("example") Address example);


    int updateByPrimaryKeySelective(Address record);


    int updateByPrimaryKey(Address record);
}
package com.weychain.erp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.Supplier;

import java.util.Date;
import java.util.List;
@Mapper
public interface SupplierMapperEx {

    List<Supplier> selectByConditionSupplier(
            @Param("supplier") String supplier,
            @Param("type") String type,
            @Param("phonenum") String phonenum,
            @Param("telephone") String telephone,
            @Param("description") String description,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsBySupplier(
            @Param("supplier") String supplier,
            @Param("type") String type,
            @Param("phonenum") String phonenum,
            @Param("telephone") String telephone,
            @Param("description") String description);

    List<Supplier> findByAll(
            @Param("supplier") String supplier,
            @Param("type") String type,
            @Param("phonenum") String phonenum,
            @Param("telephone") String telephone,
            @Param("description") String description);

    int batchDeleteSupplierByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}
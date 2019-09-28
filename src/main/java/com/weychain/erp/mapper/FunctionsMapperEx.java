package com.weychain.erp.mapper;

import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.Functions;

import java.util.Date;
import java.util.List;

public interface FunctionsMapperEx {

    List<Functions> selectByConditionFunctions(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByFunctions(
            @Param("name") String name,
            @Param("type") String type);

    int batchDeleteFunctionsByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}
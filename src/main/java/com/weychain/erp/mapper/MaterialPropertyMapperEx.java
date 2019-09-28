package com.weychain.erp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.MaterialProperty;

import java.util.Date;
import java.util.List;
@Mapper
public interface MaterialPropertyMapperEx {

    List<MaterialProperty> selectByConditionMaterialProperty(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByMaterialProperty(@Param("name") String name);

    int batchDeleteMaterialPropertyByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}
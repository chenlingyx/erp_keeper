package com.weychain.erp.service;

import com.weychain.erp.domain.DO.MaterialProperty;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MaterialPropertyService {
    MaterialProperty getMaterialProperty(long id)throws Exception;

    List<MaterialProperty> getMaterialProperty()throws Exception;

    List<MaterialProperty> select(String name, int offset, int rows)throws Exception;

    Long countMaterialProperty(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertMaterialProperty(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateMaterialProperty(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteMaterialProperty(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialProperty(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialPropertyByIds(String ids) throws Exception;
}

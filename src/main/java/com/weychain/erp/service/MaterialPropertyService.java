package com.weychain.erp.service;

import com.weychain.erp.domain.DO.MaterialProperty;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

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
=======
import java.util.Map;

public interface MaterialPropertyService {
    abstract MaterialProperty getMaterialProperty(long id)throws Exception;

    abstract List<MaterialProperty> getMaterialProperty()throws Exception;

    abstract List<MaterialProperty> select(String name, int offset, int rows)throws Exception;

    abstract Long countMaterialProperty(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertMaterialProperty(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateMaterialProperty(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteMaterialProperty(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMaterialProperty(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMaterialPropertyByIds(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getMaterialPropertyList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

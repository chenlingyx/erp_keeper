package com.weychain.erp.service;

import com.weychain.erp.domain.DO.MaterialCategory;
import com.weychain.erp.domain.VO.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface MaterialCategoryService {
    abstract MaterialCategory getMaterialCategory(long id)throws Exception;

    abstract List<MaterialCategory> getMaterialCategory()throws Exception;

    abstract List<MaterialCategory> getAllList(Long parentId)throws Exception;

    abstract List<MaterialCategory> getMCList(Long parentId)throws Exception;

    abstract List<MaterialCategory> select(String name, Integer parentId, int offset, int rows) throws Exception;

    abstract Long countMaterialCategory(String name, Integer parentId) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertMaterialCategory(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateMaterialCategory(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteMaterialCategory(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMaterialCategory(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract List<MaterialCategory> findById(Long id)throws Exception;

    abstract List<TreeNode> getMaterialCategoryTree(Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int addMaterialCategory(MaterialCategory mc) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMaterialCategoryByIds(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int editMaterialCategory(MaterialCategory mc) throws Exception;

    abstract void  checkMaterialCategorySerialNo(MaterialCategory mc)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMaterialCategoryByIdsNormal(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getMaterialCategoryList(Map<String, String> map) throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
}

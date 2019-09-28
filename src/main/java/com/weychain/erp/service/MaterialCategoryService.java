package com.weychain.erp.service;

import com.weychain.erp.domain.DO.MaterialCategory;
import com.weychain.erp.domain.VO.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MaterialCategoryService {
    MaterialCategory getMaterialCategory(long id)throws Exception;

    List<MaterialCategory> getMaterialCategory()throws Exception;

    List<MaterialCategory> getAllList(Long parentId)throws Exception;

    List<MaterialCategory> getMCList(Long parentId)throws Exception;

    List<MaterialCategory> select(String name, Integer parentId, int offset, int rows) throws Exception;

    Long countMaterialCategory(String name, Integer parentId) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertMaterialCategory(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateMaterialCategory(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteMaterialCategory(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialCategory(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<MaterialCategory> findById(Long id)throws Exception;

    List<TreeNode> getMaterialCategoryTree(Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int addMaterialCategory(MaterialCategory mc) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialCategoryByIds(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int editMaterialCategory(MaterialCategory mc) throws Exception;

    void  checkMaterialCategorySerialNo(MaterialCategory mc)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialCategoryByIdsNormal(String ids) throws Exception;
}

package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Material;
import com.weychain.erp.domain.DO.MaterialVo4Unit;
import com.weychain.erp.utils.BaseResponseInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface MaterialService {
    Material getMaterial(long id)throws Exception;

    List<Material> getMaterial() throws Exception;

    List<MaterialVo4Unit> select(String name, String model, String categoryIds, String mpList, int offset, int rows)
            throws Exception;

    Long countMaterial(String name, String model, String categoryIds, String mpList)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertMaterial(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateMaterial(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteMaterial(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterial(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    int checkIsExist(Long id, String name, String model, String color, String standard, String mfrs,
                     String otherField1, String otherField2, String otherField3, String unit, Long unitId)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchSetEnable(Boolean enabled, String materialIDs)throws Exception;

    String findUnitName(Long mId)throws Exception;

    List<MaterialVo4Unit> findById(Long id)throws Exception;

    List<MaterialVo4Unit> findBySelect()throws Exception;

    List<Material> findByOrder()throws Exception;

    List<MaterialVo4Unit> findByAll(String name, String model, String categoryIds)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    BaseResponseInfo importExcel(List<Material> mList) throws Exception;

    List<Material> getMaterialEnableSerialNumberList(Map<String, Object> parameterMap)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialByIds(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMaterialByIdsNormal(String ids) throws Exception;
}

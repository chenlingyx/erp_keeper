package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Supplier;
import com.weychain.erp.utils.BaseResponseInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface SupplierService {
    abstract Supplier getSupplier(long id)throws Exception;

    abstract List<Supplier> getSupplier()throws Exception;

    abstract List<Supplier> select(String supplier, String type, String phonenum,
                                   String telephone, String description, int offset, int rows) throws Exception;

    abstract Long countSupplier(String supplier, String type, String phonenum, String telephone, String description) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertSupplier(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateSupplier(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteSupplier(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSupplier(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getSupplierList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateAdvanceIn(Long supplierId, BigDecimal advanceIn)throws Exception;

    abstract List<Supplier> findBySelectCus()throws Exception;

    abstract List<Supplier> findBySelectSup()throws Exception;

    abstract List<Supplier> findBySelectRetail()throws Exception;

    abstract List<Supplier> findById(Long supplierId)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchSetEnable(Boolean enabled, String supplierIDs)throws Exception;

    abstract List<Supplier> findUserCustomer()throws Exception;

    abstract List<Supplier> findByAll(String supplier, String type, String phonenum,
                                      String telephone, String description) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract BaseResponseInfo importExcel(List<Supplier> mList) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSupplierByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSupplierByIdsNormal(String ids) throws Exception;
}

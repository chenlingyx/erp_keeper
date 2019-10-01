package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Tenant;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface TenantService {
    Tenant getTenant(long id)throws Exception;

    List<Tenant> getTenant()throws Exception;

    List<Tenant> select(String loginName, int offset, int rows)throws Exception;

    Long countTenant(String loginName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertTenant(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateTenant(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteTenant(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteTenant(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    Tenant getTenantByTenantId(long tenantId);
=======
import java.util.Map;

public interface TenantService {
    abstract Tenant getTenant(long id)throws Exception;

    abstract List<Tenant> getTenant()throws Exception;

    abstract List<Tenant> select(String loginName, int offset, int rows)throws Exception;

    abstract Long countTenant(String loginName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertTenant(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateTenant(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteTenant(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteTenant(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract Tenant getTenantByTenantId(long tenantId);

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getTenantList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

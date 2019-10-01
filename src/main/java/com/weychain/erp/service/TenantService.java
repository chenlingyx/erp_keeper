package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Tenant;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}

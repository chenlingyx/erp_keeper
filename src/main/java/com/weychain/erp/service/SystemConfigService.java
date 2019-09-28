package com.weychain.erp.service;

import com.weychain.erp.domain.DO.SystemConfig;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SystemConfigService {
    abstract SystemConfig getSystemConfig(long id)throws Exception;

    abstract List<SystemConfig> getSystemConfig()throws Exception;

    abstract List<SystemConfig> select(String companyName, int offset, int rows)throws Exception;

    abstract Long countSystemConfig(String companyName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertSystemConfig(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateSystemConfig(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteSystemConfig(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSystemConfig(String ids)throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getSystemConfigList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSystemConfigByIds(String ids)throws Exception;

    abstract boolean getDepotFlag() throws Exception;

    abstract boolean getCustomerFlag() throws Exception;
}

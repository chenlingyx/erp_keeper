package com.weychain.erp.service;

import com.weychain.erp.domain.DO.SystemConfig;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SystemConfigService {
    SystemConfig getSystemConfig(long id)throws Exception;

    List<SystemConfig> getSystemConfig()throws Exception;

    List<SystemConfig> select(String companyName, int offset, int rows)throws Exception;

    Long countSystemConfig(String companyName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertSystemConfig(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateSystemConfig(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteSystemConfig(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteSystemConfig(String ids)throws Exception;

    int checkIsNameExist(Long id, String name) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteSystemConfigByIds(String ids)throws Exception;

    boolean getDepotFlag() throws Exception;

    boolean getCustomerFlag() throws Exception;
}

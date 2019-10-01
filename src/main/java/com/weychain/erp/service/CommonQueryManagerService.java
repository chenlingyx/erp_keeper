package com.weychain.erp.service;

import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface CommonQueryManagerService {
    Object selectOne(String apiName, Long id) throws Exception;

    List<?> select(String apiName, Map<String, String> parameterMap)throws Exception;

    Long counts(String apiName, Map<String, String> parameterMap)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insert(String apiName, String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int update(String apiName, String beanJson, Long id, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int delete(String apiName, Long id, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDelete(String apiName, String ids, HttpServletRequest request)throws Exception;

    int checkIsNameExist(String apiName, Long id, String name) throws Exception;
}

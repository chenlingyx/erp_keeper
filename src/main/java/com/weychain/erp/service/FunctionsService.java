package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Functions;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FunctionsService {
    Functions getFunctions(long id)throws Exception;

    List<Functions> getFunctions()throws Exception;

    List<Functions> select(String name, String type, int offset, int rows)throws Exception;

    Long countFunctions(String name, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertFunctions(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateFunctions(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteFunctions(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteFunctions(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<Functions> getRoleFunctions(String pNumber)throws Exception;

    List<Functions> findRoleFunctions(String pnumber)throws Exception;

    List<Functions> findByIds(String functionsIds)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteFunctionsByIds(String ids)throws Exception;
}

package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Functions;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

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
=======
import java.util.Map;

public interface FunctionsService {
    abstract Functions getFunctions(long id)throws Exception;

    abstract List<Functions> getFunctions()throws Exception;

    abstract List<Functions> select(String name, String type, int offset, int rows)throws Exception;

    abstract Long countFunctions(String name, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertFunctions(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateFunctions(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteFunctions(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteFunctions(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract List<Functions> getRoleFunctions(String pNumber)throws Exception;

    abstract List<Functions> findRoleFunctions(String pnumber)throws Exception;

     List<Functions> findByIds(String functionsIds)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteFunctionsByIds(String ids)throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getFunctionsList(Map<String, String> map) throws Exception;

    Long counts(Map<String, String> map) throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

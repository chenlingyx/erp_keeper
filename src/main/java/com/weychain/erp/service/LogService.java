package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Log;
import com.weychain.erp.domain.VO.LogVo4List;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface LogService {
    Log getLog(long id)throws Exception;

    List<Log> getLog()throws Exception;

    List<LogVo4List> select(String operation, Integer usernameID, String clientIp, Integer status, String beginTime, String endTime,
                            String contentdetails, int offset, int rows)throws Exception;

    Long countLog(String operation, Integer usernameID, String clientIp, Integer status, String beginTime, String endTime,
                  String contentdetails)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertLog(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateLog(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteLog(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteLog(String ids)throws Exception;

    Long getUserId(HttpServletRequest request) throws Exception;

    String getModule(String apiName)throws Exception;

    void insertLog(String apiName, String type, HttpServletRequest request)throws Exception;
=======
import java.util.Map;

public interface LogService {
    abstract Log getLog(long id)throws Exception;

    abstract List<Log> getLog()throws Exception;

    abstract List<LogVo4List> select(String operation, Integer usernameID, String clientIp, Integer status, String beginTime, String endTime,
                                     String contentdetails, int offset, int rows)throws Exception;

    abstract Long countLog(String operation, Integer usernameID, String clientIp, Integer status, String beginTime, String endTime,
                           String contentdetails)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertLog(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateLog(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteLog(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteLog(String ids)throws Exception;

    abstract Long getUserId(HttpServletRequest request) throws Exception;

    abstract String getModule(String apiName)throws Exception;

    abstract void insertLog(String apiName, String type, HttpServletRequest request)throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getUserList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

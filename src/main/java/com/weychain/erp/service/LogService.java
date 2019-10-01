package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Log;
import com.weychain.erp.domain.VO.LogVo4List;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}

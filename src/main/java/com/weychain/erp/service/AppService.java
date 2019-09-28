package com.weychain.erp.service;

import com.weychain.erp.domain.DO.App;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AppService {
    List<App> findDock()throws Exception;

    List<App> findDesk()throws Exception;

    App getApp(long id)throws Exception;

    List<App> getApp()throws Exception;

    List<App> select(String name, String type, int offset, int rows)throws Exception;

    Long countApp(String name, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertApp(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateApp(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteApp(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteApp(String ids)throws Exception;

    List<App> findRoleAPP()throws Exception;

    List<App> findAppInIds(String ids, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAppByIds(String ids) throws Exception;

    List<App> findAppByUserId(String userId)throws Exception;

    List<App> findAppByNumber(List<String> numberList) throws Exception;
}

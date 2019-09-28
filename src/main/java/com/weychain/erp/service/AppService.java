package com.weychain.erp.service;

import com.weychain.erp.domain.DO.App;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AppService {
    abstract List<App> findDock()throws Exception;

    abstract List<App> findDesk()throws Exception;

    abstract App getApp(long id)throws Exception;

    abstract List<App> getApp()throws Exception;

    abstract List<App> select(String name, String type, int offset, int rows)throws Exception;

    abstract Long countApp(String name, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertApp(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateApp(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteApp(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteApp(String ids)throws Exception;

    abstract List<App> findRoleAPP()throws Exception;

    abstract List<App> findAppInIds(String ids, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteAppByIds(String ids) throws Exception;

    abstract List<App> findAppByUserId(String userId)throws Exception;

    abstract List<App> findAppByNumber(List<String> numberList) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getAppList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;
}

package com.weychain.erp.service;

import com.weychain.erp.domain.DO.App;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

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
=======
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
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

package com.weychain.erp.service;

import com.weychain.erp.domain.DO.UserBusiness;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface UserBusinessService {
    UserBusiness getUserBusiness(long id)throws Exception;

    List<UserBusiness> getUserBusiness()throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertUserBusiness(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateUserBusiness(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteUserBusiness(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteUserBusiness(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<UserBusiness> getBasicData(String keyId, String type)throws Exception;

    Long checkIsValueExist(String type, String keyId)throws Exception;

    Boolean checkIsUserBusinessExist(String TypeVale, String KeyIdValue, String UBValue)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateBtnStr(Long userBusinessId, String btnStr) throws Exception;

    List<UserBusiness> findRoleByUserId(String userId)throws Exception;

    List<UserBusiness> findAppByRoles(String roles)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteUserBusinessByIds(String ids) throws Exception;

    int insertOrUpdateAppValue(String type, String keyId, String functionIds) throws Exception;
=======
import java.util.Map;

public interface UserBusinessService {
    abstract UserBusiness getUserBusiness(long id)throws Exception;

    abstract List<UserBusiness> getUserBusiness()throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertUserBusiness(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateUserBusiness(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteUserBusiness(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteUserBusiness(String ids)throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getUserBusinessList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request) throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract List<UserBusiness> getBasicData(String keyId, String type)throws Exception;

    abstract Long checkIsValueExist(String type, String keyId)throws Exception;

    abstract Boolean checkIsUserBusinessExist(String TypeVale, String KeyIdValue, String UBValue)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateBtnStr(Long userBusinessId, String btnStr) throws Exception;

    abstract List<UserBusiness> findRoleByUserId(String userId)throws Exception;

    abstract List<UserBusiness> findAppByRoles(String roles)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteUserBusinessByIds(String ids) throws Exception;

    abstract int insertOrUpdateAppValue(String type, String keyId, String functionIds) throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

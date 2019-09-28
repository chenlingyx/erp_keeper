package com.weychain.erp.service;

import com.weychain.erp.domain.DO.UserBusiness;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}

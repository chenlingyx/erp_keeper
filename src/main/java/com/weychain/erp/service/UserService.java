package com.weychain.erp.service;

import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.DO.UserEx;
import com.weychain.erp.domain.VO.TreeNodeEx;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
    User getUser(long id)throws Exception;

    List<User> getUser()throws Exception;

    List<User> select(String userName, String loginName, int offset, int rows)throws Exception;

    Long countUser(String userName, String loginName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertUser(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateUser(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateUserByObj(User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int resetPwd(String md5Pwd, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteUser(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteUser(String ids)throws Exception;

    int validateUser(String username, String password) throws Exception;

    User getUserByUserName(String username)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    User getCurrentUser()throws Exception;

    List<UserEx> getUserList(Map<String, Object> parameterMap) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void addUserAndOrgUserRel(UserEx ue) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    UserEx addUser(UserEx ue) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    UserEx registerUser(UserEx ue, Integer manageRoleId, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void updateUserTenant(User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void updateUserAndOrgUserRel(UserEx ue) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    UserEx updateUser(UserEx ue)throws Exception;

    void checkUserNameAndLoginName(UserEx userEx)throws Exception;

    List<User> getUserListByUserName(String userName)throws Exception;

    List<User> getUserListByloginName(String loginName);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void batDeleteUser(String ids) throws Exception;

    List<TreeNodeEx> getOrganizationUserTree()throws Exception;
}

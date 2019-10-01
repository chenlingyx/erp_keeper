package com.weychain.erp.service;

import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.DO.UserEx;
import com.weychain.erp.domain.VO.TreeNodeEx;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {
<<<<<<< HEAD
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
=======
    abstract User getUser(long id)throws Exception;

    abstract List<User> getUser()throws Exception;

    abstract List<User> select(String userName, String loginName, int offset, int rows)throws Exception;

    abstract Long countUser(String userName, String loginName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertUser(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateUser(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateUserByObj(User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int resetPwd(String md5Pwd, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteUser(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteUser(String ids)throws Exception;

    abstract int validateUser(String username, String password) throws Exception;

    abstract User getUserByUserName(String username)throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getUserList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract User getCurrentUser()throws Exception;


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void addUserAndOrgUserRel(UserEx ue) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract UserEx addUser(UserEx ue) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract UserEx registerUser(UserEx ue, Integer manageRoleId, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void updateUserTenant(User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void updateUserAndOrgUserRel(UserEx ue) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract UserEx updateUser(UserEx ue)throws Exception;

    abstract void checkUserNameAndLoginName(UserEx userEx)throws Exception;

    abstract List<User> getUserListByUserName(String userName)throws Exception;

    abstract List<User> getUserListByloginName(String loginName);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void batDeleteUser(String ids) throws Exception;

    abstract List<TreeNodeEx> getOrganizationUserTree()throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

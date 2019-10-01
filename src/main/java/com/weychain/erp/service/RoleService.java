package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Role;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface RoleService {
    Role getRole(long id)throws Exception;

    List<Role> getRole()throws Exception;

    List<Role> select(String name, int offset, int rows)throws Exception;

    Long countRole(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertRole(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateRole(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteRole(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteRole(String ids) throws Exception;

    List<Role> findUserRole()throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteRoleByIds(String ids) throws Exception;
=======
import java.util.Map;

public interface RoleService {
    abstract Role getRole(long id)throws Exception;

    abstract List<Role> getRole()throws Exception;

    abstract List<Role> select(String name, int offset, int rows)throws Exception;

    abstract Long countRole(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertRole(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateRole(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteRole(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteRole(String ids) throws Exception;

    abstract List<Role> findUserRole()throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteRoleByIds(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getRoleList(Map<String, String> map) throws Exception;

    Long counts(Map<String, String> map) throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

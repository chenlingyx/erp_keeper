package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Role;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}

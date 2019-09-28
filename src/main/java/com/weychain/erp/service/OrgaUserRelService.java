package com.weychain.erp.service;

import com.weychain.erp.domain.DO.OrgaUserRel;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface OrgaUserRelService {
    abstract OrgaUserRel getOrgaUserRel(long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertOrgaUserRel(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateOrgaUserRel(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteOrgaUserRel(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteOrgaUserRel(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract OrgaUserRel addOrgaUserRel(OrgaUserRel orgaUserRel) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract OrgaUserRel updateOrgaUserRel(OrgaUserRel orgaUserRel) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> parameterMap)throws Exception;

    List<?> getOrgaUserRelList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> parameterMap)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;
}

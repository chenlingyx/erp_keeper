package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Organization;
import com.weychain.erp.domain.VO.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface OrganizationService {
    abstract Organization getOrganization(long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertOrganization(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateOrganization(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteOrganization(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteOrganization(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int addOrganization(Organization org) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int editOrganization(Organization org)throws Exception;

    abstract List<TreeNode> getOrganizationTree(Long id)throws Exception;

    abstract List<Organization> findById(Long id) throws Exception;

    abstract List<Organization> findByOrgNo(String orgNo)throws Exception;

    abstract void checkOrgNoIsExists(String orgNo, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteOrganizationByIds(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> parameterMap)throws Exception;

    List<?> getOrganizationList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> parameterMap)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;
}

package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Organization;
import com.weychain.erp.domain.VO.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrganizationService {
    Organization getOrganization(long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertOrganization(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateOrganization(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteOrganization(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteOrganization(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int addOrganization(Organization org) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int editOrganization(Organization org)throws Exception;

    List<TreeNode> getOrganizationTree(Long id)throws Exception;

    List<Organization> findById(Long id) throws Exception;

    List<Organization> findByOrgNo(String orgNo)throws Exception;

    void checkOrgNoIsExists(String orgNo, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteOrganizationByIds(String ids) throws Exception;
}

package com.weychain.erp.service;

import com.weychain.erp.domain.DO.OrgaUserRel;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

public interface OrgaUserRelService {
    OrgaUserRel getOrgaUserRel(long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertOrgaUserRel(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateOrgaUserRel(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteOrgaUserRel(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteOrgaUserRel(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    OrgaUserRel addOrgaUserRel(OrgaUserRel orgaUserRel) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    OrgaUserRel updateOrgaUserRel(OrgaUserRel orgaUserRel) throws Exception;
}

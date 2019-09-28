package com.weychain.erp.service;

import com.weychain.erp.domain.DO.AccountItem;
import com.weychain.erp.domain.VO.AccountItemVo4List;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AccountItemService {
    AccountItem getAccountItem(long id)throws Exception;

    List<AccountItem> getAccountItem()throws Exception;

    List<AccountItem> select(String name, Integer type, String remark, int offset, int rows)throws Exception;

    Long countAccountItem(String name, Integer type, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertAccountItem(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateAccountItem(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteAccountItem(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountItem(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertAccountItemWithObj(AccountItem accountItem)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateAccountItemWithObj(AccountItem accountItem)throws Exception;

    List<AccountItemVo4List> getDetailList(Long headerId);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    String saveDetials(String inserted, String deleted, String updated, Long headerId, String listType) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountItemByIds(String ids) throws Exception;
}

package com.weychain.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weychain.erp.domain.DO.Account;
import com.weychain.erp.domain.VO.AccountVo4InOutList;
import com.weychain.erp.domain.VO.AccountVo4List;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

public interface AccountService extends IService<Account> {
    Account getAccount(long id) throws Exception;

    List<Account> getAccount() throws Exception;

    List<AccountVo4List> select(String name, String serialNo, String remark, int offset, int rows) throws Exception;

    Long countAccount(String name, String serialNo, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertAccount(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateAccount(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteAccount(Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccount(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<Account> findBySelect()throws Exception;

    BigDecimal getAccountSum(Long id, String timeStr, String type) throws Exception;

    BigDecimal getAccountSumByHead(Long id, String timeStr, String type) throws Exception;

    BigDecimal getAccountSumByDetail(Long id, String timeStr, String type)throws Exception;

    BigDecimal getManyAccountSum(Long id, String timeStr, String type)throws Exception;

    List<AccountVo4InOutList> findAccountInOutList(Long accountId, Integer offset, Integer rows) throws Exception;

    int findAccountInOutListCount(Long accountId) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateAmountIsDefault(Boolean isDefault, Long accountId) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountByIds(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountByIdsNormal(String ids) throws Exception;
}

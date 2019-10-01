package com.weychain.erp.service;

import com.weychain.erp.domain.DO.AccountHead;
import com.weychain.erp.domain.DO.AccountHeadVo4ListEx;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

public interface AccountHeadService {


    AccountHead getAccountHead(long id) throws Exception;

    List<AccountHead> getAccountHead() throws Exception;

    List<AccountHeadVo4ListEx> select(String type, String billNo, String beginTime, String endTime, int offset, int rows) throws Exception;

    Long countAccountHead(String type, String billNo, String beginTime, String endTime) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertAccountHead(String beanJson, HttpServletRequest request) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateAccountHead(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteAccountHead(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountHead(String ids)throws Exception;

<<<<<<< HEAD
=======
    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getAccountHeadList(Map<String, String> map)throws Exception;

    abstract Long counts(Map<String, String> map)throws Exception;

    abstract int insert(String beanJson, HttpServletRequest request) throws Exception;

    abstract int update(String beanJson, Long id)throws Exception;

    abstract int delete(Long id)throws Exception;

    abstract int batchDelete(String ids)throws Exception;

>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    int checkIsNameExist(Long id, String name)throws Exception;

    Long getMaxId()throws Exception;

    BigDecimal findAllMoney(Integer supplierId, String type, String mode, String endTime);

    BigDecimal allMoney(String getS, String type, String mode, String endTime);

    BigDecimal findTotalPay(Integer supplierId, String endTime, String supType);

    List<AccountHeadVo4ListEx> getDetailByNumber(String billNo)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountHeadByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteAccountHeadByIdsNormal(String ids) throws Exception;
}

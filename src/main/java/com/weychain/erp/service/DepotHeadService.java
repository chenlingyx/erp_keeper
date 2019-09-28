package com.weychain.erp.service;

import com.weychain.erp.domain.DO.DepotHead;
import com.weychain.erp.domain.VO.DepotHeadVo4InDetail;
import com.weychain.erp.domain.VO.DepotHeadVo4InOutMCount;
import com.weychain.erp.domain.VO.DepotHeadVo4List;
import com.weychain.erp.domain.VO.DepotHeadVo4StatementAccount;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DepotHeadService {
    abstract DepotHead getDepotHead(long id)throws Exception;

    abstract List<DepotHead> getDepotHead()throws Exception;

    abstract List<DepotHeadVo4List> select(String type, String subType, String number, String beginTime, String endTime,
                                           String materialParam, String depotIds, int offset, int rows)throws Exception;

    abstract Long countDepotHead(String type, String subType, String number, String beginTime, String endTime,
                                 String materialParam, String depotIds) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertDepotHead(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateDepotHead(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteDepotHead(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepotHead(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchSetStatus(String status, String depotHeadIDs)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract String buildOnlyNumber()throws Exception;

    abstract Long getMaxId()throws Exception;

    abstract String findMaterialsListByHeaderId(Long id)throws Exception;

    abstract List<DepotHead> findByMonth(String monthTime)throws Exception;

    abstract List<DepotHead> getDepotHeadGiftOut(String projectId)throws Exception;

    abstract List<DepotHeadVo4InDetail> findByAll(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId, Integer offset, Integer rows) throws Exception;

    abstract int findByAllCount(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId) throws Exception;

    abstract List<DepotHeadVo4InOutMCount> findInOutMaterialCount(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId, Integer offset, Integer rows)throws Exception;

    abstract int findInOutMaterialCountTotal(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId)throws Exception;

    abstract List<DepotHeadVo4StatementAccount> findStatementAccount(String beginTime, String endTime, Integer organId, String supType, Integer offset, Integer rows)throws Exception;

    abstract int findStatementAccountCount(String beginTime, String endTime, Integer organId, String supType) throws Exception;

    abstract BigDecimal findAllMoney(Integer supplierId, String type, String subType, String mode, String endTime)throws Exception;

    abstract BigDecimal allMoney(String getS, String type, String subType, String mode, String endTime);

    abstract BigDecimal findTotalPay(Integer supplierId, String endTime, String supType);

    abstract List<DepotHeadVo4List> getDetailByNumber(String number)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void addDepotHeadAndDetail(String beanJson, String inserted, String deleted, String updated) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void updateDepotHeadAndDetail(Long id, String beanJson, String inserted, String deleted, String updated, BigDecimal preTotalPrice)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void deleteDepotHeadAndDetail(Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void batchDeleteDepotHeadAndDetail(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepotHeadByIds(String ids)throws Exception;

    abstract BigDecimal getBuyAndSaleStatistics(String type, String subType, Integer hasSupplier, String beginTime, String endTime);

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getDepotHeadList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request) throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
}

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

public interface DepotHeadService {
    DepotHead getDepotHead(long id)throws Exception;

    List<DepotHead> getDepotHead()throws Exception;

    List<DepotHeadVo4List> select(String type, String subType, String number, String beginTime, String endTime,
                                  String materialParam, String depotIds, int offset, int rows)throws Exception;

    Long countDepotHead(String type, String subType, String number, String beginTime, String endTime,
                        String materialParam, String depotIds) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertDepotHead(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateDepotHead(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteDepotHead(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepotHead(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchSetStatus(String status, String depotHeadIDs)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    String buildOnlyNumber()throws Exception;

    Long getMaxId()throws Exception;

    String findMaterialsListByHeaderId(Long id)throws Exception;

    List<DepotHead> findByMonth(String monthTime)throws Exception;

    List<DepotHead> getDepotHeadGiftOut(String projectId)throws Exception;

    List<DepotHeadVo4InDetail> findByAll(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId, Integer offset, Integer rows) throws Exception;

    int findByAllCount(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId) throws Exception;

    List<DepotHeadVo4InOutMCount> findInOutMaterialCount(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId, Integer offset, Integer rows)throws Exception;

    int findInOutMaterialCountTotal(String beginTime, String endTime, String type, Integer pid, String dids, Integer oId)throws Exception;

    List<DepotHeadVo4StatementAccount> findStatementAccount(String beginTime, String endTime, Integer organId, String supType, Integer offset, Integer rows)throws Exception;

    int findStatementAccountCount(String beginTime, String endTime, Integer organId, String supType) throws Exception;

    BigDecimal findAllMoney(Integer supplierId, String type, String subType, String mode, String endTime)throws Exception;

    BigDecimal allMoney(String getS, String type, String subType, String mode, String endTime);

    BigDecimal findTotalPay(Integer supplierId, String endTime, String supType);

    List<DepotHeadVo4List> getDetailByNumber(String number)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void addDepotHeadAndDetail(String beanJson, String inserted, String deleted, String updated) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void updateDepotHeadAndDetail(Long id, String beanJson, String inserted, String deleted, String updated, BigDecimal preTotalPrice)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void deleteDepotHeadAndDetail(Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void batchDeleteDepotHeadAndDetail(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepotHeadByIds(String ids)throws Exception;

    BigDecimal getBuyAndSaleStatistics(String type, String subType, Integer hasSupplier, String beginTime, String endTime);
}

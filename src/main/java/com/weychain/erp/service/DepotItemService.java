package com.weychain.erp.service;

import com.weychain.erp.domain.DO.DepotItem;
import com.weychain.erp.domain.DO.DepotItemVo4DetailByTypeAndMId;
import com.weychain.erp.domain.DO.DepotItemVo4Material;
import com.weychain.erp.domain.DO.DepotItemVo4WithInfoEx;
import com.weychain.erp.domain.VO.DepotItemStockWarningCount;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DepotItemService {
    DepotItem getDepotItem(long id)throws Exception;

    List<DepotItem> getDepotItem()throws Exception;

    List<DepotItem> select(String name, Integer type, String remark, int offset, int rows)throws Exception;

    Long countDepotItem(String name, Integer type, String remark) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertDepotItem(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateDepotItem(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteDepotItem(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepotItem(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<DepotItemVo4DetailByTypeAndMId> findDetailByTypeAndMaterialIdList(Map<String, String> map)throws Exception;

    Long findDetailByTypeAndMaterialIdCounts(Map<String, String> map)throws Exception;

    List<DepotItemVo4Material> findStockNumByMaterialIdList(Map<String, String> map)throws Exception;

    Long findStockNumByMaterialIdCounts(Map<String, String> map)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertDepotItemWithObj(DepotItem depotItem)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateDepotItemWithObj(DepotItem depotItem)throws Exception;

    Long findByTypeAndMaterialId(String type, Long mId) throws Exception;

    int findByTypeAndMaterialIdAndDepotId(String type, Long mId, Long depotId);

    List<DepotItemVo4WithInfoEx> getDetailList(Long headerId)throws Exception;

    List<DepotItemVo4WithInfoEx> findByAll(String headIds, String materialIds, Integer offset, Integer rows)throws Exception;

    int findByAllCount(String headIds, String materialIds)throws Exception;

    BigDecimal findByType(String type, Integer ProjectId, Long MId, String MonthTime, Boolean isPrev)throws Exception;

    BigDecimal findPriceByType(String type, Integer ProjectId, Long MId, String MonthTime, Boolean isPrev)throws Exception;

    BigDecimal findAssembleByType(String subType, String mType, Integer ProjectId, Long MId, String MonthTime, Boolean isPrev)throws Exception;

    BigDecimal buyOrSale(String type, String subType, Long MId, String MonthTime, String sumType) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    String saveDetials(String inserted, String deleted, String updated, Long headerId) throws Exception;

    String findUnitName(Long mId) throws Exception;

    int getCurrentInStock(Long materialId, Long depotId);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepotItemByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    List<DepotItemStockWarningCount> findStockWarningCount(int offset, Integer rows, Integer pid);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int findStockWarningCountTotal(Integer pid);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    BigDecimal getFinishNumber(Long mid, Long headerId);
}

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
    abstract DepotItem getDepotItem(long id)throws Exception;

    abstract List<DepotItem> getDepotItem()throws Exception;

    abstract List<DepotItem> select(String name, Integer type, String remark, int offset, int rows)throws Exception;

    abstract Long countDepotItem(String name, Integer type, String remark) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertDepotItem(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateDepotItem(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteDepotItem(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepotItem(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract List<DepotItemVo4DetailByTypeAndMId> findDetailByTypeAndMaterialIdList(Map<String, String> map)throws Exception;

    abstract Long findDetailByTypeAndMaterialIdCounts(Map<String, String> map)throws Exception;

    abstract List<DepotItemVo4Material> findStockNumByMaterialIdList(Map<String, String> map)throws Exception;

    abstract Long findStockNumByMaterialIdCounts(Map<String, String> map)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertDepotItemWithObj(DepotItem depotItem)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateDepotItemWithObj(DepotItem depotItem)throws Exception;

    abstract Long findByTypeAndMaterialId(String type, Long mId) throws Exception;

    abstract int findByTypeAndMaterialIdAndDepotId(String type, Long mId, Long depotId);

    abstract List<DepotItemVo4WithInfoEx> getDetailList(Long headerId)throws Exception;

    abstract List<DepotItemVo4WithInfoEx> findByAll(String headIds, String materialIds, Integer offset, Integer rows)throws Exception;

    abstract int findByAllCount(String headIds, String materialIds)throws Exception;

    abstract BigDecimal findByType(String type, Integer ProjectId, Long MId, String MonthTime, Boolean isPrev)throws Exception;

    abstract BigDecimal findPriceByType(String type, Integer ProjectId, Long MId, String MonthTime, Boolean isPrev)throws Exception;

    abstract BigDecimal findAssembleByType(String subType, String mType, Integer ProjectId, Long MId, String MonthTime, Boolean isPrev)throws Exception;

    abstract BigDecimal buyOrSale(String type, String subType, Long MId, String MonthTime, String sumType) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract String saveDetials(String inserted, String deleted, String updated, Long headerId) throws Exception;

    abstract String findUnitName(Long mId) throws Exception;

    abstract int getCurrentInStock(Long materialId, Long depotId);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepotItemByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract List<DepotItemStockWarningCount> findStockWarningCount(int offset, Integer rows, Integer pid);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int findStockWarningCountTotal(Integer pid);

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract BigDecimal getFinishNumber(Long mid, Long headerId);

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getDepotItemList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
}

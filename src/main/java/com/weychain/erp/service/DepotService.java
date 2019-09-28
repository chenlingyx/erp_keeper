package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Depot;
import com.weychain.erp.domain.DO.DepotEx;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DepotService {
    Depot getDepot(long id)throws Exception;

    List<Depot> getDepot()throws Exception;

    List<Depot> getAllList()throws Exception;

    List<Depot> select(String name, Integer type, String remark, int offset, int rows)throws Exception;

    Long countDepot(String name, Integer type, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertDepot(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateDepot(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteDepot(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepot(String ids) throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<Depot> findUserDepot()throws Exception;

    List<Depot> findGiftByType(Integer type)throws Exception;

    List<DepotEx> getDepotList(Map<String, Object> parameterMap)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepotByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteDepotByIdsNormal(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateDepotIsDefault(Boolean isDefault, Long depotID) throws Exception;
}

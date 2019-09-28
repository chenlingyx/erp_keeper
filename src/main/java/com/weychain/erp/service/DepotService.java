package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Depot;
import com.weychain.erp.domain.DO.DepotEx;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface DepotService {
    abstract Depot getDepot(long id)throws Exception;

    abstract List<Depot> getDepot()throws Exception;

    abstract List<Depot> getAllList()throws Exception;

    abstract List<Depot> select(String name, Integer type, String remark, int offset, int rows)throws Exception;

    abstract Long countDepot(String name, Integer type, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertDepot(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateDepot(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteDepot(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepot(String ids) throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract List<Depot> findUserDepot()throws Exception;

    abstract List<Depot> findGiftByType(Integer type)throws Exception;


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepotByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteDepotByIdsNormal(String ids) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateDepotIsDefault(Boolean isDefault, Long depotID) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getDepotList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request) throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
}

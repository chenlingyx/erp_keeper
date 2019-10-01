package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Unit;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UnitService {
    Unit getUnit(long id)throws Exception;

    List<Unit> getUnit()throws Exception;

    List<Unit> select(String name, int offset, int rows)throws Exception;

    Long countUnit(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertUnit(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateUnit(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteUnit(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteUnit(String ids) throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteUnitByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteUnitByIdsNormal(String ids) throws Exception;
}

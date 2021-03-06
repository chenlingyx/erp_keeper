package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Unit;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

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
=======
import java.util.Map;

public interface UnitService {
    abstract Unit getUnit(long id)throws Exception;

    abstract List<Unit> getUnit()throws Exception;

    abstract List<Unit> select(String name, int offset, int rows)throws Exception;

    abstract Long countUnit(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertUnit(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateUnit(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteUnit(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteUnit(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getUnitList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteUnitByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteUnitByIdsNormal(String ids) throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

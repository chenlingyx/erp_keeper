package com.weychain.erp.service;

import com.weychain.erp.domain.DO.InOutItem;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface InOutItemService {
    InOutItem getInOutItem(long id)throws Exception;

    List<InOutItem> getInOutItem()throws Exception;

    List<InOutItem> select(String name, String type, String remark, int offset, int rows)throws Exception;

    Long countInOutItem(String name, String type, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertInOutItem(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateInOutItem(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteInOutItem(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteInOutItem(String ids)throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    List<InOutItem> findBySelect(String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteInOutItemByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteInOutItemByIdsNormal(String ids) throws Exception;
=======
import java.util.Map;

public interface InOutItemService {
    abstract InOutItem getInOutItem(long id)throws Exception;

    abstract List<InOutItem> getInOutItem()throws Exception;

    abstract List<InOutItem> select(String name, String type, String remark, int offset, int rows)throws Exception;

    abstract Long countInOutItem(String name, String type, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertInOutItem(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateInOutItem(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteInOutItem(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteInOutItem(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    abstract List<InOutItem> findBySelect(String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteInOutItemByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteInOutItemByIdsNormal(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getFunctionsList(Map<String, String> map)throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

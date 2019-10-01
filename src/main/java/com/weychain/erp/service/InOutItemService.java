package com.weychain.erp.service;

import com.weychain.erp.domain.DO.InOutItem;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}

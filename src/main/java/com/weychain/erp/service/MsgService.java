package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Msg;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MsgService {
    Msg getMsg(long id)throws Exception;

    List<Msg> getMsg()throws Exception;

    List<Msg> select(String name, int offset, int rows)throws Exception;

    Long countMsg(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertMsg(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateMsg(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteMsg(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMsg(String ids) throws Exception;

    int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteMsgByIds(String ids) throws Exception;

    List<Msg> getMsgByStatus(String status)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void batchUpdateStatus(String ids, String status) throws Exception;
}

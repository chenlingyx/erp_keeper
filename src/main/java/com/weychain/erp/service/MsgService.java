package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Msg;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

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
=======
import java.util.Map;

public interface MsgService {
    abstract Msg getMsg(long id)throws Exception;

    abstract List<Msg> getMsg()throws Exception;

    abstract List<Msg> select(String name, int offset, int rows)throws Exception;

    abstract Long countMsg(String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertMsg(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateMsg(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteMsg(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMsg(String ids) throws Exception;

    abstract int checkIsNameExist(Long id, String name)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteMsgByIds(String ids) throws Exception;

    abstract List<Msg> getMsgByStatus(String status)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void batchUpdateStatus(String ids, String status) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getMsgList(Map<String, String> map) throws Exception;

    Long counts(Map<String, String> map) throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

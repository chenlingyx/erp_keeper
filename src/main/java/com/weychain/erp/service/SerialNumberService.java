package com.weychain.erp.service;

import com.weychain.erp.domain.DO.DepotItem;
import com.weychain.erp.domain.DO.SerialNumber;
import com.weychain.erp.domain.DO.SerialNumberEx;
import com.weychain.erp.domain.DO.User;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface SerialNumberService {
    SerialNumber getSerialNumber(long id)throws Exception;

    List<SerialNumber> getSerialNumber()throws Exception;

    List<SerialNumberEx> select(String serialNumber, String materialName, Integer offset, Integer rows)throws Exception;

    Long countSerialNumber(String serialNumber, String materialName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertSerialNumber(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updateSerialNumber(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deleteSerialNumber(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteSerialNumber(String ids)throws Exception;

    int checkIsNameExist(Long id, String serialNumber)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchSetEnable(Boolean enabled, String materialIDs)throws Exception;

    List<SerialNumberEx> findById(Long id)throws Exception;

    void checkIsExist(Long id, String materialName, String serialNumber) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    SerialNumberEx addSerialNumber(SerialNumberEx serialNumberEx) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    SerialNumberEx updateSerialNumber(SerialNumberEx serialNumberEx)throws Exception;

    Long checkMaterialName(String materialName)throws Exception;

    Long getSerialNumberMaterialIdByMaterialName(String materialName)throws Exception;

    void checkAndUpdateSerialNumber(DepotItem depotItem, User userInfo) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int sellSerialNumber(Long materialId, Long depotheadId, int count, User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int cancelSerialNumber(Long materialId, Long depotheadId, int count, User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    void batAddSerialNumber(String materialName, String serialNumberPrefix, Integer batAddTotal, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeleteSerialNumberByIds(String ids) throws Exception;
=======
import java.util.Map;

public interface SerialNumberService {
    abstract SerialNumber getSerialNumber(long id)throws Exception;

    abstract List<SerialNumber> getSerialNumber()throws Exception;

    abstract List<SerialNumberEx> select(String serialNumber, String materialName, Integer offset, Integer rows)throws Exception;

    abstract Long countSerialNumber(String serialNumber, String materialName)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertSerialNumber(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updateSerialNumber(String beanJson, Long id) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deleteSerialNumber(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSerialNumber(String ids)throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getSerialNumberList(Map<String, String> map) throws Exception;

    Long counts(Map<String, String> map)throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;

    abstract int checkIsNameExist(Long id, String serialNumber)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchSetEnable(Boolean enabled, String materialIDs)throws Exception;

    abstract List<SerialNumberEx> findById(Long id)throws Exception;

    abstract void checkIsExist(Long id, String materialName, String serialNumber) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract SerialNumberEx addSerialNumber(SerialNumberEx serialNumberEx) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract SerialNumberEx updateSerialNumber(SerialNumberEx serialNumberEx)throws Exception;

    abstract Long checkMaterialName(String materialName)throws Exception;

    abstract Long getSerialNumberMaterialIdByMaterialName(String materialName)throws Exception;

    abstract void checkAndUpdateSerialNumber(DepotItem depotItem, User userInfo) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int sellSerialNumber(Long materialId, Long depotheadId, int count, User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int cancelSerialNumber(Long materialId, Long depotheadId, int count, User user) throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract void batAddSerialNumber(String materialName, String serialNumberPrefix, Integer batAddTotal, String remark)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeleteSerialNumberByIds(String ids) throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

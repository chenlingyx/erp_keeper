package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Person;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
<<<<<<< HEAD

public interface PersonService {
    Person getPerson(long id)throws Exception;

    List<Person> getPerson()throws Exception;

    List<Person> select(String name, String type, int offset, int rows)throws Exception;

    Long countPerson(String name, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int insertPerson(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int updatePerson(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int deletePerson(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeletePerson(String ids) throws Exception;

    int checkIsNameExist(Long id, String name) throws Exception;

    String getPersonByIds(String personIDs)throws Exception;

    List<Person> getPersonByType(String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeletePersonByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    int batchDeletePersonByIdsNormal(String ids) throws Exception;
=======
import java.util.Map;

public interface PersonService {
    abstract Person getPerson(long id)throws Exception;

    abstract List<Person> getPerson()throws Exception;

    abstract List<Person> select(String name, String type, int offset, int rows)throws Exception;

    abstract Long countPerson(String name, String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int insertPerson(String beanJson, HttpServletRequest request)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int updatePerson(String beanJson, Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int deletePerson(Long id)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeletePerson(String ids) throws Exception;

    abstract int checkIsNameExist(Long id, String name) throws Exception;

    abstract String getPersonByIds(String personIDs)throws Exception;

    abstract List<Person> getPersonByType(String type)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeletePersonByIds(String ids)throws Exception;

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    abstract int batchDeletePersonByIdsNormal(String ids) throws Exception;

    Object selectOne(Long id) throws Exception;

    List<?> select(Map<String, String> map)throws Exception;

    List<?> getPersonList(Map<String, String> map) throws Exception;

    Long counts(Map<String, String> map) throws Exception;

    int insert(String beanJson, HttpServletRequest request)throws Exception;

    int update(String beanJson, Long id)throws Exception;

    int delete(Long id)throws Exception;

    int batchDelete(String ids)throws Exception;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

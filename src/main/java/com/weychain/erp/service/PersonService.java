package com.weychain.erp.service;

import com.weychain.erp.domain.DO.Person;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}

package com.weychain.erp.service.Impl;

import com.weychain.erp.service.CommonQueryManagerService;
import com.weychain.erp.service.InterfaceContainer;
import com.weychain.erp.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.utils.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jishenghua 752718920 2018-10-7 15:25:58
 */
@Service
public class CommonQueryManagerImpl implements CommonQueryManagerService {

    @Resource
    private InterfaceContainer container;

    @Resource
    private LogService logService;

    /**
     * 查询单条
     *
     * @param apiName 接口名称
     * @param id      ID
     */
    @Override
    public Object selectOne(String apiName, Long id) throws Exception {
        if (StringUtil.isNotEmpty(apiName) && id!=null) {
            return container.getCommonQuery(apiName).selectOne(id);
        }
        return null;
    }

    /**
     * 查询
     * @param apiName
     * @param parameterMap
     * @return
     */
    @Override
    public List<?> select(String apiName, Map<String, String> parameterMap)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).select(parameterMap);
        }
        return new ArrayList<Object>();
    }

    /**
     * 计数
     * @param apiName
     * @param parameterMap
     * @return
     */
    @Override
    public Long counts(String apiName, Map<String, String> parameterMap)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).counts(parameterMap);
        }
        return BusinessConstants.DEFAULT_LIST_NULL_NUMBER;
    }

    /**
     * 插入
     * @param apiName
     * @param beanJson
     * @return
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(String apiName, String beanJson, HttpServletRequest request) throws Exception{
        if (StringUtil.isNotEmpty(apiName)) {
            logService.insertLog(apiName, BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
            return container.getCommonQuery(apiName).insert(beanJson, request);
        }
        return 0;
    }

    /**
     * 更新
     * @param apiName
     * @param beanJson
     * @param id
     * @return
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(String apiName, String beanJson, Long id, HttpServletRequest request)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            logService.insertLog(apiName,
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(id).toString(), request);
            return container.getCommonQuery(apiName).update(beanJson, id);
        }
        return 0;
    }

    /**
     * 删除
     * @param apiName
     * @param id
     * @return
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int delete(String apiName, Long id, HttpServletRequest request)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            logService.insertLog(apiName,
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(id).toString(), request);
            return container.getCommonQuery(apiName).delete(id);
        }
        return 0;
    }

    /**
     * 批量删除
     * @param apiName
     * @param ids
     * @return
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDelete(String apiName, String ids, HttpServletRequest request)throws Exception {
        if (StringUtil.isNotEmpty(apiName)) {
            logService.insertLog(apiName, "批量删除,id集:" + ids, request);
            return container.getCommonQuery(apiName).batchDelete(ids);
        }
        return 0;
    }

    /**
     * 判断是否存在
     * @param apiName
     * @param id
     * @param name
     * @return
     */
    @Override
    public int checkIsNameExist(String apiName, Long id, String name) throws Exception{
        if (StringUtil.isNotEmpty(apiName)) {
            return container.getCommonQuery(apiName).checkIsNameExist(id, name);
        }
        return 0;
    }






}
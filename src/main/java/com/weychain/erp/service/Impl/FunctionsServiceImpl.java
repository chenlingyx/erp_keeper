package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.domain.DO.Functions;
import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.example.FunctionsExample;
import com.weychain.erp.mapper.FunctionsMapper;
import com.weychain.erp.mapper.FunctionsMapperEx;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.service.LogService;
import com.weychain.erp.service.UserService;
import com.weychain.erp.utils.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class FunctionsServiceImpl implements com.weychain.erp.service.FunctionsService {
    private Logger logger = LoggerFactory.getLogger(FunctionsServiceImpl.class);

    @Resource
    private FunctionsMapper functionsMapper;

    @Resource
    private FunctionsMapperEx functionsMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @Override
    public Functions getFunctions(long id)throws Exception {
        Functions result=null;
        try{
            result=functionsMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Functions> getFunctions()throws Exception {
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Functions> list=null;
        try{
            list=functionsMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Functions> select(String name, String type, int offset, int rows)throws Exception {
        List<Functions> list=null;
        try{
            list=functionsMapperEx.selectByConditionFunctions(name, type, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countFunctions(String name, String type)throws Exception {
        Long result=null;
        try{
            result=functionsMapperEx.countsByFunctions(name, type);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertFunctions(String beanJson, HttpServletRequest request)throws Exception {
        Functions depot = JSONObject.parseObject(beanJson, Functions.class);
        int result=0;
        try{
            result=functionsMapper.insertSelective(depot);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateFunctions(String beanJson, Long id) throws Exception{
        Functions depot = JSONObject.parseObject(beanJson, Functions.class);
        depot.setId(id);
        int result=0;
        try{
            result=functionsMapper.updateByPrimaryKeySelective(depot);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteFunctions(Long id)throws Exception {
        int result=0;
        try{
            result=functionsMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteFunctions(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=functionsMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Functions> list=null;
        try{
            list = functionsMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    public List<Functions> getRoleFunctions(String pNumber)throws Exception {
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andEnabledEqualTo(true).andPnumberEqualTo(pNumber)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<Functions> list=null;
        try{
            list = functionsMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Functions> findRoleFunctions(String pnumber)throws Exception{
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andEnabledEqualTo(true).andPnumberEqualTo(pnumber)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<Functions> list=null;
        try{
            list =functionsMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Functions> findByIds(String functionsIds)throws Exception{
        List<Long> idList = StringUtil.strToLongList(functionsIds);
        FunctionsExample example = new FunctionsExample();
        example.createCriteria().andEnabledEqualTo(true).andIdIn(idList)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort asc");
        List<Functions> list=null;
        try{
            list =functionsMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteFunctionsByIds(String ids)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_FUNCTIONS,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result =functionsMapperEx.batchDeleteFunctionsByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
}

package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.domain.DO.Log;
import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.example.LogExample;
import com.weychain.erp.mapper.LogMapper;
import com.weychain.erp.mapper.LogMapperEx;
import com.weychain.erp.domain.VO.LogVo4List;
import com.weychain.erp.exception.JshException;
<<<<<<< HEAD
=======
import com.weychain.erp.utils.Constants;
import com.weychain.erp.utils.QueryUtils;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import com.weychain.erp.utils.StringUtil;
import com.weychain.erp.utils.Tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.weychain.erp.utils.Tools.getLocalIp;

import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

@Service
public class LogServiceImpl implements com.weychain.erp.service.LogService {
    private Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
    @Resource
    private LogMapper logMapper;

    @Resource
    private LogMapperEx logMapperEx;

    @Override
    public Log getLog(long id)throws Exception {
        Log result=null;
        try{
            result=logMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Log> getLog()throws Exception {
        LogExample example = new LogExample();
        List<Log> list=null;
        try{
            list=logMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<LogVo4List> select(String operation, Integer usernameID, String clientIp, Integer status, String beginTime, String endTime,
                                   String contentdetails, int offset, int rows)throws Exception {
        List<LogVo4List> list=null;
        try{
            list=logMapperEx.selectByConditionLog(operation, usernameID, clientIp, status, beginTime, endTime,
                    contentdetails, offset, rows);
            if (null != list) {
                for (LogVo4List log : list) {
                    log.setCreateTimeStr(Tools.getCenternTime(log.getCreatetime()));
                }
            }
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countLog(String operation, Integer usernameID, String clientIp, Integer status, String beginTime, String endTime,
                         String contentdetails)throws Exception {
        Long result=null;
        try{
            result=logMapperEx.countsByLog(operation, usernameID, clientIp, status, beginTime, endTime, contentdetails);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertLog(String beanJson, HttpServletRequest request) throws Exception{
        Log log = JSONObject.parseObject(beanJson, Log.class);
        int result=0;
        try{
            result=logMapper.insertSelective(log);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateLog(String beanJson, Long id)throws Exception {
        Log log = JSONObject.parseObject(beanJson, Log.class);
        log.setId(id);
        int result=0;
        try{
            result=logMapper.updateByPrimaryKeySelective(log);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteLog(Long id)throws Exception {
        int result=0;
        try{
            result=logMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteLog(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        LogExample example = new LogExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=logMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    /**
     * 获取用户id
     * @param request
     * @return
     */
    @Override
    public Long getUserId(HttpServletRequest request) throws Exception{
        Object userInfo = request.getSession().getAttribute("user");
        if(userInfo!=null) {
            User user = (User) userInfo;
            return user.getId();
        } else {
            return null;
        }
    }

    @Override
    public String getModule(String apiName)throws Exception{
        String moduleName = null;
        switch (apiName) {
            case BusinessConstants.LOG_INTERFACE_NAME_USER:
                moduleName = BusinessConstants.LOG_MODULE_NAME_USER; break;
            case BusinessConstants.LOG_INTERFACE_NAME_ROLE:
                moduleName = BusinessConstants.LOG_MODULE_NAME_ROLE; break;
            case BusinessConstants.LOG_INTERFACE_NAME_APP:
                moduleName =BusinessConstants.LOG_MODULE_NAME_APP; break;
            case BusinessConstants.LOG_INTERFACE_NAME_DEPOT:
                moduleName = BusinessConstants.LOG_MODULE_NAME_DEPOT; break;
            case BusinessConstants.LOG_INTERFACE_NAME_FUNCTIONS:
                moduleName = BusinessConstants.LOG_MODULE_NAME_FUNCTIONS; break;
            case BusinessConstants.LOG_INTERFACE_NAME_IN_OUT_ITEM:
                moduleName = BusinessConstants.LOG_MODULE_NAME_IN_OUT_ITEM; break;
            case BusinessConstants.LOG_INTERFACE_NAME_UNIT:
                moduleName = BusinessConstants.LOG_MODULE_NAME_UNIT; break;
            case BusinessConstants.LOG_INTERFACE_NAME_PERSON:
                moduleName = BusinessConstants.LOG_MODULE_NAME_PERSON; break;
            case BusinessConstants.LOG_INTERFACE_NAME_USER_BUSINESS:
                moduleName = BusinessConstants.LOG_MODULE_NAME_USER_BUSINESS; break;
            case BusinessConstants.LOG_INTERFACE_NAME_SYSTEM_CONFIG:
                moduleName = BusinessConstants.LOG_MODULE_NAME_SYSTEM_CONFIG; break;
            case BusinessConstants.LOG_INTERFACE_NAME_MATERIAL_PROPERTY:
                moduleName = BusinessConstants.LOG_MODULE_NAME_MATERIAL_PROPERTY; break;
            case BusinessConstants.LOG_INTERFACE_NAME_ACCOUNT:
                moduleName = BusinessConstants.LOG_MODULE_NAME_ACCOUNT; break;
            case BusinessConstants.LOG_INTERFACE_NAME_SUPPLIER:
                moduleName = BusinessConstants.LOG_MODULE_NAME_SUPPLIER; break;
            case BusinessConstants.LOG_INTERFACE_NAME_MATERIAL_CATEGORY:
                moduleName = BusinessConstants.LOG_MODULE_NAME_MATERIAL_CATEGORY; break;
            case BusinessConstants.LOG_INTERFACE_NAME_MATERIAL:
                moduleName = BusinessConstants.LOG_MODULE_NAME_MATERIAL; break;
            case BusinessConstants.LOG_INTERFACE_NAME_DEPOT_HEAD:
                moduleName = BusinessConstants.LOG_MODULE_NAME_DEPOT_HEAD; break;
            case BusinessConstants.LOG_INTERFACE_NAME_DEPOT_ITEM:
                moduleName = BusinessConstants.LOG_MODULE_NAME_DEPOT_ITEM; break;
            case BusinessConstants.LOG_INTERFACE_NAME_ACCOUNT_HEAD:
                moduleName = BusinessConstants.LOG_MODULE_NAME_ACCOUNT_HEAD; break;
            case BusinessConstants.LOG_INTERFACE_NAME_ACCOUNT_ITEM:
                moduleName = BusinessConstants.LOG_MODULE_NAME_ACCOUNT_ITEM; break;
            case BusinessConstants.LOG_INTERFACE_NAME_SERIAL_NUMBER:
                moduleName = BusinessConstants.LOG_MODULE_NAME_SERIAL_NUMBER; break;
            case BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION:
                moduleName = BusinessConstants.LOG_MODULE_NAME_ORGANIZATION; break;
        }
        return moduleName;
    }

    @Override
    public void insertLog(String apiName, String type, HttpServletRequest request)throws Exception{
        Log log = new Log();
        log.setUserid(getUserId(request));
        log.setOperation(getModule(apiName));
        log.setClientip(getLocalIp(request));
        log.setCreatetime(new Date());
        Byte status = 0;
        log.setStatus(status);
        log.setContentdetails(type + getModule(apiName));
        log.setRemark(type + getModule(apiName));
        try{
            logMapper.insertSelective(log);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }

    }

<<<<<<< HEAD
=======
    @Override
    public Object selectOne(Long id) throws Exception {
        return getLog(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getUserList(map);
    }

    @Override
    public List<?> getUserList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String operation = StringUtil.getInfo(search, "operation");
        Integer usernameID = StringUtil.parseInteger(StringUtil.getInfo(search, "usernameID"));
        String clientIp = StringUtil.getInfo(search, "clientIp");
        Integer status = StringUtil.parseInteger(StringUtil.getInfo(search, "status"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String contentdetails = StringUtil.getInfo(search, "contentdetails");
        String order = QueryUtils.order(map);
        return select(operation, usernameID, clientIp, status, beginTime, endTime, contentdetails,
                QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String operation = StringUtil.getInfo(search, "operation");
        Integer usernameID = StringUtil.parseInteger(StringUtil.getInfo(search, "usernameID"));
        String clientIp = StringUtil.getInfo(search, "clientIp");
        Integer status = StringUtil.parseInteger(StringUtil.getInfo(search, "status"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String contentdetails = StringUtil.getInfo(search, "contentdetails");
        return countLog(operation, usernameID, clientIp, status, beginTime, endTime, contentdetails);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return insertLog(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateLog(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteLog(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteLog(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }

>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

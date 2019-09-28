package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.domain.DO.App;
import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.DO.UserBusiness;
import com.weychain.erp.domain.example.AppExample;
import com.weychain.erp.mapper.AppMapper;
import com.weychain.erp.mapper.AppMapperEx;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.service.LogService;
import com.weychain.erp.service.UserBusinessService;
import com.weychain.erp.service.UserService;
import com.weychain.erp.utils.Constants;
import com.weychain.erp.utils.QueryUtils;
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
import java.util.Map;

@Service
public class AppServiceImpl implements com.weychain.erp.service.AppService {
    private Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

    @Resource
    private AppMapper appMapper;
    @Resource
    private AppMapperEx appMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @Resource
    private UserBusinessService userBusinessService;

    @Override
    public List<App> findDock()throws Exception{
        AppExample example = new AppExample();
        example.createCriteria().andZlEqualTo("dock").andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<App> list=null;
        try{
            list=appMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    /**
     * create by: cjl
     * description:
     *  桌面功能菜单初始化列表
     * create time: 2019/1/11 16:59
     * @Param: null
     * @return
     */
    @Override
    public List<App> findDesk()throws Exception{
        AppExample example = new AppExample();
        example.createCriteria().andZlEqualTo("desk").andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<App> list=null;
        try{
            list=appMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public App getApp(long id)throws Exception {
        App result=null;
        try{
            result=appMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<App> getApp()throws Exception {
        AppExample example = new AppExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<App> list=null;
        try{
            list=appMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<App> select(String name, String type, int offset, int rows)throws Exception {
        List<App> list=null;
        try{
            list=appMapperEx.selectByConditionApp(name, type, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countApp(String name, String type)throws Exception {
        Long result=null;
        try{
            result=appMapperEx.countsByApp(name, type);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertApp(String beanJson, HttpServletRequest request)throws Exception {
        App app = JSONObject.parseObject(beanJson, App.class);
        int result=0;
        try{
            result=appMapper.insertSelective(app);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateApp(String beanJson, Long id) throws Exception{
        App app = JSONObject.parseObject(beanJson, App.class);
        app.setId(id);
        int result=0;
        try{
            result=appMapper.updateByPrimaryKeySelective(app);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteApp(Long id)throws Exception {
        int result=0;
        try{
            result=appMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteApp(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        AppExample example = new AppExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=appMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public List<App> findRoleAPP()throws Exception{
        AppExample example = new AppExample();
        example.createCriteria().andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<App> list=null;
        try{
            list=appMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<App> findAppInIds(String ids, String type)throws Exception{
        List<Long> idList = StringUtil.strToLongList(ids);
        AppExample example = new AppExample();
        example.createCriteria().andZlEqualTo(type).andEnabledEqualTo(true).andIdIn(idList)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<App> list=null;
        try{
            list=appMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAppByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_APP,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int  result=0;
        try{
            result=appMapperEx.batchDeleteAppByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public List<App> findAppByUserId(String userId)throws Exception {
        List<UserBusiness> roleList = userBusinessService.findRoleByUserId(userId);
        String roles = null;
        if(roleList!=null && roleList.size()>0 && roleList.get(0)!=null){
            roles = roleList.get(0).getValue();
        }
        if(roles!=null) {
            roles = roles.replaceAll("\\]\\[",",").replaceAll("\\]","").replaceAll("\\[",""); //转为逗号隔开的
        }
        List<UserBusiness> appList = userBusinessService.findAppByRoles(roles);
        String apps = null;
        if(appList!=null && appList.size()>0 && appList.get(0)!=null){
            apps = appList.get(0).getValue();
        }
        if(apps!=null) {
            apps = apps.replaceAll("\\]\\[",",").replaceAll("\\]","").replaceAll("\\[",""); //转为逗号隔开的
        }

        List<App> deskList = findAppInIds(apps,"desk");

        return deskList;
    }

    /**
     * 通过number列表查询app list
     * @param numberList
     * @return
     */
    @Override
    public List<App> findAppByNumber(List<String> numberList) throws Exception{

        AppExample example = new AppExample();
        example.createCriteria().andEnabledEqualTo(true).andNumberIn(numberList);
        List<App> list=null;
        try{
            list=appMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }


    @Override
    public Object selectOne(Long id) throws Exception {
        return getApp(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getAppList(map);
    }

    @Override
    public List<?> getAppList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String type = StringUtil.getInfo(search, "type");
        String order = QueryUtils.order(map);
        return select(name, type, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String type = StringUtil.getInfo(search, "type");
        return countApp(name, type);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return insertApp(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateApp(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteApp(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteApp(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }

}

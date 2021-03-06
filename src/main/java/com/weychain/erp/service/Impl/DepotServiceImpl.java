package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.example.DepotExample;
import com.weychain.erp.mapper.*;
import com.weychain.erp.domain.DO.*;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.service.LogService;
import com.weychain.erp.service.UserService;
<<<<<<< HEAD
=======
import com.weychain.erp.utils.Constants;
import com.weychain.erp.utils.QueryUtils;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
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
public class DepotServiceImpl implements com.weychain.erp.service.DepotService {
    private Logger logger = LoggerFactory.getLogger(DepotServiceImpl.class);

    @Resource
    private DepotMapper depotMapper;

    @Resource
    private DepotMapperEx depotMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    @Resource
    private DepotHeadMapperEx depotHeadMapperEx;
    @Resource
    private DepotItemMapperEx depotItemMapperEx;

    @Override
    public Depot getDepot(long id)throws Exception {
        Depot result=null;
        try{
            result=depotMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Depot> getDepot()throws Exception {
        DepotExample example = new DepotExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Depot> list=null;
        try{
            list=depotMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Depot> getAllList()throws Exception {
        DepotExample example = new DepotExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("sort");
        List<Depot> list=null;
        try{
            list=depotMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Depot> select(String name, Integer type, String remark, int offset, int rows)throws Exception {
        List<Depot> list=null;
        try{
            list=depotMapperEx.selectByConditionDepot(name, type, remark, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countDepot(String name, Integer type, String remark)throws Exception {
        Long result=null;
        try{
            result=depotMapperEx.countsByDepot(name, type, remark);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertDepot(String beanJson, HttpServletRequest request)throws Exception {
        Depot depot = JSONObject.parseObject(beanJson, Depot.class);
        int result=0;
        try{
            result=depotMapper.insertSelective(depot);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDepot(String beanJson, Long id) throws Exception{
        Depot depot = JSONObject.parseObject(beanJson, Depot.class);
        depot.setId(id);
        int result=0;
        try{
            result= depotMapper.updateByPrimaryKeySelective(depot);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteDepot(Long id)throws Exception {
        int result=0;
        try{
            result= depotMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDepot(String ids) throws Exception{
        List<Long> idList = StringUtil.strToLongList(ids);
        DepotExample example = new DepotExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result= depotMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        DepotExample example = new DepotExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Depot> list=null;
        try{
            list= depotMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    public List<Depot> findUserDepot()throws Exception{
        DepotExample example = new DepotExample();
        example.createCriteria().andTypeEqualTo(0).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Sort");
        List<Depot> list=null;
        try{
            list= depotMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Depot> findGiftByType(Integer type)throws Exception{
        DepotExample example = new DepotExample();
        example.createCriteria().andTypeEqualTo(type);
        example.setOrderByClause("Sort");
        List<Depot> list=null;
        try{
            list=  depotMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

<<<<<<< HEAD
    @Override
    public List<DepotEx> getDepotList(Map<String, Object> parameterMap)throws Exception {
        List<DepotEx> list=null;
        try{
            list=  depotMapperEx.getDepotList(parameterMap);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
=======


>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDepotByIds(String ids)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_DEPOT,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result=  depotMapperEx.batchDeleteDepotByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  正常删除，要考虑数据完整性，进行完整性校验
     * create time: 2019/4/10 16:52
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDepotByIdsNormal(String ids) throws Exception {
        /**
         * 校验
         * 1、单据主表	jsh_depothead
         * 2、单据子表	jsh_depotitem
         * 是否有相关数据
         * */
        int deleteTotal=0;
        if(StringUtils.isEmpty(ids)){
            return deleteTotal;
        }
        String [] idArray=ids.split(",");

        /**
         * 校验单据主表	jsh_depothead
         * */
        List<DepotHead> depotHeadList=null;
        try{
            depotHeadList=  depotHeadMapperEx.getDepotHeadListByDepotIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(depotHeadList!=null&&depotHeadList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,DepotIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验单据子表	jsh_depotitem
         * */
        List<DepotItem> depotItemList=null;
        try{
            depotItemList=  depotItemMapperEx.getDepotItemListListByDepotIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(depotItemList!=null&&depotItemList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,DepotIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal= batchDeleteDepotByIds(ids);
        return deleteTotal;

    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDepotIsDefault(Boolean isDefault, Long depotID) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_DEPOT,BusinessConstants.LOG_OPERATION_TYPE_EDIT+depotID,
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        Depot depot = new Depot();
        depot.setIsDefault(isDefault);
        DepotExample example = new DepotExample();
        example.createCriteria().andIdEqualTo(depotID);
        int result=0;
        try{
            result = depotMapper.updateByExampleSelective(depot, example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
<<<<<<< HEAD
=======

    @Override
    public Object selectOne(Long id) throws Exception {
        return getDepot(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getDepotList(map);
    }

    @Override
    public List<?> getDepotList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Integer type = StringUtil.parseInteger(StringUtil.getInfo(search, "type"));
        String remark = StringUtil.getInfo(search, "remark");
        String order = QueryUtils.order(map);
        return select(name, type, remark, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Integer type = StringUtil.parseInteger(StringUtil.getInfo(search, "type"));
        String remark = StringUtil.getInfo(search, "remark");
        return countDepot(name, type, remark);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception{
        return insertDepot(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateDepot(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteDepot(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteDepot(ids);
    }
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

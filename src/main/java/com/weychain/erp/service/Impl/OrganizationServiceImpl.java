package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.DO.Organization;
import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.example.OrganizationExample;
import com.weychain.erp.mapper.OrganizationMapper;
import com.weychain.erp.mapper.OrganizationMapperEx;
import com.weychain.erp.domain.VO.TreeNode;
import com.weychain.erp.exception.BusinessRunTimeException;
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
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:10
 */
@Service
public class OrganizationServiceImpl implements com.weychain.erp.service.OrganizationService {
    private Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Resource
    private OrganizationMapper organizationMapper;
    @Resource
    private OrganizationMapperEx organizationMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @Override
    public Organization getOrganization(long id) throws Exception {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertOrganization(String beanJson, HttpServletRequest request)throws Exception {
        Organization organization = JSONObject.parseObject(beanJson, Organization.class);
        int result=0;
        try{
            result=organizationMapper.insertSelective(organization);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateOrganization(String beanJson, Long id)throws Exception {
        Organization organization = JSONObject.parseObject(beanJson, Organization.class);
        organization.setId(id);
        int result=0;
        try{
            result=organizationMapper.updateByPrimaryKeySelective(organization);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteOrganization(Long id)throws Exception {
        int result=0;
        try{
            result=organizationMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteOrganization(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=organizationMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addOrganization(Organization org) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION,
                BusinessConstants.LOG_OPERATION_TYPE_ADD,
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        //新增时间
        Date date=new Date();
        User userInfo= userService.getCurrentUser();
        org.setCreateTime(date);
        //新增人
        org.setCreator(userInfo==null?null:userInfo.getId());
        //修改时间
        org.setUpdateTime(date);
        //修改人
        org.setUpdater(userInfo==null?null:userInfo.getId());
        /**
         *添加的时候检测机构编号是否已存在
         * */
        if(StringUtil.isNotEmpty(org.getOrgNo())){
            checkOrgNoIsExists(org.getOrgNo(),null);
        }
        /**
         * 未指定父级机构的时候默认为根机构
         * */
        if(StringUtil.isEmpty(org.getOrgParentNo())){
            org.setOrgParentNo(BusinessConstants.ORGANIZATION_ROOT_PARENT_NO);
        }
        int result=0;
        try{
            result=organizationMapperEx.addOrganization(org);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int editOrganization(Organization org)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION,
               new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(org.getId()).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        //修改时间
        org.setUpdateTime(new Date());
        User userInfo= userService.getCurrentUser();
        //修改人
        org.setUpdater(userInfo==null?null:userInfo.getId());
        /**
         * 修改的时候检测机构编号是否已存在
         * */
        if(StringUtil.isNotEmpty(org.getOrgNo())){
            checkOrgNoIsExists(org.getOrgNo(),org.getId());
        }
        /**
         * 未指定父级机构的时候默认为根机构
         * */
        if(StringUtil.isEmpty(org.getOrgParentNo())){
            org.setOrgParentNo(BusinessConstants.ORGANIZATION_ROOT_PARENT_NO);
        }
        int result=0;
        try{
            result=organizationMapperEx.editOrganization(org);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public List<TreeNode> getOrganizationTree(Long id)throws Exception {
        List<TreeNode> list=null;
        try{
            list=organizationMapperEx.getNodeTree(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Organization> findById(Long id) throws Exception{
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andIdEqualTo(id);
        List<Organization> list=null;
        try{
            list=organizationMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Organization> findByOrgNo(String orgNo)throws Exception {
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andOrgNoEqualTo(orgNo).andOrgStcdNotEqualTo(BusinessConstants.ORGANIZATION_STCD_REMOVED);
        List<Organization> list=null;
        try{
            list=organizationMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    /**
     * create by: cjl
     * description:
     *  检查机构编号是否已经存在
     * create time: 2019/3/7 10:01
     * @Param: orgNo
     * @return void
     */
    @Override
    public void checkOrgNoIsExists(String orgNo, Long id)throws Exception {
        List<Organization> orgList=findByOrgNo(orgNo);
        if(orgList!=null&&orgList.size()>0){
            if(orgList.size()>1){
                logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}]",
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,orgNo);
                //获取的数据条数大于1，机构编号已存在
                throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
            }
            if(id!=null){
                if(!orgList.get(0).getId().equals(id)){
                    //数据条数等于1，但是和编辑的数据的id不相同
                    logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}],id[{}]",
                            ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,orgNo,id);
                    throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                            ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
                }
            }else{
                logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}]",
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,orgNo);
                //数据条数等于1，但此时是新增
                throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
            }
        }

    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteOrganizationByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result=organizationMapperEx.batchDeleteOrganizationByIds(
                    new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
<<<<<<< HEAD
=======

    @Override
    public Object selectOne(Long id) throws Exception {
        return getOrganization(id);
    }

    @Override
    public List<?> select(Map<String, String> parameterMap)throws Exception {
        return getOrganizationList(parameterMap);
    }
    @Override
    public List<?> getOrganizationList(Map<String, String> map)throws Exception {
        return null;
    }
    @Override
    public Long counts(Map<String, String> parameterMap)throws Exception {
        return null;
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return insertOrganization(beanJson,request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateOrganization(beanJson,id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteOrganization(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteOrganization(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }
    
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

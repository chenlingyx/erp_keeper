package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.domain.DO.Role;
import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.example.RoleExample;
import com.weychain.erp.mapper.RoleMapper;
import com.weychain.erp.mapper.RoleMapperEx;
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
public class RoleServiceImpl implements com.weychain.erp.service.RoleService {
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleMapperEx roleMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;

    @Override
    public Role getRole(long id)throws Exception {
        Role result=null;
        try{
            result=roleMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Role> getRole()throws Exception {
        RoleExample example = new RoleExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Role> list=null;
        try{
            list=roleMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Role> select(String name, int offset, int rows)throws Exception {
        List<Role> list=null;
        try{
            list=roleMapperEx.selectByConditionRole(name, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countRole(String name)throws Exception {
        Long result=null;
        try{
            result=roleMapperEx.countsByRole(name);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertRole(String beanJson, HttpServletRequest request)throws Exception {
        Role role = JSONObject.parseObject(beanJson, Role.class);
        int result=0;
        try{
            result=roleMapper.insertSelective(role);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateRole(String beanJson, Long id) throws Exception{
        Role role = JSONObject.parseObject(beanJson, Role.class);
        role.setId(id);
        int result=0;
        try{
            result=roleMapper.updateByPrimaryKeySelective(role);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteRole(Long id)throws Exception {
        int result=0;
        try{
            result=roleMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteRole(String ids) throws Exception{
        List<Long> idList = StringUtil.strToLongList(ids);
        RoleExample example = new RoleExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=roleMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Role> findUserRole()throws Exception{
        RoleExample example = new RoleExample();
        example.setOrderByClause("Id");
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Role> list=null;
        try{
            list=roleMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  逻辑删除角色信息
     * create time: 2019/3/28 15:44
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteRoleByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_SERIAL_NUMBER,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result=roleMapperEx.batchDeleteRoleByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
}

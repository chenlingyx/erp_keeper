package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.domain.example.TenantExample;
import com.weychain.erp.mapper.TenantMapper;
import com.weychain.erp.mapper.TenantMapperEx;
import com.weychain.erp.domain.DO.Tenant;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.utils.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class TenantServiceImpl implements com.weychain.erp.service.TenantService {
    private Logger logger = LoggerFactory.getLogger(TenantServiceImpl.class);
    @Resource
    private TenantMapper tenantMapper;
    @Resource
    private TenantMapperEx tenantMapperEx;

@Override
    public Tenant getTenant(long id)throws Exception {
        Tenant result=null;
        try{
            result=tenantMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Tenant> getTenant()throws Exception {
        TenantExample example = new TenantExample();
        List<Tenant> list=null;
        try{
            list=tenantMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Tenant> select(String loginName, int offset, int rows)throws Exception {
        List<Tenant> list=null;
        try{
            list=tenantMapperEx.selectByConditionTenant(loginName, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countTenant(String loginName)throws Exception {
        Long result=null;
        try{
            result=tenantMapperEx.countsByTenant(loginName);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertTenant(String beanJson, HttpServletRequest request)throws Exception {
        Tenant tenant = JSONObject.parseObject(beanJson, Tenant.class);
        int result=0;
        try{
            tenant.setUserNumLimit(2); //默认用户限制数量
            tenant.setBillsNumLimit(200); //默认单据限制数量
            tenant.setCreateTime(new Date());
            result=tenantMapper.insertSelective(tenant);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateTenant(String beanJson, Long id)throws Exception {
        Tenant tenant = JSONObject.parseObject(beanJson, Tenant.class);
        int result=0;
        try{
            tenant.setId(id);
            result=tenantMapper.updateByPrimaryKeySelective(tenant);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteTenant(Long id)throws Exception {
        int result=0;
        try{
            result= tenantMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteTenant(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        TenantExample example = new TenantExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result= tenantMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        TenantExample example = new TenantExample();
        example.createCriteria().andIdEqualTo(id);
        List<Tenant> list=null;
        try{
            list= tenantMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    public Tenant getTenantByTenantId(long tenantId) {
        Tenant tenant = new Tenant();
        TenantExample example = new TenantExample();
        example.createCriteria().andTenantIdEqualTo(tenantId);
        List<Tenant> list = tenantMapper.selectByExample(example);
        if(list.size()>0) {
            tenant = list.get(0);
        }
        return tenant;
    }
}

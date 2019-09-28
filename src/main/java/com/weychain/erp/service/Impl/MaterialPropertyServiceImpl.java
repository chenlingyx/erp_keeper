package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.domain.DO.MaterialProperty;
import com.weychain.erp.domain.DO.User;
import com.weychain.erp.domain.example.MaterialPropertyExample;
import com.weychain.erp.mapper.MaterialPropertyMapper;
import com.weychain.erp.mapper.MaterialPropertyMapperEx;
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
public class MaterialPropertyServiceImpl implements com.weychain.erp.service.MaterialPropertyService {
    private Logger logger = LoggerFactory.getLogger(MaterialPropertyServiceImpl.class);

    @Resource
    private MaterialPropertyMapper materialPropertyMapper;

    @Resource
    private MaterialPropertyMapperEx materialPropertyMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @Override
    public MaterialProperty getMaterialProperty(long id)throws Exception {
        MaterialProperty result=null;
        try{
            result=materialPropertyMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }


@Override
    public List<MaterialProperty> getMaterialProperty()throws Exception {
        MaterialPropertyExample example = new MaterialPropertyExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<MaterialProperty>  list=null;
        try{
            list=materialPropertyMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<MaterialProperty> select(String name, int offset, int rows)throws Exception {
        List<MaterialProperty>  list=null;
        try{
            list=materialPropertyMapperEx.selectByConditionMaterialProperty(name, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countMaterialProperty(String name)throws Exception {
        Long  result=null;
        try{
            result=materialPropertyMapperEx.countsByMaterialProperty(name);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMaterialProperty(String beanJson, HttpServletRequest request)throws Exception {
        MaterialProperty materialProperty = JSONObject.parseObject(beanJson, MaterialProperty.class);
        int  result=0;
        try{
            result=materialPropertyMapper.insertSelective(materialProperty);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMaterialProperty(String beanJson, Long id)throws Exception {
        MaterialProperty materialProperty = JSONObject.parseObject(beanJson, MaterialProperty.class);
        materialProperty.setId(id);
        int  result=0;
        try{
            result=materialPropertyMapper.updateByPrimaryKeySelective(materialProperty);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMaterialProperty(Long id)throws Exception {
        int  result=0;
        try{
            result=materialPropertyMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialProperty(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        MaterialPropertyExample example = new MaterialPropertyExample();
        example.createCriteria().andIdIn(idList);
        int  result=0;
        try{
            result=materialPropertyMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialPropertyByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL_PROPERTY,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int  result=0;
        try{
            result=materialPropertyMapperEx.batchDeleteMaterialPropertyByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;

    }
}

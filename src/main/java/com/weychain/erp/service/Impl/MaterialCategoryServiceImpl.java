package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.example.MaterialCategoryExample;
import com.weychain.erp.mapper.MaterialCategoryMapper;
import com.weychain.erp.mapper.MaterialCategoryMapperEx;
import com.weychain.erp.mapper.MaterialMapperEx;
import com.weychain.erp.domain.VO.TreeNode;
import com.weychain.erp.domain.DO.Material;
import com.weychain.erp.domain.DO.MaterialCategory;
import com.weychain.erp.domain.DO.User;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

@Service
public class MaterialCategoryServiceImpl implements com.weychain.erp.service.MaterialCategoryService {
    private Logger logger = LoggerFactory.getLogger(MaterialCategoryServiceImpl.class);

    @Resource
    private MaterialCategoryMapper materialCategoryMapper;
    @Resource
    private MaterialCategoryMapperEx materialCategoryMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;
    @Resource
    private MaterialMapperEx materialMapperEx;

    @Override
    public MaterialCategory getMaterialCategory(long id)throws Exception {
        MaterialCategory result=null;
        try{
            result=materialCategoryMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<MaterialCategory> getMaterialCategory()throws Exception {
        MaterialCategoryExample example = new MaterialCategoryExample();
        List<MaterialCategory> list=null;
        try{
            list=materialCategoryMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<MaterialCategory> getAllList(Long parentId)throws Exception {
        List<MaterialCategory> list=null;
        try{
            list = getMCList(parentId);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<MaterialCategory> getMCList(Long parentId)throws Exception {
        List<MaterialCategory> res= new ArrayList<MaterialCategory>();
        List<MaterialCategory> list=null;
        MaterialCategoryExample example = new MaterialCategoryExample();
        example.createCriteria().andParentidEqualTo(parentId).andIdNotEqualTo(1l);
        example.setOrderByClause("id");
        list=materialCategoryMapper.selectByExample(example);
        if(list!=null && list.size()>0) {
            res.addAll(list);
            for(MaterialCategory mc : list) {
                List<MaterialCategory> mcList = getMCList(mc.getId());
                if(mcList!=null && mcList.size()>0) {
                    res.addAll(mcList);
                }
            }
        }
        return res;
    }

    @Override
    public List<MaterialCategory> select(String name, Integer parentId, int offset, int rows) throws Exception{
        List<MaterialCategory> list=null;
        try{
            list=materialCategoryMapperEx.selectByConditionMaterialCategory(name, parentId, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public Long countMaterialCategory(String name, Integer parentId) throws Exception{
        Long result=null;
        try{
            result=materialCategoryMapperEx.countsByMaterialCategory(name, parentId);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMaterialCategory(String beanJson, HttpServletRequest request)throws Exception {
        MaterialCategory materialCategory = JSONObject.parseObject(beanJson, MaterialCategory.class);
        int result=0;
        try{
            result=materialCategoryMapper.insertSelective(materialCategory);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMaterialCategory(String beanJson, Long id) throws Exception{
        MaterialCategory materialCategory = JSONObject.parseObject(beanJson, MaterialCategory.class);
        materialCategory.setId(id);
        int result=0;
        try{
            result=materialCategoryMapper.updateByPrimaryKeySelective(materialCategory);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMaterialCategory(Long id)throws Exception {
        int result=0;
        try{
            result=materialCategoryMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialCategory(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        MaterialCategoryExample example = new MaterialCategoryExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=materialCategoryMapper.deleteByExample(example);
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
    public List<MaterialCategory> findById(Long id)throws Exception {
        MaterialCategoryExample example = new MaterialCategoryExample();
        example.createCriteria().andIdEqualTo(id);
        List<MaterialCategory> list=null;
        try{
            list=materialCategoryMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    /**
     * create by: cjl
     * description:
     *获取商品类别树数据
     * create time: 2019/2/19 14:30
     * @Param:
     * @return java.util.List<com.weychain.erp.domain.VO.TreeNode>
     */
    @Override
    public List<TreeNode> getMaterialCategoryTree(Long id) throws Exception{
        List<TreeNode> list=null;
        try{
            list=materialCategoryMapperEx.getNodeTree(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
       return list;
    }
    /**
     * create by: cjl
     * description:
     *  新增商品类别信息
     * create time: 2019/2/19 16:30
     * @Param: mc
     * @return void
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addMaterialCategory(MaterialCategory mc) throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL_CATEGORY,
                BusinessConstants.LOG_OPERATION_TYPE_ADD,
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        if(mc==null){
            return 0;
        }
        if(mc.getParentid()==null){
            //没有给定父级目录的id，默认设置父级目录为根目录的父目录
            mc.setParentid(BusinessConstants.MATERIAL_CATEGORY_ROOT_PARENT_ID);
        }
        //检查商品类型编号是否已存在
        checkMaterialCategorySerialNo(mc);
        //数据状态新增时默认设置为启用
        mc.setStatus(BusinessConstants.MATERIAL_CATEGORY_STATUS_ENABLE);
        Date date=new Date();
        User userInfo= userService.getCurrentUser();
        //创建时间
        mc.setCreateTime(date);
        //创建人
        mc.setCreator(userInfo==null?null:userInfo.getId());
        //更新时间
        mc.setUpdateTime(date);
        //更新人
        mc.setUpdater(userInfo==null?null:userInfo.getId());
        int result=0;
        try{
            result=materialCategoryMapperEx.addMaterialCategory(mc);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialCategoryByIds(String ids) throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL_CATEGORY,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        //更新时间
        Date updateDate =new Date();
        //更新人
        User userInfo= userService.getCurrentUser();
        Long updater=userInfo==null?null:userInfo.getId();
        String strArray[]=ids.split(",");
        if(strArray.length<1){
            return 0;
        }
        int result=0;
        try{
            result=materialCategoryMapperEx.batchDeleteMaterialCategoryByIds(updateDate,updater,strArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
       return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int editMaterialCategory(MaterialCategory mc) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL_CATEGORY,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(mc.getId()).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        if(mc.getParentid()==null){
            //没有给定父级目录的id，默认设置父级目录为根目录的父目录
            mc.setParentid(BusinessConstants.MATERIAL_CATEGORY_ROOT_PARENT_ID);
        }

        //检查商品类型编号是否已存在
        checkMaterialCategorySerialNo(mc);
        //更新时间
        mc.setUpdateTime(new Date());
        //更新人
        User userInfo= userService.getCurrentUser();
        mc.setUpdater(userInfo==null?null:userInfo.getId());
        int result=0;
        try{
            result= materialCategoryMapperEx.editMaterialCategory(mc);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    /**
     * 根据商品类别编号判断商品类别是否已存在
     * */
    @Override
    public void  checkMaterialCategorySerialNo(MaterialCategory mc)throws Exception {
        if(mc==null){
            return;
        }
        if(StringUtil.isEmpty(mc.getSerialNo())){
            return;
        }
        //根据商品类别编号查询商品类别
        List<MaterialCategory> mList=null;
        try{
            mList= materialCategoryMapperEx.getMaterialCategoryBySerialNo(mc.getSerialNo());
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(mList==null||mList.size()<1){
            //未查询到对应数据，编号可用
            return;
        }
        if(mList.size()>1){
            //查询到的数据条数大于1，编号已存在
            throw new BusinessRunTimeException(ExceptionConstants.MATERIAL_CATEGORY_SERIAL_ALREADY_EXISTS_CODE,
                    ExceptionConstants.MATERIAL_CATEGORY_SERIAL_ALREADY_EXISTS_MSG);
        }
        if(mc.getId()==null){
            //新增时，编号已存在
            throw new BusinessRunTimeException(ExceptionConstants.MATERIAL_CATEGORY_SERIAL_ALREADY_EXISTS_CODE,
                    ExceptionConstants.MATERIAL_CATEGORY_SERIAL_ALREADY_EXISTS_MSG);
        }
        /**
         * 包装类型用equals来比较
         * */
        if(mc.getId().equals(mList.get(0).getId())){
            //修改时，相同编号，id不同
            throw new BusinessRunTimeException(ExceptionConstants.MATERIAL_CATEGORY_SERIAL_ALREADY_EXISTS_CODE,
                    ExceptionConstants.MATERIAL_CATEGORY_SERIAL_ALREADY_EXISTS_MSG);
        }
    }

    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  正常删除，要考虑数据完整性，进行完整性校验
     * create time: 2019/4/11 9:26
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialCategoryByIdsNormal(String ids) throws Exception {
        /**
         * 校验
         * 1、产品表	jsh_material
         * 2、产品类型表	jsh_materialcategory
         * 是否有相关数据
         * */
        int deleteTotal=0;
        if(StringUtils.isEmpty(ids)){
            return deleteTotal;
        }
        String [] idArray=ids.split(",");
        /**
         * 校验产品表	jsh_material
         * */
        List<Material> materialList=null;
        try{
            materialList= materialMapperEx.getMaterialListByCategoryIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(materialList!=null&&materialList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,CategoryIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验产品类型表	jsh_materialcategory
         * */
        List<MaterialCategory> materialCategoryList=null;
        try{
            materialCategoryList= materialCategoryMapperEx.getMaterialCategoryListByCategoryIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(materialCategoryList!=null&&materialCategoryList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,CategoryIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal= batchDeleteMaterialCategoryByIds(ids);
        return deleteTotal;
    }
<<<<<<< HEAD
=======


    @Override
    public Object selectOne(Long id) throws Exception {
        return getMaterialCategory(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getMaterialCategoryList(map);
    }

    @Override
    public List<?> getMaterialCategoryList(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Integer parentId = StringUtil.parseInteger(StringUtil.getInfo(search, "parentId"));
        String order = QueryUtils.order(map);
        return select(name, parentId, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Integer parentId = StringUtil.parseInteger(StringUtil.getInfo(search, "parentId"));
        return countMaterialCategory(name, parentId);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return insertMaterialCategory(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateMaterialCategory(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteMaterialCategory(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteMaterialCategory(ids);
    }


>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

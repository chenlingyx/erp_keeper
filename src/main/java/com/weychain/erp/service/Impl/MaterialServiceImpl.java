package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.mapper.DepotItemMapperEx;
import com.weychain.erp.mapper.MaterialMapper;
import com.weychain.erp.mapper.MaterialMapperEx;
import com.weychain.erp.domain.DO.*;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.service.DepotItemService;
import com.weychain.erp.service.LogService;
import com.weychain.erp.service.UserService;
import com.weychain.erp.utils.BaseResponseInfo;
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
import java.util.*;

@Service
public class MaterialServiceImpl implements com.weychain.erp.service.MaterialService {
    private Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

    @Resource
    private MaterialMapper materialMapper;
    @Resource
    private MaterialMapperEx materialMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private DepotItemMapperEx depotItemMapperEx;
    @Resource
    private DepotItemService depotItemService;

    @Override
    public Material getMaterial(long id)throws Exception {
        Material result=null;
        try{
            result=materialMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Material> getMaterial() throws Exception{
        MaterialExample example = new MaterialExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Material> list=null;
        try{
            list=materialMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<MaterialVo4Unit> select(String name, String model, String categoryIds, String mpList, int offset, int rows)
            throws Exception{
        String[] mpArr = mpList.split(",");
        List<MaterialVo4Unit> resList = new ArrayList<MaterialVo4Unit>();
        List<MaterialVo4Unit> list =null;
        try{
            list= materialMapperEx.selectByConditionMaterial(name, model,categoryIds,mpList, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if (null != list) {
            for (MaterialVo4Unit m : list) {
                //扩展信息
                String materialOther = "";
                for (int i = 0; i < mpArr.length; i++) {
                    if (mpArr[i].equals("颜色")) {
                        materialOther = materialOther + ((m.getColor() == null || m.getColor().equals("")) ? "" : "(" + m.getColor() + ")");
                    }
                    if (mpArr[i].equals("规格")) {
                        materialOther = materialOther + ((m.getStandard() == null || m.getStandard().equals("")) ? "" : "(" + m.getStandard() + ")");
                    }
                    if (mpArr[i].equals("制造商")) {
                        materialOther = materialOther + ((m.getMfrs() == null || m.getMfrs().equals("")) ? "" : "(" + m.getMfrs() + ")");
                    }
                    if (mpArr[i].equals("自定义1")) {
                        materialOther = materialOther + ((m.getOtherfield1() == null || m.getOtherfield1().equals("")) ? "" : "(" + m.getOtherfield1() + ")");
                    }
                    if (mpArr[i].equals("自定义2")) {
                        materialOther = materialOther + ((m.getOtherfield2() == null || m.getOtherfield2().equals("")) ? "" : "(" + m.getOtherfield2() + ")");
                    }
                    if (mpArr[i].equals("自定义3")) {
                        materialOther = materialOther + ((m.getOtherfield3() == null || m.getOtherfield3().equals("")) ? "" : "(" + m.getOtherfield3() + ")");
                    }
                }
                m.setMaterialOther(materialOther);
                Long InSum = depotItemService.findByTypeAndMaterialId("入库", m.getId());
                Long OutSum = depotItemService.findByTypeAndMaterialId("出库", m.getId());
                m.setStock(InSum - OutSum);
                resList.add(m);
            }
        }
        return resList;
    }

    @Override
    public Long countMaterial(String name, String model, String categoryIds, String mpList)throws Exception {
        Long result =null;
        try{
            result= materialMapperEx.countsByMaterial(name, model,categoryIds,mpList);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMaterial(String beanJson, HttpServletRequest request)throws Exception {
        Material material = JSONObject.parseObject(beanJson, Material.class);
        material.setEnabled(true);
        int result =0;
        try{
            result= materialMapper.insertSelective(material);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMaterial(String beanJson, Long id) throws Exception{
        Material material = JSONObject.parseObject(beanJson, Material.class);
        material.setId(id);
        int res =0;
        try{
            res= materialMapper.updateByPrimaryKeySelective(material);
            Long unitId = material.getUnitid();
            if(unitId != null) {
                materialMapperEx.updatePriceNullByPrimaryKey(id); //将价格置空
            } else {
                materialMapperEx.updateUnitIdNullByPrimaryKey(id); //将多单位置空
            }
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }

        return res;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMaterial(Long id)throws Exception {
        int result =0;
        try{
            result= materialMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterial(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        MaterialExample example = new MaterialExample();
        example.createCriteria().andIdIn(idList);
        int result =0;
        try{
            result= materialMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        MaterialExample example = new MaterialExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Material> list =null;
        try{
            list=  materialMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    public int checkIsExist(Long id, String name, String model, String color, String standard, String mfrs,
                            String otherField1, String otherField2, String otherField3, String unit, Long unitId)throws Exception {
        MaterialExample example = new MaterialExample();
        MaterialExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name).andModelEqualTo(model).andColorEqualTo(color)
                .andStandardEqualTo(standard).andMfrsEqualTo(mfrs)
                .andOtherfield1EqualTo(otherField1).andOtherfield2EqualTo(otherField2).andOtherfield2EqualTo(otherField3);
        if (id > 0) {
            criteria.andIdNotEqualTo(id);
        }
        if (!StringUtil.isEmpty(unit)) {
            criteria.andUnitEqualTo(unit);
        }
        if (unitId !=null) {
            criteria.andUnitidEqualTo(unitId);
        }
        List<Material> list =null;
        try{
            list=  materialMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetEnable(Boolean enabled, String materialIDs)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(materialIDs).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> ids = StringUtil.strToLongList(materialIDs);
        Material material = new Material();
        material.setEnabled(enabled);
        MaterialExample example = new MaterialExample();
        example.createCriteria().andIdIn(ids);
        int result =0;
        try{
            result=  materialMapper.updateByExampleSelective(material, example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public String findUnitName(Long mId)throws Exception{
        String result =null;
        try{
            result=  materialMapperEx.findUnitName(mId);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<MaterialVo4Unit> findById(Long id)throws Exception{
        List<MaterialVo4Unit> list =null;
        try{
            list=  materialMapperEx.findById(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<MaterialVo4Unit> findBySelect()throws Exception{
        List<MaterialVo4Unit> list =null;
        try{
            list=  materialMapperEx.findBySelect();
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Material> findByOrder()throws Exception{
        MaterialExample example = new MaterialExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("Name,Model asc");
        List<Material> list =null;
        try{
            list=  materialMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<MaterialVo4Unit> findByAll(String name, String model, String categoryIds)throws Exception {
        List<MaterialVo4Unit> resList = new ArrayList<MaterialVo4Unit>();
        List<MaterialVo4Unit> list =null;
        try{
            list=  materialMapperEx.findByAll(name, model, categoryIds);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if (null != list) {
            for (MaterialVo4Unit m : list) {
                resList.add(m);
            }
        }
        return resList;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(List<Material> mList) throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(mList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            for(Material m: mList) {
                materialMapper.insertSelective(m);
            }
            info.code = 200;
            data.put("message", "成功");
        } catch (Exception e) {
            JshException.writeFail(logger, e);
            e.printStackTrace();
            info.code = 500;
            data.put("message", e.getMessage());
        }
        info.data = data;
        return info;
    }

    @Override
    public List<Material> getMaterialEnableSerialNumberList(Map<String, Object> parameterMap)throws Exception {
        List<Material> list =null;
        try{
            list=  materialMapperEx.getMaterialEnableSerialNumberList(parameterMap);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_MATERIAL,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result =0;
        try{
            result=  materialMapperEx.batchDeleteMaterialByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
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
     * create time: 2019/4/10 18:00
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialByIdsNormal(String ids) throws Exception{
        /**
         * 校验
         * 1、单据子表	jsh_depotitem
         * 是否有相关数据
         * */
        int deleteTotal=0;
        if(StringUtils.isEmpty(ids)){
            return deleteTotal;
        }
        String [] idArray=ids.split(",");

        /**
         * 校验单据子表	jsh_depotitem
         * */
        List<DepotItem> depotItemList =null;
        try{
            depotItemList=  depotItemMapperEx.getDepotItemListListByMaterialIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(depotItemList!=null&&depotItemList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,MaterialIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal= batchDeleteMaterialByIds(ids);
        return deleteTotal;

    }
<<<<<<< HEAD
=======

    @Override
    public Object selectOne(Long id) throws Exception {
        return getMaterial(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getMaterialList(map);
    }

    @Override
    public List<?> getMaterialList(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String model = StringUtil.getInfo(search, "model");
        String categoryIds = StringUtil.getInfo(search, "categoryIds");
        String mpList = StringUtil.getInfo(search, "mpList");
        String order = QueryUtils.order(map);
        return select(name, model,categoryIds,mpList, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String model = StringUtil.getInfo(search, "model");
        String categoryIds = StringUtil.getInfo(search, "categoryIds");
        String mpList = StringUtil.getInfo(search, "mpList");
        return countMaterial(name, model,categoryIds,mpList);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception{
        return insertMaterial(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateMaterial(beanJson, id);
    }


    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteMaterial(ids);
    }

>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.example.SupplierExample;
import com.weychain.erp.mapper.AccountHeadMapperEx;
import com.weychain.erp.mapper.DepotHeadMapperEx;
import com.weychain.erp.mapper.SupplierMapper;
import com.weychain.erp.mapper.SupplierMapperEx;
import com.weychain.erp.domain.DO.*;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.service.DepotHeadService;
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

import static com.weychain.erp.utils.Tools.getNow3;

import java.math.BigDecimal;
import java.util.*;

@Service
public class SupplierServiceImpl implements com.weychain.erp.service.SupplierService {
    private Logger logger = LoggerFactory.getLogger(SupplierServiceImpl.class);

    @Resource
    private SupplierMapper supplierMapper;

    @Resource
    private SupplierMapperEx supplierMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private AccountHeadMapperEx accountHeadMapperEx;
    @Resource
    private DepotHeadMapperEx depotHeadMapperEx;
    @Resource
    private DepotHeadService depotHeadService;
    @Resource
    private AccountHeadServiceImpl accountHeadServiceImpl;

    @Override
    public Supplier getSupplier(long id)throws Exception {
        Supplier result=null;
        try{
            result=supplierMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Supplier> getSupplier()throws Exception {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Supplier> list=null;
        try{
            list=supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Supplier> select(String supplier, String type, String phonenum,
                                 String telephone, String description, int offset, int rows) throws Exception{
        List<Supplier> resList = new ArrayList<Supplier>();
        try{
            List<Supplier> list = supplierMapperEx.selectByConditionSupplier(supplier, type, phonenum, telephone, description, offset, rows);
            for(Supplier s : list) {
                Integer supplierId = s.getId().intValue();
                String endTime = getNow3();
                String supType = null;
                if(("客户").equals(s.getType())) {
                    supType = "customer";
                } else if(("供应商").equals(s.getType())) {
                    supType = "vendor";
                }
                BigDecimal sum = BigDecimal.ZERO;
                BigDecimal beginNeedGet = s.getBeginneedget();
                if(beginNeedGet==null) {
                    beginNeedGet = BigDecimal.ZERO;
                }
                BigDecimal beginNeedPay = s.getBeginneedpay();
                if(beginNeedPay==null) {
                    beginNeedPay = BigDecimal.ZERO;
                }
                sum = sum.add(depotHeadService.findTotalPay(supplierId, endTime, supType));
                sum = sum.add(accountHeadServiceImpl.findTotalPay(supplierId, endTime, supType));
                if(("客户").equals(s.getType())) {
                    sum = sum.add(beginNeedGet).subtract(beginNeedPay);
                    s.setAllneedget(sum);
                    s.setAllneedpay(BigDecimal.ZERO);
                } else if(("供应商").equals(s.getType())) {
                    sum = sum.add(beginNeedPay).subtract(beginNeedGet);
                    s.setAllneedget(BigDecimal.ZERO);
                    s.setAllneedpay(sum);
                }
                resList.add(s);
            }
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return resList;
    }

    @Override
    public Long countSupplier(String supplier, String type, String phonenum, String telephone, String description) throws Exception{
        Long result=null;
        try{
            result=supplierMapperEx.countsBySupplier(supplier, type, phonenum, telephone, description);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertSupplier(String beanJson, HttpServletRequest request)throws Exception {
        Supplier supplier = JSONObject.parseObject(beanJson, Supplier.class);
        int result=0;
        try{
            result=supplierMapper.insertSelective(supplier);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateSupplier(String beanJson, Long id)throws Exception {
        Supplier supplier = JSONObject.parseObject(beanJson, Supplier.class);
        if(supplier.getBeginneedpay() == null) {
            supplier.setBeginneedpay(BigDecimal.ZERO);
        }
        if(supplier.getBeginneedget() == null) {
            supplier.setBeginneedget(BigDecimal.ZERO);
        }
        supplier.setId(id);
        int result=0;
        try{
            result=supplierMapper.updateByPrimaryKeySelective(supplier);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteSupplier(Long id)throws Exception {
        int result=0;
        try{
            result=supplierMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return supplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupplier(String ids) throws Exception{
        List<Long> idList = StringUtil.strToLongList(ids);
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=supplierMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIdNotEqualTo(id).andSupplierEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Supplier> list=null;
        try{
            list= supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateAdvanceIn(Long supplierId, BigDecimal advanceIn)throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_SUPPLIER,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supplierId).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        Supplier supplier=null;
        try{
            supplier = supplierMapper.selectByPrimaryKey(supplierId);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        int result=0;
        try{
            if(supplier!=null){
                supplier.setAdvancein(supplier.getAdvancein().add(advanceIn));  //增加预收款的金额，可能增加的是负值
                 result=supplierMapper.updateByPrimaryKeySelective(supplier);
            }
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Supplier> findBySelectCus()throws Exception {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andTypeLike("客户").andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Supplier> list=null;
        try{
            list = supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Supplier> findBySelectSup()throws Exception {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andTypeLike("供应商").andEnabledEqualTo(true)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Supplier> list=null;
        try{
            list = supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Supplier> findBySelectRetail()throws Exception {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andTypeLike("会员").andEnabledEqualTo(true)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Supplier> list=null;
        try{
            list = supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Supplier> findById(Long supplierId)throws Exception {
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIdEqualTo(supplierId)
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Supplier> list=null;
        try{
            list = supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetEnable(Boolean enabled, String supplierIDs)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_SUPPLIER,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(supplierIDs).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> ids = StringUtil.strToLongList(supplierIDs);
        Supplier supplier = new Supplier();
        supplier.setEnabled(enabled);
        SupplierExample example = new SupplierExample();
        example.createCriteria().andIdIn(ids);
        int result=0;
        try{
            result = supplierMapper.updateByExampleSelective(supplier, example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public List<Supplier> findUserCustomer()throws Exception{
        SupplierExample example = new SupplierExample();
        example.createCriteria().andTypeEqualTo("客户")
                .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Supplier> list=null;
        try{
            list = supplierMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<Supplier> findByAll(String supplier, String type, String phonenum,
                                    String telephone, String description) throws Exception{
        List<Supplier> list=null;
        try{
            list = supplierMapperEx.findByAll(supplier, type, phonenum, telephone, description);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public BaseResponseInfo importExcel(List<Supplier> mList) throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_SUPPLIER,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_IMPORT).append(mList.size()).append(BusinessConstants.LOG_DATA_UNIT).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        BaseResponseInfo info = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            for(Supplier s: mList) {
                supplierMapper.insertSelective(s);
            }
            info.code = 200;
            data.put("message", "成功");
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            data.put("message", e.getMessage());
        }
        info.data = data;
        return info;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupplierByIds(String ids)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_SUPPLIER,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result = supplierMapperEx.batchDeleteSupplierByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *正常删除，要考虑数据完整性，进行完整性校验
     * create time: 2019/4/10 14:48
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteSupplierByIdsNormal(String ids) throws Exception {
        /**
         * 校验
         * 1、财务主表	jsh_accounthead
         * 2、单据主表	jsh_depothead
         * 是否有相关数据
         * */
        int deleteTotal=0;
        if(StringUtils.isEmpty(ids)){
            return deleteTotal;
        }
        String [] idArray=ids.split(",");
        /**
         * 校验财务主表	jsh_accounthead
         * */
        List<AccountHead> accountHeadList=null;
        try{
            accountHeadList = accountHeadMapperEx.getAccountHeadListByOrganIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(accountHeadList!=null&&accountHeadList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,OrganIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验单据主表	jsh_depothead
         * */
        List<DepotHead> depotHeadList=null;
        try{
            depotHeadList = depotHeadMapperEx.getDepotHeadListByOrganIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(depotHeadList!=null&&depotHeadList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,OrganIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal= batchDeleteSupplierByIds(ids);
        return deleteTotal;

    }
<<<<<<< HEAD
=======


    @Override
    public Object selectOne(Long id) throws Exception {
        return getSupplier(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getSupplierList(map);
    }

    @Override
    public List<?> getSupplierList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplier = StringUtil.getInfo(search, "supplier");
        String type = StringUtil.getInfo(search, "type");
        String phonenum = StringUtil.getInfo(search, "phonenum");
        String telephone = StringUtil.getInfo(search, "telephone");
        String description = StringUtil.getInfo(search, "description");
        String order = QueryUtils.order(map);
        return select(supplier, type, phonenum, telephone, description, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String supplier = StringUtil.getInfo(search, "supplier");
        String type = StringUtil.getInfo(search, "type");
        String phonenum = StringUtil.getInfo(search, "phonenum");
        String telephone = StringUtil.getInfo(search, "telephone");
        String description = StringUtil.getInfo(search, "description");
        return countSupplier(supplier, type, phonenum, telephone, description);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return insertSupplier(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateSupplier(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteSupplier(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteSupplier(ids);
    }


>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

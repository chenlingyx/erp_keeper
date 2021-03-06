package com.weychain.erp.service.Impl;

import com.alibaba.fastjson.JSONObject;
<<<<<<< HEAD
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
=======
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.example.AccountHeadExample;
import com.weychain.erp.mapper.AccountHeadMapper;
import com.weychain.erp.mapper.AccountHeadMapperEx;
import com.weychain.erp.mapper.AccountItemMapperEx;
import com.weychain.erp.domain.DO.*;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.service.AccountHeadService;
import com.weychain.erp.service.LogService;
import com.weychain.erp.service.UserService;
<<<<<<< HEAD
import com.weychain.erp.utils.StringUtil;

=======
import com.weychain.erp.utils.Constants;
import com.weychain.erp.utils.QueryUtils;
import com.weychain.erp.utils.StringUtil;

import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD

@Service
public class AccountHeadServiceImpl  implements AccountHeadService {
=======
import java.util.Map;

@Service
public class AccountHeadServiceImpl extends ServiceImpl<AccountHeadMapper,AccountHead> implements AccountHeadService {
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    private Logger logger = LoggerFactory.getLogger(AccountHeadServiceImpl.class);

    @Resource
    private AccountHeadMapper accountHeadMapper;

    @Resource
    private AccountHeadMapperEx accountHeadMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    @Resource
    private AccountItemMapperEx accountItemMapperEx;


    @Override
    public AccountHead getAccountHead(long id) throws Exception {
        AccountHead result=null;
        try{
            result=accountHeadMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public List<AccountHead> getAccountHead() throws Exception{
<<<<<<< HEAD
        AccountHeadExample example = new AccountHeadExample();
        List<AccountHead> list=null;
        try{
            list=accountHeadMapper.selectByExample(example);
=======
//        AccountHeadExample example = new AccountHeadExample();
        List<AccountHead> list=null;
        try{
            list=accountHeadMapper.selectList(new QueryWrapper<>());
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Override
    public List<AccountHeadVo4ListEx> select(String type, String billNo, String beginTime, String endTime, int offset, int rows) throws Exception{
        List<AccountHeadVo4ListEx> resList = new ArrayList<AccountHeadVo4ListEx>();
        List<AccountHeadVo4ListEx> list=null;
        try{
            list = accountHeadMapperEx.selectByConditionAccountHead(type, billNo, beginTime, endTime, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if (null != list) {
            for (AccountHeadVo4ListEx ah : list) {
                if(ah.getChangeamount() != null) {
                    ah.setChangeamount(ah.getChangeamount().abs());
                }
                if(ah.getTotalprice() != null) {
                    ah.setTotalprice(ah.getTotalprice().abs());
                }
                resList.add(ah);
            }
        }
        return resList;
    }

    @Override
    public Long countAccountHead(String type, String billNo, String beginTime, String endTime) throws Exception{
        Long result=null;
        try{
            result = accountHeadMapperEx.countsByAccountHead(type, billNo, beginTime, endTime);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertAccountHead(String beanJson, HttpServletRequest request) throws Exception{
        AccountHead accountHead = JSONObject.parseObject(beanJson, AccountHead.class);
        int result=0;
        try{
            result = accountHeadMapper.insertSelective(accountHead);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateAccountHead(String beanJson, Long id)throws Exception {
        AccountHead accountHead = JSONObject.parseObject(beanJson, AccountHead.class);
        accountHead.setId(id);
        int result=0;
        try{
            result = accountHeadMapper.updateByPrimaryKeySelective(accountHead);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteAccountHead(Long id)throws Exception {
        int result=0;
        try{
            result = accountHeadMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAccountHead(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        AccountHeadExample example = new AccountHeadExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result = accountHeadMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
<<<<<<< HEAD
        AccountHeadExample example = new AccountHeadExample();
        example.createCriteria().andIdNotEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<AccountHead> list = null;
        try{
            list = accountHeadMapper.selectByExample(example);
=======
//        AccountHeadExample example = new AccountHeadExample();
        QueryWrapper<AccountHead> wrapper = new QueryWrapper<>();
//        example.createCriteria().andIdNotEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        wrapper.lambda().ne(AccountHead::getId,id).ne(AccountHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
        List<AccountHead> list = null;
        try{
            list = accountHeadMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Override
    public Long getMaxId()throws Exception {
        Long result = null;
        try{
            result = accountHeadMapperEx.getMaxId();
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Override
    public BigDecimal findAllMoney(Integer supplierId, String type, String mode, String endTime) {
        String modeName = "";
        if (mode.equals("实际")) {
            modeName = "ChangeAmount";
        } else if (mode.equals("合计")) {
            modeName = "TotalPrice";
        }
        BigDecimal result = null;
        try{
            result = accountHeadMapperEx.findAllMoney(supplierId, type, modeName, endTime);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    /**
     * 统计总金额
     * @param getS
     * @param type
     * @param mode 合计或者金额
     * @param endTime
     * @return
     */
    @Override
    public BigDecimal allMoney(String getS, String type, String mode, String endTime) {
        BigDecimal allMoney = BigDecimal.ZERO;
        try {
            Integer supplierId = Integer.valueOf(getS);
            BigDecimal sum = findAllMoney(supplierId, type, mode, endTime);
            if(sum != null) {
                allMoney = sum;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回正数，如果负数也转为正数
        if ((allMoney.compareTo(BigDecimal.ZERO))==-1) {
            allMoney = allMoney.abs();
        }
        return allMoney;
    }

    /**
     * 查询单位的累计应收和累计应付，收预付款不计入此处
     * @param supplierId
     * @param endTime
     * @param supType
     * @return
     */
    @Override
    public BigDecimal findTotalPay(Integer supplierId, String endTime, String supType) {
        BigDecimal sum = BigDecimal.ZERO;
        String getS = supplierId.toString();
        int i = 1;
        if (("customer").equals(supType)) { //客户
            i = 1;
        } else if (("vendor").equals(supType)) { //供应商
            i = -1;
        }
        //收付款部分
        sum = sum.add((allMoney(getS, "付款", "合计",endTime).add(allMoney(getS, "付款", "实际",endTime))).multiply(new BigDecimal(i)));
        sum = sum.subtract((allMoney(getS, "收款", "合计",endTime).add(allMoney(getS, "收款", "实际",endTime))).multiply(new BigDecimal(i)));
        sum = sum.add((allMoney(getS, "收入", "合计",endTime).subtract(allMoney(getS, "收入", "实际",endTime))).multiply(new BigDecimal(i)));
        sum = sum.subtract((allMoney(getS, "支出", "合计",endTime).subtract(allMoney(getS, "支出", "实际",endTime))).multiply(new BigDecimal(i)));
        return sum;
    }

    @Override
    public List<AccountHeadVo4ListEx> getDetailByNumber(String billNo)throws Exception {
        List<AccountHeadVo4ListEx> resList = new ArrayList<AccountHeadVo4ListEx>();
        List<AccountHeadVo4ListEx> list = null;
        try{
            list = accountHeadMapperEx.getDetailByNumber(billNo);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if (null != list) {
            for (AccountHeadVo4ListEx ah : list) {
                if(ah.getChangeamount() != null) {
                    ah.setChangeamount(ah.getChangeamount().abs());
                }
                if(ah.getTotalprice() != null) {
                    ah.setTotalprice(ah.getTotalprice().abs());
                }
                resList.add(ah);
            }
        }
        return resList;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAccountHeadByIds(String ids)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ACCOUNT_HEAD,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result = 0;
        try{
            result = accountHeadMapperEx.batchDeleteAccountHeadByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
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
     * create time: 2019/4/10 15:49
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAccountHeadByIdsNormal(String ids) throws Exception {
        /**
         * 校验
         * 1、财务子表	jsh_accountitem
         * 是否有相关数据
         * */
        int deleteTotal=0;
        if(StringUtils.isEmpty(ids)){
            return deleteTotal;
        }
        String [] idArray=ids.split(",");
        /**
         * 校验财务子表	jsh_accountitem
         * */
        List<AccountItem> accountItemList = null;
        try{
            accountItemList = accountItemMapperEx.getAccountItemListByHeaderIds(idArray);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        if(accountItemList!=null&&accountItemList.size()>0){
            logger.error("异常码[{}],异常提示[{}],参数,HeaderIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal= batchDeleteAccountHeadByIds(ids);
        return deleteTotal;
    }
<<<<<<< HEAD
=======


    @Override
    public Object selectOne(Long id) throws Exception {
        return getAccountHead(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getAccountHeadList(map);
    }

    @Override
    public List<?> getAccountHeadList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String billNo = StringUtil.getInfo(search, "billNo");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        String order = QueryUtils.order(map);
        return select(type, billNo, beginTime, endTime, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String billNo = StringUtil.getInfo(search, "billNo");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        return countAccountHead(type, billNo, beginTime, endTime);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception{
        return insertAccountHead(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateAccountHead(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteAccountHead(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteAccountHead(ids);
    }

>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

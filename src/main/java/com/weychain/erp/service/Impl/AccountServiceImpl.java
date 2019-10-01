package com.weychain.erp.service.Impl;


import com.alibaba.fastjson.JSONObject;
<<<<<<< HEAD
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
=======
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.DO.*;
import com.weychain.erp.domain.VO.AccountVo4InOutList;
import com.weychain.erp.domain.VO.AccountVo4List;
import com.weychain.erp.domain.example.AccountExample;
import com.weychain.erp.domain.example.AccountHeadExample;
import com.weychain.erp.domain.example.AccountItemExample;
import com.weychain.erp.domain.example.DepotHeadExample;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.exception.JshException;
import com.weychain.erp.mapper.*;
import com.weychain.erp.service.AccountService;
import com.weychain.erp.service.LogService;
import com.weychain.erp.service.UserService;
<<<<<<< HEAD
=======
import com.weychain.erp.utils.Constants;
import com.weychain.erp.utils.QueryUtils;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import com.weychain.erp.utils.StringUtil;
import com.weychain.erp.utils.Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {


    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountMapperEx accountMapperEx;

    @Resource
    private DepotHeadMapper depotHeadMapper;
    @Resource
    private DepotHeadMapperEx depotHeadMapperEx;

    @Resource
    private AccountHeadMapper accountHeadMapper;
    @Resource
    private AccountHeadMapperEx accountHeadMapperEx;

    @Resource
    private AccountItemMapper accountItemMapper;
    @Resource
    private AccountItemMapperEx accountItemMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;

    @Override
    public Account getAccount(long id) throws Exception{
        return accountMapper.selectById(id);
    }

    @Override
    public List<Account> getAccount() throws Exception{
        List<Account> list=null;
        try{
            list=accountMapper.selectList( new QueryWrapper<Account>().lambda().ne(Account::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED));
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        return list;

    }

    @Override
    public List<AccountVo4List> select(String name, String serialNo, String remark, int offset, int rows) throws Exception{
        List<AccountVo4List> resList = new ArrayList<AccountVo4List>();
        List<AccountVo4List> list=null;
        try{
            list = accountMapperEx.selectByConditionAccount(name, serialNo, remark, offset, rows);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        String timeStr = Tools.getCurrentMonth();
        if (null != list && null !=timeStr) {
            for (AccountVo4List al : list) {
                DecimalFormat df = new DecimalFormat(".##");
                BigDecimal thisMonthAmount = getAccountSum(al.getId(), timeStr, "month").add(getAccountSumByHead(al.getId(), timeStr, "month")).add(getAccountSumByDetail(al.getId(), timeStr, "month")).add(getManyAccountSum(al.getId(), timeStr, "month"));
                String thisMonthAmountFmt = "0";
                if ((thisMonthAmount.compareTo(BigDecimal.ZERO))!=0) {
                    thisMonthAmountFmt = df.format(thisMonthAmount);
                }
                al.setThismonthamount(thisMonthAmountFmt);  //本月发生额
                BigDecimal currentAmount = getAccountSum(al.getId(), "", "month").add(getAccountSumByHead(al.getId(), "", "month")).add(getAccountSumByDetail(al.getId(), "", "month")).add(getManyAccountSum(al.getId(), "", "month")) .add(al.getInitialamount()) ;
                al.setCurrentamount(currentAmount);
                resList.add(al);
            }
        }
        return resList;
    }

    @Override
    public Long countAccount(String name, String serialNo, String remark)throws Exception {
        Long result=null;
        try{
            result=accountMapperEx.countsByAccount(name, serialNo, remark);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertAccount(String beanJson, HttpServletRequest request)throws Exception {
        Account account = JSONObject.parseObject(beanJson, Account.class);
        if(account.getInitialamount() == null) {
            account.setInitialamount(BigDecimal.ZERO);
        }
        account.setIsdefault(false);
        int result=0;
        try{
            result = accountMapper.insertSelective(account);
        }catch(Exception e){
            JshException.writeFail(log, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateAccount(String beanJson, Long id)throws Exception {
        Account account = JSONObject.parseObject(beanJson, Account.class);
        account.setId(id);
        int result=0;
        try{
            result = accountMapper.updateByPrimaryKeySelective(account);
        }catch(Exception e){
            JshException.writeFail(log, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteAccount(Long id) throws Exception{
        int result=0;
        try{
            result = accountMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(log, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAccount(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
<<<<<<< HEAD
        AccountExample example = new AccountExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result = accountMapper.deleteByExample(example);
=======
//        AccountExample example = new AccountExample();
//        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result = accountMapper.delete(new QueryWrapper<Account>().lambda().in(Account::getId, idList));
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
        }catch(Exception e){
            JshException.writeFail(log, e);
        }
        return result;
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
<<<<<<< HEAD
        AccountExample example = new AccountExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Account> list=null;
        try{
            list = accountMapper.selectByExample(example);
=======
//        AccountExample example = new AccountExample();
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
//      example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        wrapper.lambda().ne(Account::getId,id).eq(Account::getName,name).ne(Account::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
        List<Account> list=null;
        try{
            list = accountMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        return list==null?0:list.size();
    }

    @Override
    public List<Account> findBySelect()throws Exception {
<<<<<<< HEAD
        AccountExample example = new AccountExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("id desc");
        List<Account> list=null;
        try{
            list = accountMapper.selectByExample(example);
=======
//        AccountExample example = new AccountExample();
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
//        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        wrapper.lambda().ne(Account::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED).orderByDesc(Account::getId);
//        example.setOrderByClause("id desc");
        List<Account> list=null;
        try{
            list = accountMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        return list;
    }

    /**
     * 单个账户的金额求和-入库和出库
     *
     * @param id
     * @return
     */
    @Override
    public BigDecimal getAccountSum(Long id, String timeStr, String type) throws Exception{
        BigDecimal accountSum = BigDecimal.ZERO;
        try {
<<<<<<< HEAD
            DepotHeadExample example = new DepotHeadExample();
=======
            QueryWrapper<DepotHead> wrapper = new QueryWrapper<>();
//            DepotHeadExample example = new DepotHeadExample();
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            if (!timeStr.equals("")) {
                Date bTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                Date eTime = StringUtil.getDateByString(timeStr + "-31 00:00:00", null);
                Date mTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                if (type.equals("month")) {
<<<<<<< HEAD
                    example.createCriteria().andAccountidEqualTo(id).andPaytypeNotEqualTo("预付款")
                            .andOpertimeGreaterThanOrEqualTo(bTime).andOpertimeLessThanOrEqualTo(eTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
                    example.createCriteria().andAccountidEqualTo(id).andPaytypeNotEqualTo("预付款")
                            .andOpertimeLessThanOrEqualTo(mTime).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                }
            } else {
                example.createCriteria().andAccountidEqualTo(id).andPaytypeNotEqualTo("预付款")
                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            }
            List<DepotHead> dataList=null;
            try{
                dataList = depotHeadMapper.selectByExample(example);
=======
//                    example.createCriteria().andAccountidEqualTo(id).andPaytypeNotEqualTo("预付款")
//                            .andOpertimeGreaterThanOrEqualTo(bTime).andOpertimeLessThanOrEqualTo(eTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().eq(DepotHead::getAccountid,id).ne(DepotHead::getPaytype,"预付款").ge(DepotHead::getOpertime,bTime).ne(DepotHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
//                    example.createCriteria().andAccountidEqualTo(id).andPaytypeNotEqualTo("预付款")
//                            .andOpertimeLessThanOrEqualTo(mTime).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().eq(DepotHead::getAccountid,id).ne(DepotHead::getPaytype,"预付款").le(DepotHead::getOpertime,bTime).ne(DepotHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);

                }
            } else {
//                example.createCriteria().andAccountidEqualTo(id).andPaytypeNotEqualTo("预付款")
//                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                wrapper.lambda().eq(DepotHead::getAccountid,id).ne(DepotHead::getPaytype,"预付款").ne(DepotHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
            }
            List<DepotHead> dataList=null;
            try{
                dataList = depotHeadMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            }catch(Exception e){
                JshException.readFail(log, e);
            }
            if (dataList != null) {
                for (DepotHead depotHead : dataList) {
                    if(depotHead.getChangeamount()!=null) {
                        accountSum = accountSum .add(depotHead.getChangeamount()) ;
                    }
                }
            }
        } catch (DataAccessException e) {
            log.error(">>>>>>>>>查找进销存信息异常", e);
        }
        return accountSum;
    }

    /**
     * 单个账户的金额求和-收入、支出、转账的单据表头的合计
     *
     * @param id
     * @return
     */
    @Override
    public BigDecimal getAccountSumByHead(Long id, String timeStr, String type) throws Exception{
        BigDecimal accountSum = BigDecimal.ZERO;
        try {
<<<<<<< HEAD
            AccountHeadExample example = new AccountHeadExample();
=======
            QueryWrapper<AccountHead> wrapper = new QueryWrapper<>();
//            AccountHeadExample example = new AccountHeadExample();
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            if (!timeStr.equals("")) {
                Date bTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                Date eTime = StringUtil.getDateByString(timeStr + "-31 00:00:00", null);
                Date mTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                if (type.equals("month")) {
<<<<<<< HEAD
                    example.createCriteria().andAccountidEqualTo(id)
                            .andBilltimeGreaterThanOrEqualTo(bTime).andBilltimeLessThanOrEqualTo(eTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
                    example.createCriteria().andAccountidEqualTo(id)
                            .andBilltimeLessThanOrEqualTo(mTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                }
            } else {
                example.createCriteria().andAccountidEqualTo(id)
                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            }
            List<AccountHead> dataList=null;
            try{
                dataList = accountHeadMapper.selectByExample(example);
=======
//                    example.createCriteria().andAccountidEqualTo(id)
//                            .andBilltimeGreaterThanOrEqualTo(bTime).andBilltimeLessThanOrEqualTo(eTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().eq(AccountHead::getAccountid,id).ge(AccountHead::getBilltime,bTime).le(AccountHead::getBilltime,eTime).ne(AccountHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
//                    example.createCriteria().andAccountidEqualTo(id)
//                            .andBilltimeLessThanOrEqualTo(mTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().eq(AccountHead::getAccountid,id).le(AccountHead::getBilltime,mTime).ne(AccountHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                }
            } else {
//                example.createCriteria().andAccountidEqualTo(id)
//                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                wrapper.lambda().eq(AccountHead::getAccountid,id).ne(AccountHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
            }
            List<AccountHead> dataList=null;
            try{
                dataList = accountHeadMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            }catch(Exception e){
                JshException.readFail(log, e);
            }
            if (dataList != null) {
                for (AccountHead accountHead : dataList) {
                    if(accountHead.getChangeamount()!=null) {
                        accountSum = accountSum.add(accountHead.getChangeamount());
                    }
                }
            }
        } catch (DataAccessException e) {
            log.error(">>>>>>>>>查找进销存信息异常", e);
        }
        return accountSum;
    }

    /**
     * 单个账户的金额求和-收款、付款、转账、收预付款的单据明细的合计
     *
     * @param id
     * @return
     */
    @Override
    public BigDecimal getAccountSumByDetail(Long id, String timeStr, String type)throws Exception {
        BigDecimal accountSum =BigDecimal.ZERO ;
        try {
<<<<<<< HEAD
            AccountHeadExample example = new AccountHeadExample();
=======
            QueryWrapper<AccountHead> queryWrapper = new QueryWrapper<>();
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            if (!timeStr.equals("")) {
                Date bTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                Date eTime = StringUtil.getDateByString(timeStr + "-31 00:00:00", null);
                Date mTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                if (type.equals("month")) {
<<<<<<< HEAD
                    example.createCriteria().andBilltimeGreaterThanOrEqualTo(bTime).andBilltimeLessThanOrEqualTo(eTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
                    example.createCriteria().andBilltimeLessThanOrEqualTo(mTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
=======
//                    example.createCriteria().andBilltimeGreaterThanOrEqualTo(bTime).andBilltimeLessThanOrEqualTo(eTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    queryWrapper.lambda().ge(AccountHead::getBilltime,bTime).le(AccountHead::getBilltime,eTime).ne(AccountHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);

                } else if (type.equals("date")) {
//                    example.createCriteria().andBilltimeLessThanOrEqualTo(mTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    queryWrapper.lambda().le(AccountHead::getBilltime,mTime).ne(AccountHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
                }
            }
            List<AccountHead> dataList=null;
            try{
<<<<<<< HEAD
                dataList = accountHeadMapper.selectByExample(example);
=======
                dataList = accountHeadMapper.selectList(queryWrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            }catch(Exception e){
                JshException.readFail(log, e);
            }
            if (dataList != null) {
                String ids = "";
                for (AccountHead accountHead : dataList) {
                    ids = ids + accountHead.getId() + ",";
                }
                if (!ids.equals("")) {
                    ids = ids.substring(0, ids.length() - 1);
                }
<<<<<<< HEAD

                AccountItemExample exampleAi = new AccountItemExample();
                if (!ids.equals("")) {
                    List<Long> idList = StringUtil.strToLongList(ids);
                    exampleAi.createCriteria().andAccountidEqualTo(id).andHeaderidIn(idList)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                } else {
                    exampleAi.createCriteria().andAccountidEqualTo(id)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                }
                List<AccountItem> dataListOne = accountItemMapper.selectByExample(exampleAi);
=======
                QueryWrapper<AccountItem> wrapper = new QueryWrapper();
//                AccountItemExample exampleAi = new AccountItemExample();
                if (!ids.equals("")) {
                    List<Long> idList = StringUtil.strToLongList(ids);
//                    exampleAi.createCriteria().andAccountidEqualTo(id).andHeaderidIn(idList)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().eq(AccountItem::getAccountid,id).in(AccountItem::getHeaderid,idList).ne(AccountItem::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                } else {
//                    exampleAi.createCriteria().andAccountidEqualTo(id)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().eq(AccountItem::getAccountid,id).ne(AccountItem::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                }
                List<AccountItem> dataListOne = accountItemMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
                if (dataListOne != null) {
                    for (AccountItem accountItem : dataListOne) {
                        if(accountItem.getEachamount()!=null) {
                            accountSum = accountSum.add(accountItem.getEachamount());
                        }
                    }
                }
            }
        } catch (DataAccessException e) {
            log.error(">>>>>>>>>查找进销存信息异常", e);
        } catch (Exception e) {
            log.error(">>>>>>>>>异常信息：", e);
        }
        return accountSum;
    }

    /**
     * 单个账户的金额求和-多账户的明细合计
     *
     * @param id
     * @return
     */
    @Override
    public BigDecimal getManyAccountSum(Long id, String timeStr, String type)throws Exception {
        BigDecimal accountSum = BigDecimal.ZERO;
        try {
<<<<<<< HEAD
            DepotHeadExample example = new DepotHeadExample();
=======
//            tryDepotHeadExample example = new DepotHeadExample();
            QueryWrapper<DepotHead> wrapper = new QueryWrapper<>();
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            if (!timeStr.equals("")) {
                Date bTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                Date eTime = StringUtil.getDateByString(timeStr + "-31 00:00:00", null);
                Date mTime = StringUtil.getDateByString(timeStr + "-01 00:00:00", null);
                if (type.equals("month")) {
<<<<<<< HEAD
                    example.createCriteria().andAccountidlistLike("%" +id.toString() + "%")
                            .andOpertimeGreaterThanOrEqualTo(bTime).andOpertimeLessThanOrEqualTo(eTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
                    example.createCriteria().andAccountidlistLike("%" +id.toString() + "%")
                            .andOpertimeLessThanOrEqualTo(mTime)
                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                }
            } else {
                example.createCriteria().andAccountidlistLike("%" +id.toString() + "%")
                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            }
            List<DepotHead> dataList=null;
            try{
                dataList = depotHeadMapper.selectByExample(example);
=======
//                    example.createCriteria().andAccountidlistLike("%" +id.toString() + "%")
//                            .andOpertimeGreaterThanOrEqualTo(bTime).andOpertimeLessThanOrEqualTo(eTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().like(DepotHead::getAccountidlist,"%" +id.toString() + "%").ge(DepotHead::getOpertime,bTime)
                            .le(DepotHead::getOpertime,eTime).ne(DepotHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                } else if (type.equals("date")) {
//                    example.createCriteria().andAccountidlistLike("%" +id.toString() + "%")
//                            .andOpertimeLessThanOrEqualTo(mTime)
//                            .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                    wrapper.lambda().like(DepotHead::getAccountidlist,"%" +id.toString() + "%").le(DepotHead::getOpertime,eTime).ne(DepotHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
                }
            } else {
//                example.createCriteria().andAccountidlistLike("%" +id.toString() + "%")
//                        .andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
                wrapper.lambda().like(DepotHead::getAccountidlist,"%" +id.toString() + "%").ne(DepotHead::getDeleteFlag,BusinessConstants.DELETE_FLAG_DELETED);
            }
            List<DepotHead> dataList=null;
            try{
                dataList = depotHeadMapper.selectList(wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
            }catch(Exception e){
                JshException.readFail(log, e);
            }
            if (dataList != null) {
                for (DepotHead depotHead : dataList) {
                    String accountIdList = depotHead.getAccountidlist();
                    String accountMoneyList = depotHead.getAccountmoneylist();
                    accountIdList = accountIdList.replace("[", "").replace("]", "").replace("\"", "");
                    accountMoneyList = accountMoneyList.replace("[", "").replace("]", "").replace("\"", "");
                    String[] aList = accountIdList.split(",");
                    String[] amList = accountMoneyList.split(",");
                    for (int i = 0; i < aList.length; i++) {
                        if (aList[i].toString().equals(id.toString())) {
                            accountSum = accountSum .add(new BigDecimal(amList[i]));
                        }
                    }
                }
            }
        } catch (DataAccessException e) {
            log.error(">>>>>>>>>查找信息异常", e);
        }
        return accountSum;
    }

    @Override
    public List<AccountVo4InOutList> findAccountInOutList(Long accountId, Integer offset, Integer rows) throws Exception{
        List<AccountVo4InOutList> list=null;
        try{
            list = accountMapperEx.findAccountInOutList(accountId, offset, rows);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        return list;
    }

    @Override
    public int findAccountInOutListCount(Long accountId) throws Exception{
        int result=0;
        try{
            result = accountMapperEx.findAccountInOutListCount(accountId);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        return result;
    }

    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateAmountIsDefault(Boolean isDefault, Long accountId) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ACCOUNT,BusinessConstants.LOG_OPERATION_TYPE_EDIT+accountId,
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        Account account = new Account();
        account.setIsdefault(isDefault);
<<<<<<< HEAD
        AccountExample example = new AccountExample();
        example.createCriteria().andIdEqualTo(accountId);
        int result=0;
        try{
            result = accountMapper.updateByExampleSelective(account, example);
=======
        QueryWrapper< Account> wrapper = new QueryWrapper<>();
//        AccountExample example = new AccountExample();
//        example.createCriteria().andIdEqualTo(accountId);
        wrapper.lambda().eq(Account::getId,accountId);
        int result=0;
        try{
            result = accountMapper.update(account, wrapper);
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
        }catch(Exception e){
            JshException.writeFail(log, e);
        }
        return result;
    }
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAccountByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ACCOUNT,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo= userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result = accountMapperEx.batchDeleteAccountByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            JshException.writeFail(log, e);
        }
        return result;
    }
    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  正常删除，要考虑数据完整性，进行完整性校验
     * create time: 2019/4/10 10:31
     * @Param: ids
     * @return int
     */
    @Override
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteAccountByIdsNormal(String ids) throws Exception{
        /**
         * 校验：
         * 1、财务主表	jsh_accounthead
         * 2、财务子表	jsh_accountitem
         * 3、单据主表	jsh_depothead
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
            accountHeadList = accountHeadMapperEx.getAccountHeadListByAccountIds(idArray);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        if(accountHeadList!=null&&accountHeadList.size()>0){
            log.error("异常码[{}],异常提示[{}],参数,AccountIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验财务子表	jsh_accountitem
         * */
        List<AccountItem> accountItemList=null;
        try{
            accountItemList = accountItemMapperEx.getAccountItemListByAccountIds(idArray);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        if(accountItemList!=null&&accountItemList.size()>0){
            log.error("异常码[{}],异常提示[{}],参数,AccountIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验单据主表	jsh_depothead
         * */
        List<DepotHead> depotHeadList =null;
        try{
            depotHeadList = depotHeadMapperEx.getDepotHeadListByAccountIds(idArray);
        }catch(Exception e){
            JshException.readFail(log, e);
        }
        if(depotHeadList!=null&&depotHeadList.size()>0){
            log.error("异常码[{}],异常提示[{}],参数,AccountIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,ExceptionConstants.DELETE_FORCE_CONFIRM_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        /**
         * 校验通过执行删除操作
         * */
        deleteTotal= batchDeleteAccountByIds(ids);
        return deleteTotal;

    }


<<<<<<< HEAD
=======
    @Override
    public Object selectOne(Long id) throws Exception {
        return getAccount(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getAccountList(map);
    }

    @Override
    public List<?> getAccountList(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String serialNo = StringUtil.getInfo(search, "serialNo");
        String remark = StringUtil.getInfo(search, "remark");
        String order = QueryUtils.order(map);
        return select(name, serialNo, remark, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String serialNo = StringUtil.getInfo(search, "serialNo");
        String remark = StringUtil.getInfo(search, "remark");
        return countAccount(name, serialNo, remark);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception{
        return insertAccount(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return updateAccount(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return deleteAccount(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return batchDeleteAccount(ids);
    }
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

}

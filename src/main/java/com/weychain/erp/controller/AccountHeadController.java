package com.weychain.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.weychain.erp.constants.BusinessConstants;
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.DO.AccountHeadVo4ListEx;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.service.Impl.AccountHeadServiceImpl;
import com.weychain.erp.utils.BaseResponseInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jishenghua 752*718*920
 */
@RestController
@RequestMapping(value = "/accountHead")
public class AccountHeadController {
    private Logger logger = LoggerFactory.getLogger(AccountHeadController.class);

    @Resource
    private AccountHeadServiceImpl accountHeadServiceImpl;

    /**
     * 获取最大的id
     * @param request
     * @return
     */
    @GetMapping(value = "/getMaxId")
    public BaseResponseInfo getMaxId(HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Long maxId = accountHeadServiceImpl.getMaxId();
            map.put("maxId", maxId);
            res.code = 200;
            res.data = map;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 查询单位的累计应收和累计应付，收预付款不计入此处
     * @param supplierId
     * @param endTime
     * @param supType
     * @param request
     * @return
     */
    @GetMapping(value = "/findTotalPay")
    public BaseResponseInfo findTotalPay(@RequestParam("supplierId") Integer supplierId,
                                         @RequestParam("endTime") String endTime,
                                         @RequestParam("supType") String supType,
                                         HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            JSONObject outer = new JSONObject();
            BigDecimal sum = accountHeadServiceImpl.findTotalPay(supplierId, endTime, supType);
            outer.put("getAllMoney", sum);
            map.put("rows", outer);
            res.code = 200;
            res.data = map;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 根据编号查询单据信息
     * @param billNo
     * @param request
     * @return
     */
    @GetMapping(value = "/getDetailByNumber")
    public BaseResponseInfo getDetailByNumber(@RequestParam("billNo") String billNo,
                                              HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        AccountHeadVo4ListEx ahl = new AccountHeadVo4ListEx();
        try {
            List<AccountHeadVo4ListEx> list = accountHeadServiceImpl.getDetailByNumber(billNo);
            if(list.size() == 1) {
                ahl = list.get(0);
            }
            res.code = 200;
            res.data = ahl;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  批量删除账户信息
     * create time: 2019/3/29 10:49
     * @Param: ids
     * @return java.lang.Object
     */
    @RequestMapping(value = "/batchDeleteAccountHeadByIds")
    public Object batchDeleteAccountHeadByIds(@RequestParam("ids") String ids,@RequestParam(value="deleteType",
            required =false,defaultValue= BusinessConstants.DELETE_TYPE_NORMAL)String deleteType) throws Exception {

        JSONObject result = ExceptionConstants.standardSuccess();
        int i=0;
        if(BusinessConstants.DELETE_TYPE_NORMAL.equals(deleteType)){
            i= accountHeadServiceImpl.batchDeleteAccountHeadByIdsNormal(ids);
        }else if(BusinessConstants.DELETE_TYPE_FORCE.equals(deleteType)){
            i= accountHeadServiceImpl.batchDeleteAccountHeadByIds(ids);
        }else{
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}],deleteType[{}]",
                    ExceptionConstants.DELETE_REFUSED_CODE,ExceptionConstants.DELETE_REFUSED_MSG,ids,deleteType);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_REFUSED_CODE,
                    ExceptionConstants.DELETE_REFUSED_MSG);
        }
        if(i<1){
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}]",
                    ExceptionConstants.ACCOUNT_HEAD_DELETE_FAILED_CODE,ExceptionConstants.ACCOUNT_HEAD_DELETE_FAILED_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.ACCOUNT_HEAD_DELETE_FAILED_CODE,
                    ExceptionConstants.ACCOUNT_HEAD_DELETE_FAILED_MSG);
        }
        return result;
    }

}

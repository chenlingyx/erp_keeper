package com.weychain.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
<<<<<<< HEAD
=======
import com.weychain.erp.constants.BusinessConstants;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.DO.SerialNumberEx;
import com.weychain.erp.exception.BusinessParamCheckingException;
import com.weychain.erp.exception.BusinessRunTimeException;
import com.weychain.erp.service.SerialNumberService;
<<<<<<< HEAD
import com.weychain.erp.utils.StringUtil;
=======
import com.weychain.erp.utils.*;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.weychain.erp.utils.ResponseJsonUtil.returnJson;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/1/22 10:29
 */
@RestController
public class SerialNumberController {
    private Logger logger = LoggerFactory.getLogger(SerialNumberController.class);

    @Resource
    private SerialNumberService serialNumberService;
    /**
     * create by: cjl
     * description:
     *  检查序列号是否存在
     * create time: 2019/1/22 11:02
     * @Param: id
     * @Param: materialName
     * @Param: serialNumber
     * @Param: request
     * @return java.lang.Object
     */
<<<<<<< HEAD
    @PostMapping("/serialNumber/checkIsExist")
=======
    @PostMapping("/checkIsExist")
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    @ResponseBody
    public Object checkIsExist(@RequestParam("id") Long id, @RequestParam("materialName") String materialName,
                               @RequestParam("serialNumber") String serialNumber, HttpServletRequest request) throws Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        if(StringUtil.isEmpty(serialNumber)){
            throw new BusinessParamCheckingException(ExceptionConstants.SERIAL_NUMBERE_NOT_BE_EMPTY_CODE,
                    ExceptionConstants.SERIAL_NUMBERE_NOT_BE_EMPTY_MSG);
        }
        serialNumberService.checkIsExist(id, materialName, serialNumber);
        return result;
    }
    /**
     * create by: cjl
     * description:
     *  新增序列号信息
     * create time: 2019/1/22 17:10
     * @Param: beanJson
     * @Param: request
     * @return java.lang.Object
     */
<<<<<<< HEAD
    @PostMapping("/serialNumber/addSerialNumber")
=======
    @PostMapping("/addSerialNumber")
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    @ResponseBody
    public Object addSerialNumber(@RequestParam("info") String beanJson)throws Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        SerialNumberEx sne= JSON.parseObject(beanJson, SerialNumberEx.class);
        serialNumberService.addSerialNumber(sne);
        return result;

    }
    /**
     * create by: cjl
     * description:
     *  修改序列号信息
     * create time: 2019/1/23 13:56
     * @Param: beanJson
     * @return java.lang.Object
     */
<<<<<<< HEAD
    @PostMapping("/serialNumber/updateSerialNumber")
=======
    @PostMapping("/updateSerialNumber")
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    @ResponseBody
    public Object updateSerialNumber(@RequestParam("info") String beanJson)throws Exception{

        JSONObject result = ExceptionConstants.standardSuccess();
        SerialNumberEx sne= JSON.parseObject(beanJson, SerialNumberEx.class);
        serialNumberService.updateSerialNumber(sne);
        return result;

    }
    /**
     * create by: cjl
     * description:
     *批量添加序列号
     * create time: 2019/1/29 15:11
     * @Param: materialName
     * @Param: serialNumberPrefix
     * @Param: batAddTotal
     * @Param: remark
     * @return java.lang.Object
     */
<<<<<<< HEAD
    @PostMapping("/serialNumber/batAddSerialNumber")
=======
    @PostMapping("/batAddSerialNumber")
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    @ResponseBody
    public Object batAddSerialNumber(@RequestParam("materialName") String materialName, @RequestParam("serialNumberPrefix") String serialNumberPrefix,
                                     @RequestParam("batAddTotal") Integer batAddTotal,@RequestParam("remark") String remark)throws Exception{

        JSONObject result = ExceptionConstants.standardSuccess();
        serialNumberService.batAddSerialNumber(materialName,serialNumberPrefix,batAddTotal,remark);
        return result;

    }
    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  逻辑删除序列号信息
     * create time: 2019/3/27 17:43
     * @Param: ids
     * @return java.lang.Object
     */
<<<<<<< HEAD
    @RequestMapping(value = "/serialNumber/batchDeleteSerialNumberByIds")
=======
    @RequestMapping(value = "/batchDeleteSerialNumberByIds")
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
    public Object batchDeleteSerialNumberByIds(@RequestParam("ids") String ids) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        int i= serialNumberService.batchDeleteSerialNumberByIds(ids);
        if(i<1){
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}]",
                    ExceptionConstants.SERIAL_NUMBERE_DELETE_FAILED_CODE,ExceptionConstants.SERIAL_NUMBERE_DELETE_FAILED_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.SERIAL_NUMBERE_DELETE_FAILED_CODE,
                    ExceptionConstants.SERIAL_NUMBERE_DELETE_FAILED_MSG);
        }
        return result;
    }

<<<<<<< HEAD
=======
    @GetMapping(value = "/serialNumber/info")
    public String getList(@RequestParam("id") Long id,
                          HttpServletRequest request) throws Exception {
        Object obj = serialNumberService.selectOne(id);
        Map<String, Object> objectMap = new HashMap<String, Object>();
        if(obj != null) {
            objectMap.put("info", obj);
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @GetMapping(value = "/serialNumber//list")
    public String getList(
            @RequestParam(value = Constants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = Constants.CURRENT_PAGE, required = false) Integer currentPage,
            @RequestParam(value = Constants.SEARCH, required = false) String search,
            HttpServletRequest request)throws Exception {
        Map<String, String> parameterMap = ParamUtils.requestToMap(request);
        parameterMap.put(Constants.SEARCH, search);
        PageQueryInfo queryInfo = new PageQueryInfo();
        Map<String, Object> objectMap = new HashMap<String, Object>();
        if (pageSize != null && pageSize <= 0) {
            pageSize = 10;
        }
        String offset = ParamUtils.getPageOffset(currentPage, pageSize);
        if (StringUtil.isNotEmpty(offset)) {
            parameterMap.put(Constants.OFFSET, offset);
        }
        List<?> list = serialNumberService.select(parameterMap);
        objectMap.put("page", queryInfo);
        if (list == null) {
            queryInfo.setRows(new ArrayList<Object>());
            queryInfo.setTotal(BusinessConstants.DEFAULT_LIST_NULL_NUMBER);
            return returnJson(objectMap, "查找不到数据", ErpInfo.OK.code);
        }
        queryInfo.setRows(list);
        queryInfo.setTotal(serialNumberService.counts(parameterMap));
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }

    @PostMapping(value = "/serialNumber//add", produces = {"application/javascript", "application/json"})
    public String addResource(@PathVariable("apiName") String apiName,
                              @RequestParam("info") String beanJson, HttpServletRequest request)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int insert = serialNumberService.insert( beanJson, request);
        if(insert > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/serialNumber//update", produces = {"application/javascript", "application/json"})
    public String updateResource(@RequestParam("info") String beanJson,
                                 @RequestParam("id") Long id)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int update = serialNumberService.update(beanJson, id);
        if(update > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/serialNumber//{id}/delete", produces = {"application/javascript", "application/json"})
    public String deleteResource(@PathVariable Long id)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int delete = serialNumberService.delete(id);
        if(delete > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/serialNumber//batchDelete", produces = {"application/javascript", "application/json"})
    public String batchDeleteResource(@RequestParam("ids") String ids)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int delete = serialNumberService.batchDelete( ids);
        if(delete > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @GetMapping(value = "/serialNumber//checkIsNameExist")
    public String checkIsNameExist(@RequestParam Long id, @RequestParam(value ="name", required = false) String name)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int exist = serialNumberService.checkIsNameExist( id, name);
        if(exist > 0) {
            objectMap.put("status", true);
        } else {
            objectMap.put("status", false);
        }
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }


>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

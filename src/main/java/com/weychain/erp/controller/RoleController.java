package com.weychain.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
<<<<<<< HEAD
=======
import com.weychain.erp.constants.BusinessConstants;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import com.weychain.erp.constants.ExceptionConstants;
import com.weychain.erp.domain.DO.Role;
import com.weychain.erp.exception.BusinessRunTimeException;

import com.weychain.erp.service.RoleService;
import com.weychain.erp.service.UserBusinessService;
<<<<<<< HEAD
=======
import com.weychain.erp.utils.*;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.weychain.erp.utils.ResponseJsonUtil.returnJson;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

/**
 * @author ji sheng hua 华夏ERP
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    @Resource
    private UserBusinessService userBusinessService;

    /**
     * 角色对应应用显示
     * @param request
     * @return
     */
    @PostMapping(value = "/findUserRole")
    public JSONArray findUserRole(@RequestParam("UBType") String type, @RequestParam("UBKeyId") String keyId,
                                  HttpServletRequest request)throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<Role> dataList = roleService.findUserRole();
            //开始拼接json数据
            JSONObject outer = new JSONObject();
            outer.put("id", 1);
            outer.put("text", "角色列表");
            outer.put("state", "open");
            //存放数据json数组
            JSONArray dataArray = new JSONArray();
            if (null != dataList) {
                for (Role role : dataList) {
                    JSONObject item = new JSONObject();
                    item.put("id", role.getId());
                    item.put("text", role.getName());
                    //勾选判断1
                    Boolean flag = false;
                    try {
                        flag = userBusinessService.checkIsUserBusinessExist(type, keyId, "[" + role.getId().toString() + "]");
                    } catch (Exception e) {
                        logger.error(">>>>>>>>>>>>>>>>>设置用户对应的角色：类型" + type + " KeyId为： " + keyId + " 存在异常！");
                    }
                    if (flag == true) {
                        item.put("checked", true);
                    }
                    //结束
                    dataArray.add(item);
                }
            }
            outer.put("children", dataArray);
            arr.add(outer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @PostMapping(value = "/list")
    public List<Role> list(HttpServletRequest request)throws Exception {
        return roleService.getRole();
    }

    /**
     * create by: qiankunpingtai
     * website：https://qiankunpingtai.cn
     * description:
     *  逻辑删除角色信息
     * create time: 2019/3/28 15:39
     * @Param: ids
     * @return java.lang.Object
     */
    @RequestMapping(value = "/batchDeleteRoleByIds")
    public Object batchDeleteRoleByIds(@RequestParam("ids") String ids) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        int i= roleService.batchDeleteRoleByIds(ids);
        if(i<1){
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}]",
                    ExceptionConstants.ROLE_DELETE_FAILED_CODE,ExceptionConstants.ROLE_DELETE_FAILED_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.ROLE_DELETE_FAILED_CODE,
                    ExceptionConstants.ROLE_DELETE_FAILED_MSG);
        }
        return result;
    }

<<<<<<< HEAD
=======
    @GetMapping(value = "/info")
    public String getList(@RequestParam("id") Long id,
                          HttpServletRequest request) throws Exception {
        Object obj = roleService.selectOne(id);
        Map<String, Object> objectMap = new HashMap<String, Object>();
        if(obj != null) {
            objectMap.put("info", obj);
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @GetMapping(value = "/list")
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
        List<?> list = roleService.select(parameterMap);
        objectMap.put("page", queryInfo);
        if (list == null) {
            queryInfo.setRows(new ArrayList<Object>());
            queryInfo.setTotal(BusinessConstants.DEFAULT_LIST_NULL_NUMBER);
            return returnJson(objectMap, "查找不到数据", ErpInfo.OK.code);
        }
        queryInfo.setRows(list);
        queryInfo.setTotal(roleService.counts(parameterMap));
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }

    @PostMapping(value = "/add", produces = {"application/javascript", "application/json"})
    public String addResource(@PathVariable("apiName") String apiName,
                              @RequestParam("info") String beanJson, HttpServletRequest request)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int insert = roleService.insert( beanJson, request);
        if(insert > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/update", produces = {"application/javascript", "application/json"})
    public String updateResource(@RequestParam("info") String beanJson,
                                 @RequestParam("id") Long id)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int update = roleService.update(beanJson, id);
        if(update > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/{id}/delete", produces = {"application/javascript", "application/json"})
    public String deleteResource(@PathVariable Long id)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int delete = roleService.delete(id);
        if(delete > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @PostMapping(value = "/batchDelete", produces = {"application/javascript", "application/json"})
    public String batchDeleteResource(@RequestParam("ids") String ids)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int delete = roleService.batchDelete( ids);
        if(delete > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    @GetMapping(value = "/checkIsNameExist")
    public String checkIsNameExist(@RequestParam Long id, @RequestParam(value ="name", required = false) String name)throws Exception {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        int exist = roleService.checkIsNameExist( id, name);
        if(exist > 0) {
            objectMap.put("status", true);
        } else {
            objectMap.put("status", false);
        }
        return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
    }

>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
}

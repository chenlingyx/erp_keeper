package com.weychain.erp.controller;

import com.weychain.erp.service.OrganTypeNameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * create by: liziyan * description: *
 */
@RestController
@Slf4j
@RequestMapping(value = "/organTypeName")
public class OrganTypeNameController {
    @Resource
    private OrganTypeNameService organTypeNameService;

    /**
     * 查询机构类型名称列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/queryOrganTypeNameList")
    public Object queryOrganTypeNameList() {
        return organTypeNameService.queryOrganTypeNameList();
    }


}
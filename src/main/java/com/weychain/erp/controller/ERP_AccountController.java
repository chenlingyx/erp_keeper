package com.weychain.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weychain.erp.domain.DO.ERP_Account;
import com.weychain.erp.service.Impl.ErpAccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/** * create by: liziyan * description: * */
@RestController
@Slf4j
@RequestMapping(value = "/erp_Account")
public class ERP_AccountController {
    private Logger logger = LoggerFactory.getLogger(ERP_AccountController.class);
    @Resource
    private ErpAccountServiceImpl erpAccountServiceImpl;

    /**
     * 查询账户信息
     * @param erp_Account
     * @returnr
     * @throws Exception
     */
    @GetMapping(value = "/")
    public  Object accountQuery(@RequestBody ERP_Account erp_Account){
        return erpAccountServiceImpl.list(new QueryWrapper<>(erp_Account));
    }

    /**
     * 修改账户信息
     * @param erp_Acount
     * @return
     */
    @PutMapping("/")
    public  Object  accountUpdate( ERP_Account erp_Acount){
        return erpAccountServiceImpl.updateById(erp_Acount);
    }

    /**
     * 新增账户信息
     * @param erp_Acount
     * @return
     */

    @PostMapping("/")
    public Object accountCreate(ERP_Account erp_Acount){
        return erpAccountServiceImpl.save(erp_Acount);
    }

    /**
     * 根据ID删除账户信息
     * @param id
     * @return
     */
    @DeleteMapping("/")
    public Object  accountDelete(Integer id){
        return erpAccountServiceImpl.removeById(id);
    }


}
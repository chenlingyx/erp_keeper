package com.weychain.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weychain.erp.domain.DO.Address;
import com.weychain.erp.service.Impl.AddressServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/** * create by: liziyan * description: * */
@RestController
@Slf4j
@RequestMapping(value = "/address")
public class AddressController {
    private Logger logger = LoggerFactory.getLogger(AddressController.class);
    @Resource
    private AddressServiceImpl addressServiceImpl;

    /** 查询机构类型名称列表
     * @param address
     * @return
     * @throws
     */
    @GetMapping(value = "/queryAddressList")
    public  Object addressQuery(@RequestBody Address address){
        return addressServiceImpl.list(new QueryWrapper<>(address));
    }

    /**
     * 根据ID修改地址信息
     * @param address
     * @return
     */
    @PutMapping("/")
    public Object addressUpdate(Address address){
        return addressServiceImpl.updateById(address);
   }
    /**
     * 新增地址信息
     * @param address
     * @return
     */
   @PostMapping("/")
   public Object addressCreat(Address address){
        return addressServiceImpl.save(address);
   }

    /**
     * 根据ID删除地址
     * @param id
     * @return
     */
   @DeleteMapping("/")
   public Object addressDelete(Integer id){
        return addressServiceImpl.removeById(id);
   }
}
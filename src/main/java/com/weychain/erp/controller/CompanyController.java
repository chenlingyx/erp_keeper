package com.weychain.erp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weychain.erp.domain.DO.Company;
import com.weychain.erp.service.Impl.CompanyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/** * create by: liziyan * description: * */

@RestController
@Slf4j
@RequestMapping("/company")
public class CompanyController {
    private Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Resource
    private CompanyServiceImpl companyServiceImpl;

    /**
     * 添加公司信息
     * @param company
     * @return
     */
    @GetMapping("/")
    public  Object companyQuery(@RequestBody Company company){
        return  companyServiceImpl.list(new QueryWrapper<>(company));
    }

    /**
     * 修改公司信息
     * @param company
     * @return
     */
    @PutMapping("/")
    public Object companyUpdaet(Company company){
        return companyServiceImpl.updateById(company);
    }

    /**
     * 新建公司信息
     * @param company
     * @return
     */
    @PostMapping("/")
    public  Object companyCreat(Company company){
        return companyServiceImpl.save(company);
    }

    /**
     * 根据ID删除公司信息
     * @param id
     * @return
     */
    @DeleteMapping("/")
    public Object companyDelete(Integer id){
        return companyServiceImpl.removeById(id);
    }

}

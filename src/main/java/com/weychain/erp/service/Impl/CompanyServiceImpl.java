package com.weychain.erp.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weychain.erp.domain.DO.Company;
import com.weychain.erp.mapper.CompanyMapper;
import com.weychain.erp.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author: liziyan
 * @Date: 2019/09/27
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company>  implements CompanyService {
    private Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Resource
    private CompanyMapper companyMapper;


}
package com.weychain.erp.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weychain.erp.domain.DO.ERP_Account;
import com.weychain.erp.mapper.ERP_AccountMapper;
import com.weychain.erp.service.ErpAccountService;
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
public class ErpAccountServiceImpl extends ServiceImpl<ERP_AccountMapper,ERP_Account> implements ErpAccountService {
    private Logger logger = LoggerFactory.getLogger(ErpAccountServiceImpl.class);

    @Resource
    private ERP_AccountMapper erp_accountMapper;



}
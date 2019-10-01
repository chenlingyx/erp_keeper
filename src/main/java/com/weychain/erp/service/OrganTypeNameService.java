package com.weychain.erp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weychain.erp.domain.DO.OrganTypeName;

import java.util.List;

public interface OrganTypeNameService extends IService<OrganTypeName> {
    List<OrganTypeName> queryOrganTypeNameList();
}

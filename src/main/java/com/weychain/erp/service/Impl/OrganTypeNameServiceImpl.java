package com.weychain.erp.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weychain.erp.mapper.OrganTypeNameMapper;
import com.weychain.erp.domain.DO.OrganTypeName;
import com.weychain.erp.exception.JshException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @Author: liziyan
 * @Date: 2019/09/27
 */
@Service
public class OrganTypeNameServiceImpl extends ServiceImpl<OrganTypeNameMapper,OrganTypeName> implements com.weychain.erp.service.OrganTypeNameService {
    private Logger logger = LoggerFactory.getLogger(OrganTypeNameServiceImpl.class);

    @Resource
    private OrganTypeNameMapper organTypeNameMapper;

    /**
     * 查询机构类型名称
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<OrganTypeName> queryOrganTypeNameList() {
        List<OrganTypeName> list = null;
        try {
            list = organTypeNameMapper.queryOrganTypeNameList();
            if (list == null) {
                list = new ArrayList<>();
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

}
package com.weychain.erp.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weychain.erp.mapper.AddressMapper;
import com.weychain.erp.domain.DO.Address;
import com.weychain.erp.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author: liziyan
 * @Date: 2019/09/28
 */


@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>  implements AddressService {
    private Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Resource
    private AddressMapper addressMapper;

//    /**
//     * 遍历查询地址列表
//     * @param
//     * @return
//     * @throws Exception
//     */
//    public List<Address> queryAddressList() throws Exception{
//        List<Address> list = null;
//        try {
//            list =  addressMapper.queryAddressList();
//            if (list == null) {
//                list = new ArrayList<>();
//            }
//        } catch (Exception e) {
//            JshException.readFail(logger, e);
//        }
//        return list;
//    }

}
package com.weychain.erp.mapper;

import org.apache.ibatis.annotations.Param;

import com.weychain.erp.domain.DO.AccountItem;
import com.weychain.erp.domain.VO.AccountItemVo4List;

import java.util.Date;
import java.util.List;

public interface AccountItemMapperEx {

    List<AccountItem> selectByConditionAccountItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByAccountItem(
            @Param("name") String name,
            @Param("type") Integer type,
            @Param("remark") String remark);

    List<AccountItemVo4List> getDetailList(
            @Param("headerId") Long headerId);

    int batchDeleteAccountItemByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<AccountItem> getAccountItemListByAccountIds(@Param("accountIds") String[] accountIds);

    List<AccountItem> getAccountItemListByHeaderIds(@Param("headerIds") String[] headerIds);

    List<AccountItem> getAccountItemListByInOutItemIds(@Param("inOutItemIds") String[] inOutItemIds);
}
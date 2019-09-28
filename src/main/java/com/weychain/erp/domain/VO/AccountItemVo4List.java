package com.weychain.erp.domain.VO;

import com.weychain.erp.domain.DO.AccountItem;

public class AccountItemVo4List extends AccountItem {

    private String accountName;

    private String inOutItemName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getInOutItemName() {
        return inOutItemName;
    }

    public void setInOutItemName(String inOutItemName) {
        this.inOutItemName = inOutItemName;
    }
}
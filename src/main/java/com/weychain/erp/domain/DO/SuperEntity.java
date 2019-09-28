package com.weychain.erp.domain.DO;


import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class SuperEntity {

    private Long tenantId;

    @TableLogic
    private String deleteFlag = "0";

}

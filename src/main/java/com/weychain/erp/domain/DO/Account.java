package com.weychain.erp.domain.DO;

<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6
import lombok.Data;

import java.math.BigDecimal;

@Data
<<<<<<< HEAD
public class Account extends  SuperEntity {
=======
@TableName("jsh_account")
public class Account  {
>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6

    private Long id;
    private String name;

    private String serialno;

    private BigDecimal initialamount;

    private BigDecimal currentamount;

    private String remark;

    private Boolean isdefault;

<<<<<<< HEAD
=======
    @TableLogic
    private String deleteFlag = "0";

>>>>>>> d55d0fe9e143a7b7fe4f5ca36e71a433c102f9b6




}
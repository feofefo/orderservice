package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
//@TableName("tb_user")
public class User {
//    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    @TableField(select = false)
    private String password;
    private int age;
    @TableField(exist = false)
    private boolean online;
//    @TableLogic(value = "0",delval = "1")
    private  Integer deleted;
    @Version
    private Integer version;
}

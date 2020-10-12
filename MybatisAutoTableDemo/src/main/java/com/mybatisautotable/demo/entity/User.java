package com.mybatisautotable.demo.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

@Data
/*
* 对应数据库表名，如果更改表名需要同步更改数据库表名，不然会重新创建表。
* */
@Table(name = "t_user")
public class User extends SuperEntity {
    @Column
    private String username;
    @Column
    private String password;
}
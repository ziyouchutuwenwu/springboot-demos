CREATE DATABASE test_mybatis;
use test_mybatis;

CREATE TABLE `user` (
    `user_id` INT(11) NOT NULL COMMENT '主键',
    `user_name` VARCHAR(64) NOT NULL COMMENT '姓名',
    `address` VARCHAR(256) NULL DEFAULT NULL COMMENT '地址',
    PRIMARY KEY (`user_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

insert into user(user_id,user_name,address) values(1,"小明","北京市朝阳区望京");
insert into user(user_id,user_name,address) values(2,"小红","北京市东城区东直门");
insert into user(user_id,user_name,address) values(3,"小绿","北京市西城区车公庄");
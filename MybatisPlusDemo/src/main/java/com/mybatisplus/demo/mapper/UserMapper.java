package com.mybatisplus.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 这里直接使用@select或者在xml里面做复杂查询
    // @Select("SELECT * FROM user where name = #{name}")
    List<User> selectByName(@Param("name") String name);
}
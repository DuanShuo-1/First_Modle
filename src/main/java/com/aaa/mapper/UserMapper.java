package com.aaa.mapper;

import com.aaa.entity.User;
import com.aaa.entity.Xiaoliang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {
    @Select("select *from  user where name = #{name} ")
    User findByName(String name);


    @Select("select * from xiaoliang")
    List<Xiaoliang> findxl();
}

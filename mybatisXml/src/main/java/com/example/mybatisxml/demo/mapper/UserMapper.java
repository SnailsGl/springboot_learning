package com.example.mybatisxml.demo.mapper;

import com.example.mybatisxml.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findById(@Param("id") Long id);

    void deleteById(@Param("id") Long id);

}

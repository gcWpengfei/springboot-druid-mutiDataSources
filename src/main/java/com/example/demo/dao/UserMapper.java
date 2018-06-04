package com.example.demo.dao;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

	@Insert("insert user(user_id,user_name) values(#{id},#{userName})")
	void insert(User u);
	
	@Select("select user_id,user_name from user where user_id=#{id} ")
	User findById(@Param("id") String id);

	//注：方法名和要UserMapper.xml中的id一致
	List<User> query(@Param("userName") String userName);
	
}

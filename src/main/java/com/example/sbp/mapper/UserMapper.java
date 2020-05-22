package com.example.sbp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.sbp.domain.User;

@Mapper
public interface UserMapper {
	
	@Select("select userName from USER where userId=#{userId}")
	public String getUserName(@Param("userId") String userId) throws Exception;

	//@Select("select * from USER where userId=#{userId}")
	public User getLoginInfo(@Param("userId") String userId) throws Exception;
}

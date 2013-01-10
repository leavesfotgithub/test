package com.leaves.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.leaves.mybatis.dao.UserMapper;
import com.leaves.mybatis.model.User;

public class TestConnection {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sqlSessionFactory.openSession();

		// 查询
		// List<User> users =
		// session.selectList("com.leaves.mybatis.dao.UserMapper.selectAll");

		// 插入
		User user = new User();
		user.setAccount("你好带球");

		session.getMapper(UserMapper.class).insert(user);

		System.out.println(user.getUserId());

//		session.commit();

	}
}

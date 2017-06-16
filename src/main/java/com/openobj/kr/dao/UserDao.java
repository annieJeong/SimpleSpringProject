package com.openobj.kr.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openobj.kr.model.UserVo;

@Repository
public class UserDao implements UserDaoImpl {
	
	@Autowired
	private SqlSession sqlsession;
	
	private String namespace = "openobj.user";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserVo> getUserList() {
		List<UserVo> usrList = new ArrayList<UserVo>();
		usrList = sqlsession.selectList(namespace+".getUserList");
		UserVo exam = new UserVo(0,"example","example","example","example");
		UserVo user01 = new UserVo(1,"pnumber","username","password","phonenum");
		
		usrList.add(exam);
		usrList.add(user01);
		
		return usrList;
	}

}

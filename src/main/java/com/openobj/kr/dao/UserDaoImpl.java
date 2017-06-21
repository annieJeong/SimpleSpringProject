package com.openobj.kr.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.openobj.kr.model.UserVo;

@Repository
public interface UserDaoImpl {
//	public List<UserVo> getUserList();
	public List<UserVo> getUserList(HashMap<String,String> scope);
	public void userInsert(UserVo user);
	public void userDelete(int idx);
	public UserVo getUser(int idx);
	public void userUpdt(UserVo user);
	public int getUserCnt();
}

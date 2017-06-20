package com.openobj.kr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openobj.kr.model.UserVo;

@Repository
public interface UserDaoImpl {
	public List<UserVo> getUserList();
	public void userInsert(UserVo user);
	public void userDelete(int idx);
}

package com.openobj.kr.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openobj.kr.model.UserVo;

@Service
public interface UserSrvcImpl {
//	public List<UserVo> getUserList();
	public List<UserVo> getUserList(HashMap<String, String> scope);
	public void userInsert(UserVo user);
	public void userDelete(List<String> idx);
	public UserVo getUser(int idx);
	public void userUpdt(UserVo user);
	public int getUserCnt();
	public boolean userChk(String id, String pw);
	public UserVo getUserAfter(String id, String pw);
}

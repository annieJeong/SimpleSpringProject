package com.openobj.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openobj.kr.dao.UserDao;
import com.openobj.kr.model.UserVo;

@Service
public class UserSrvc implements UserSrvcImpl {

	@Autowired
	private UserDao usrDao = new UserDao();
	
	@Override
	public List<UserVo> getUserList() {
		return usrDao.getUserList();
	}

}

package com.openobj.kr.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openobj.kr.controller.HomeController;
import com.openobj.kr.dao.UserDao;
import com.openobj.kr.model.UserVo;

@Service
public class UserSrvc implements UserSrvcImpl {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserDao usrDao = new UserDao();
	
	@Override
	public List<UserVo> getUserList() {
		return usrDao.getUserList();
	}

	@Override
	public void userInsert(UserVo user) {
		// TODO Auto-generated method stub
		usrDao.userInsert(user);
	}

	@Override
	public void userDelete(List<String> idx) {
		// TODO Auto-generated method stub
		for(int i=0; i<idx.size(); i++){
			logger.debug("userDelete"+idx.get(i));
			usrDao.userDelete( Integer.parseInt(idx.get(i)) );
		}
	}

}

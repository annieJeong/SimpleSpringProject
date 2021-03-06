package com.openobj.kr.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openobj.kr.controller.UserController;
import com.openobj.kr.dao.UserDao;
import com.openobj.kr.dao.UserDaoImpl;
import com.openobj.kr.model.UserVo;

@Service
public class UserSrvc implements UserSrvcImpl {

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDaoImpl usrDao = new UserDao();
	
	@Override
	public List<UserVo> getUserList(HashMap<String, String> scope) {
		return usrDao.getUserList(scope);
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

	@Override
	public UserVo getUser(int idx) {
		// TODO Auto-generated method stub
		return usrDao.getUser(idx);
	}

	@Override
	public void userUpdt(UserVo user) {
		// TODO Auto-generated method stub
		usrDao.userUpdt(user);
	}

	@Override
	public int getUserCnt() {
		// TODO Auto-generated method stub
		return usrDao.getUserCnt();
	}

	@Override
	public boolean userChk(String id, String pw) {
		// TODO Auto-generated method stub
		UserVo user = new UserVo();
		user.setID(id);
		
		String chkPwd = usrDao.getUserPw(user);
		
		logger.info("userChk : input password :" + pw + "/ DB password :" + chkPwd);
		if ( chkPwd != null && chkPwd.equals(pw)){
			return true;
		}
		return false;
	}

	@Override
	public UserVo getUserAfter(String id, String pw) {
		UserVo setUser = new UserVo();
		
		setUser.setID(id);
		setUser.setPASSWORD(pw);
		
		UserVo resultUser = usrDao.getUserAfter(setUser);
		
		return resultUser;
	}
}

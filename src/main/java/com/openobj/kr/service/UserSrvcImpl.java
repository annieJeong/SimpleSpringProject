package com.openobj.kr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openobj.kr.model.UserVo;

@Service
public interface UserSrvcImpl {
	public List<UserVo> getUserList();
}
package com.openobj.kr.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.openobj.kr.model.UserVo;
import com.openobj.kr.service.UserSrvc;
import com.openobj.kr.service.UserSrvcImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserSrvcImpl usrSrvc = new UserSrvc();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * 메인 Page
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/user")
	public ModelAndView userListPage(){
		logger.info("usermain");
		ModelAndView mav = new ModelAndView("/user/main");
		//0621 페이징 처리 추가
		HashMap<String, String> scope = new HashMap<String, String>();
		scope.put("minNum", "0");
		scope.put("maxNum", "10");
		mav.addObject("userList", usrSrvc.getUserList(scope));
		//count 추가
		mav.addObject("idx",getUserPageCnt());
		return mav;
	}
	
	/**
	 * 페이징 처리 기능추가
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/user.ajax", method=RequestMethod.GET)
	public ModelAndView userListPageAjax(
			@RequestParam("page") int page
			){
		ModelAndView mav = new ModelAndView("/user/main");
		int min = 0, max=0;
		
		max = page*10;
		min = max-10;
		
		HashMap<String, String> scope = new HashMap<String, String>();
		scope.put("minNum", min+"");
		scope.put("maxNum", max+"");
		mav.addObject("userList", usrSrvc.getUserList(scope));
		//count 추가
		mav.addObject("idx",getUserPageCnt());
		return mav;
	}
	
	/**
	 * 페이지 카운트 계산
	 * @return int
	 */
	private int getUserPageCnt(){
		int pageCnt = usrSrvc.getUserCnt();
		double ceilVal = (double)pageCnt/10;
		pageCnt = (int) Math.ceil(ceilVal);
		
		return pageCnt;
	}
	
	/**
	 * 추가 Page
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/user/insert")
	public ModelAndView userInsertPage(){
		logger.info("newbi Insert page");
		ModelAndView mav = new ModelAndView("/user/insert");
		
		return mav;
	}
	
	/**
	 * 추가 AJAX
	 * @param pNumber
	 * @param userName
	 * @param passWord
	 * @param phoneNum
	 * @return Map<String,String>
	 */
	@RequestMapping(value = "/user/insert.ajax", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> userInsert(
			@RequestParam("pNumber") String pNumber,
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord,
			@RequestParam("phoneNum") String phoneNum
			){
		logger.info("newbi Insert ajax:"+pNumber+"/"+userName+"/"+passWord+"/"+phoneNum);
		Map<String,String> resData = new HashMap<String,String>();
		try{
			UserVo user = new UserVo(pNumber, userName, passWord, phoneNum);
			
			usrSrvc.userInsert(user);
			
			resData.put("result","success");
		} catch(Exception e){
			e.printStackTrace();
			resData.put("result","fail");
		}
		return resData;
	}
	
	/***
	 * 삭제 AJAX
	 * @param idx
	 * @return Map<String,String>
	 */
	@RequestMapping(value = "/user/del.ajax", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> userDel( @RequestParam("index[]") List<String> idx){
		logger.info("delete ajax : "+idx);
		//idx만큼 delete되어야함.
		Map<String,String> resData = new HashMap<String,String>();
		try{
			usrSrvc.userDelete(idx);
			
			resData.put("result","success");
		}catch(Exception e){
			resData.put("result","fail");
		}
		return resData;
	}
	
	/**
	 * 상세페이지 
	 * @param idx
	 * @return ModelAndView
	 */
	@RequestMapping(value="/user/detail", method=RequestMethod.GET)
	public ModelAndView userDetail( @RequestParam("index") String idx){
		ModelAndView mav = new ModelAndView("/user/detail");
		
		// 1명 조회 -> UserVo add
		UserVo user = usrSrvc.getUser(Integer.parseInt(idx));
		mav.addObject("user",user);
		return mav;
	}
	
	/***
	 * 삭제 AJAX
	 * @param idx
	 * @return Map<String,String>
	 */
	@RequestMapping(value = "/user/update.ajax", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> userUpdt(
			@RequestParam("index") String idx,
			@RequestParam("pNumber") String pNumber,
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord,
			@RequestParam("phoneNum") String phoneNum
			){
		logger.info("update ajax : "+idx);
		//idx만큼 delete되어야함.
		Map<String,String> resData = new HashMap<String,String>();
		try{
			UserVo user = new UserVo(Integer.parseInt(idx),pNumber,userName,passWord,phoneNum);
			
			usrSrvc.userUpdt(user);
			
			resData.put("result","success");
		}catch(Exception e){
			e.printStackTrace();
			resData.put("result","fail");
		}
		return resData;
	}
}
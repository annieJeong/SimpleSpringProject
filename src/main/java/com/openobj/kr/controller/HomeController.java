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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserSrvc usrSrvc = new UserSrvc();
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
	
	@RequestMapping(value = "/user")
	public ModelAndView userListPage(){
		logger.info("usermain");
		ModelAndView mav = new ModelAndView("/user/main");
		mav.addObject("userList", usrSrvc.getUserList());
		
		return mav;
	}
	
	@RequestMapping(value = "/user/insert")
	public ModelAndView userInsertPage(){
		logger.info("newbi Insert page");
		ModelAndView mav = new ModelAndView("/user/insert");
		
		return mav;
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/user/insert/ajax", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> userInsert(
			@RequestParam("pNumber") String pNumber,
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord,
			@RequestParam("phoneNum") String phoneNum
			){
		logger.info("newbi Insert ajax"+pNumber+"/"+userName+"/"+passWord+"/"+phoneNum);
		Map<String,String> resData = new HashMap<String,String>();
		try{
			UserVo user = new UserVo((Integer) null, pNumber, userName, passWord, phoneNum);
			
			usrSrvc.userInsert(user);
			
			resData.put("result","success");
		} catch(Exception e){
			resData.put("result","fail");
		}
		return resData;
	}
	@RequestMapping(value = "/user/del.ajax", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> userDel( @RequestParam("index[]") List<String> idx){
		logger.info("delete ajax"+idx);
		logger.info(idx.get(0)+"/");
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
}

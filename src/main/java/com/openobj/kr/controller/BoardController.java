package com.openobj.kr.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.openobj.kr.model.BoardVo;
import com.openobj.kr.service.BoardSrvc;
import com.openobj.kr.service.BoardSrvcImpl;

@Controller
public class BoardController {
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private BoardSrvcImpl boardSrvc = new BoardSrvc();
	
	@RequestMapping(value="/board")
	public ModelAndView boardListPage(){
		logger.info("boardListPage");
		ModelAndView mav = new ModelAndView("/board/list");
		mav.addObject("board",boardSrvc.getBoardList());
		mav.addObject("boardCnt",boardSrvc.getBoardCnt());
		
		return mav;
	}
	
	@RequestMapping(value="/board/insert")
	public ModelAndView boardInsertPage(){
		logger.info("boardInsertPage");
		return new ModelAndView("/board/insert");
	}
	
	@RequestMapping(value="/board/insert.ajax", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> boardInsertAjax(
			@RequestParam("title") String title,
			@RequestParam("txt") String txt,
			@RequestParam("user") String user
			){
		logger.info("boardInsertAjax");
		Map<String,String> result = new HashMap<String,String>();
		try {
			boardSrvc.boardInsert(title,txt,user);
			result.put("result", "success");
		} catch (Exception e){
			e.printStackTrace();
			result.put("result", "fail");
		}
		return result;
	}
	
	@RequestMapping(value="/board/update.ajax", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> boardUpdtAjax(
			@RequestParam("idx") String idx, 
			@RequestParam("title") String title,
			@RequestParam("txt") String txt
			){
		logger.info("boardUpdtAjax");
		Map<String,String> result = new HashMap<String,String>();
		try{
			boardSrvc.boardUpdt(idx, title, txt, "admin");
			result.put("result", "success");
		}catch(Exception e){
			e.printStackTrace();
			result.put("result", "success");
		}
		return result;
	}
	
	@RequestMapping(value="/board/delete.ajax", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> boardDelAjax( @RequestParam("idx") String idx){
		logger.info("boardDelAjax");
		Map<String,String> result = new HashMap<String,String>();
		try {
			boardSrvc.boardDelete(idx);
			result.put("result", "success");
		} catch (Exception e){
			e.printStackTrace();
			result.put("result", "fail");
		}
		return result;
	}
	
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public ModelAndView boardDetailPage( @RequestParam("idx") String idx){
		logger.info("boardDetailPage");
		ModelAndView mav = new ModelAndView("/board/detail");
		BoardVo addBoard = boardSrvc.getBoard(idx);
		
		mav.addObject("board", addBoard);
		return mav;
	}
}

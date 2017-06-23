package com.openobj.kr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openobj.kr.model.BoardVo;

@Service
public interface BoardSrvcImpl {
	public List<BoardVo> getBoardList();
	public BoardVo getBoard(String idx);
	public int getBoardCnt();
	public void boardInsert(String title, String txt, String admin);
	public void boardDelete(String idx);
	public void boardUpdt(String idx, String title, String txt, String admin);
}

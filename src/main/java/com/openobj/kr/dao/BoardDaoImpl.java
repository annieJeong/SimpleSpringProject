package com.openobj.kr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openobj.kr.model.BoardVo;

@Repository
public interface BoardDaoImpl {
	public List<BoardVo> getBoardList();
	public BoardVo getBoard(int idx);
	public int getBoardCnt();
	public void boardInsert(BoardVo board);
  	public void delBoard(BoardVo board);
  	public void boardUpdt(BoardVo board);
}
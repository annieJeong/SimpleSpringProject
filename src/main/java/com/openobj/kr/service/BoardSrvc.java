package com.openobj.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openobj.kr.dao.BoardDao;
import com.openobj.kr.dao.BoardDaoImpl;
import com.openobj.kr.model.BoardVo;

@Service
public class BoardSrvc implements BoardSrvcImpl {

	@Autowired
	private BoardDaoImpl boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> getBoardList() {
		return boardDao.getBoardList();
	}
	
	@Override
	public BoardVo getBoard(String idx){
		return boardDao.getBoard(Integer.parseInt(idx));
	}

	@Override
	public int getBoardCnt() {
		// TODO Auto-generated method stub
		return boardDao.getBoardCnt();
	}

	@Override
	public void boardInsert(String title, String txt, String admin) {
		// TODO Auto-generated method stub
		BoardVo board = new BoardVo();
		
		board.setBOARD_TITLE(title);
		board.setBOARD_STR(txt);
		board.setBOARD_USRNAME(admin);
		
		boardDao.boardInsert(board);
	}

	@Override
	public void boardDelete(String idx) {
		// TODO Auto-generated method stub
		boardDao.delBoard(Integer.parseInt(idx));
	}

	@Override
	public void boardUpdt(String idx, String title, String txt, String admin) {
		// TODO Auto-generated method stub
		BoardVo board = new BoardVo();
		
		board.setBOARD_IDX(Integer.parseInt(idx));
		board.setBOARD_TITLE(title);
		board.setBOARD_STR(txt);
		board.setBOARD_USRNAME(admin);

		boardDao.boardUpdt(board);
	}

}

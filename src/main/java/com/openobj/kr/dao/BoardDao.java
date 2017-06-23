package com.openobj.kr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openobj.kr.model.BoardVo;

@Repository
public class BoardDao implements BoardDaoImpl {
	
	@Autowired
	private SqlSession sqlsession;
	
	private String namespace = "openobj.board";
	
	@Override
	public List<BoardVo> getBoardList() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".getBoardList");
	}

	@Override
	public BoardVo getBoard(int idx) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".getBoard", idx);
	}

	@Override
	public int getBoardCnt() {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".getBoardCnt");
	}

	public void boardInsert(BoardVo board){
		sqlsession.insert(namespace+".boardInsert", board);
	}
	
	public void delBoard(int idx){
		sqlsession.delete(namespace+".boardDelete", idx);
	}

	@Override
	public void boardUpdt(BoardVo board) {
		// TODO Auto-generated method stub
		sqlsession.update(namespace+".boardUpdt", board);
	}

}

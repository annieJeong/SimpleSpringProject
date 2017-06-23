package com.openobj.kr.model;

public class BoardVo {
	private int BOARD_IDX;
	private String BOARD_TITLE;
	private String BOARD_STR;
	private String BOARD_SETDATE;
	private String BOARD_UPDATE;
	private String BOARD_USRNAME;
	
	public BoardVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "BoardVo [BOARD_IDX=" + BOARD_IDX + ", BOARD_TITLE=" + BOARD_TITLE + ", BOARD_STR=" + BOARD_STR
				+ ", BOARD_SETDATE=" + BOARD_SETDATE + ", BOARD_UPDATE=" + BOARD_UPDATE + ", BOARD_USRNAME="
				+ BOARD_USRNAME + "]";
	}

	public BoardVo(int bOARD_IDX, String bOARD_TITLE, String bOARD_STR, String bOARD_SETDATE, String bOARD_UPDATE,
			String bOARD_USRNAME) {
		super();
		BOARD_IDX = bOARD_IDX;
		BOARD_TITLE = bOARD_TITLE;
		BOARD_STR = bOARD_STR;
		BOARD_SETDATE = bOARD_SETDATE;
		BOARD_UPDATE = bOARD_UPDATE;
		BOARD_USRNAME = bOARD_USRNAME;
	}

	public BoardVo(String bOARD_TITLE, String bOARD_STR, String bOARD_SETDATE, String bOARD_UPDATE,
			String bOARD_USRNAME) {
		super();
		BOARD_TITLE = bOARD_TITLE;
		BOARD_STR = bOARD_STR;
		BOARD_SETDATE = bOARD_SETDATE;
		BOARD_UPDATE = bOARD_UPDATE;
		BOARD_USRNAME = bOARD_USRNAME;
	}
	
	public int getBOARD_IDX() {
		return BOARD_IDX;
	}
	public void setBOARD_IDX(int bOARD_IDX) {
		BOARD_IDX = bOARD_IDX;
	}
	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}
	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}
	public String getBOARD_STR() {
		return BOARD_STR;
	}
	public void setBOARD_STR(String bOARD_STR) {
		BOARD_STR = bOARD_STR;
	}
	public String getBOARD_SETDATE() {
		return BOARD_SETDATE;
	}
	public void setBOARD_SETDATE(String bOARD_SETDATE) {
		BOARD_SETDATE = bOARD_SETDATE;
	}
	public String getBOARD_UPDATE() {
		return BOARD_UPDATE;
	}
	public void setBOARD_UPDATE(String bOARD_UPDATE) {
		BOARD_UPDATE = bOARD_UPDATE;
	}
	public String getBOARD_USRNAME() {
		return BOARD_USRNAME;
	}
	public void setBOARD_USRNAME(String bOARD_USRNAME) {
		BOARD_USRNAME = bOARD_USRNAME;
	}
}

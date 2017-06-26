package com.openobj.kr.model;

public class UserVo {
	
	private int index;
	private String ID;
	private String PNUMBER;
	private String USERNAME;
	private String PASSWORD;
	private String PHONENUM;
	
	public UserVo(String iD, String pNUMBER, String uSERNAME, String pASSWORD, String pHONENUM) {
		ID = iD;
		PNUMBER = pNUMBER;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		PHONENUM = pHONENUM;
	}
	
	public UserVo(int index, String iD, String pNUMBER, String uSERNAME, String pASSWORD, String pHONENUM) {
		this.index = index;
		ID = iD;
		PNUMBER = pNUMBER;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		PHONENUM = pHONENUM;
	}
	
	public void clearData(){
		this.index = 0;
		ID = "";
		PNUMBER = "";
		USERNAME = "";
		PASSWORD = "";
		PHONENUM = "";
	}
	
	public UserVo() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	public String getPNUMBER() {
		return PNUMBER;
	}
	public void setPNUMBER(String pNUMBER) {
		PNUMBER = pNUMBER;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPHONENUM() {
		return PHONENUM;
	}
	public void setPHONENUM(String pHONENUM) {
		PHONENUM = pHONENUM;
	}
	
}

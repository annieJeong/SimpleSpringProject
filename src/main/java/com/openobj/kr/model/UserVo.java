package com.openobj.kr.model;

public class UserVo {
	
	private int index;
	private String PNUMBER;
	private String USERNAME;
	private String PASSWORD;
	private String PHONENUM;
	
	public UserVo(String pNUMBER, String uSERNAME, String pASSWORD, String pHONENUM) {
		PNUMBER = pNUMBER;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		PHONENUM = pHONENUM;
	}
	
	public UserVo(int index, String pNUMBER, String uSERNAME, String pASSWORD, String pHONENUM) {
		this.index = index;
		PNUMBER = pNUMBER;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
		PHONENUM = pHONENUM;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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

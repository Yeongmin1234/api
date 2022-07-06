package org.zerock.domain;


public class UserVO {
	
	private int UserNo;
	
	private String Name;
//	
//	private String Phone;
//	
//	private String Email;
//	
//	private Boolean UseYn;
//	
//	private int RegUser;
//
//	private int UpdtUser;
//
//	private Date RegDate;
//
//	private Date UpdtDate;
	//gd_user
//====================================
	//gd_user_detail
	private String id;
//	
//	private String englishName;
//	
//	private String chinaName;
	public int getUserNo() {
		return UserNo;
	}
	public void setUserNo(int userNo) {
		UserNo = userNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserVO [UserNo=" + UserNo + ", Name=" + Name + ", id=" + id + "]";
	}
}

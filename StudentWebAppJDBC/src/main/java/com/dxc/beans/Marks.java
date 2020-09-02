package com.dxc.beans;

public class Marks {
	int studentid;
	int examid;
	int sub1;
	int sub2;
	int sub3;
	public Marks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Marks(int studentid, int examid, int sub1, int sub2, int sub3) {
		super();
		this.studentid = studentid;
		this.examid = examid;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	@Override
	public String toString() {
		return "Marks [studentid=" + studentid + ", examid=" + examid + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3="
				+ sub3 + "]";
	}
	
	
	

}

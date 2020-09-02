package com.dxc.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable ,Comparable<Student>{
int id;
String name;
Date dob;
String email;
String mobile;



public Student() {
	super();
	// TODO Auto-generated constructor stub
}


public Student(int id, String name, String dobth, String email, String mobile) throws ParseException {
	super();
	this.id = id;
	this.name = name;
	
		SimpleDateFormat date= new SimpleDateFormat("dd-MM-yyyy");
		dob =date.parse(dobth);
	
	this.email = email;
	this.mobile = mobile;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}


@Override
public String toString() {
	String dobth = new SimpleDateFormat("dd-MM-YYYY").format(dob);
	return "Student [id=" + id + ", name=" + name + ", dob=" + dobth + ", email=" + email + ", mobile=" + mobile + "]";
}
public String toCSV() {
	String dobth = new SimpleDateFormat("dd-MM-YYYY").format(dob);
	return id+","+name+","+dobth+","+email+","+mobile;
}

public static Student parseStudent(String csvStudent) throws ParseException {
	String[] vals = csvStudent.split(",");
	int id = Integer.parseInt(vals[0]);
	String name = vals[1];
	String dobth = vals[2];
	String email = vals[3];
	String mobile = vals[4];
	
	Student student = new Student(id, name, dobth, email, mobile); 
	
	return student;
	
}
@Override
public int compareTo(Student o) {
	// TODO Auto-generated method stub
	return 0;
}



}





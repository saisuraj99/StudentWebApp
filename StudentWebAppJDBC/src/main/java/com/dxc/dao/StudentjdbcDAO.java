package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.dxc.beans.Student;
import com.dxc.util.ConnectionManager;

public class StudentjdbcDAO extends JdbcDAO implements DAO<Student> {

	public StudentjdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Student student) throws Exception {
		boolean res = false;
		String sql = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, student.getId());
		pstmt.setString(2, student.getName());
		pstmt.setDate(3, new Date(student.getDob().getTime()));
		pstmt.setString(4, student.getEmail());
		pstmt.setString(5, student.getMobile());
		int n = pstmt.executeUpdate();
		con.commit();
		if (n == 1) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean edit(Student student) throws Exception {
		boolean res = false;
		

		String sql = "update student set name =?,dobth=?,email=?,mobile=? where id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(5, student.getId());
		pstmt.setString(1, student.getName());
		pstmt.setDate(2, new Date(student.getDob().getTime()));
		pstmt.setString(3, student.getEmail());
		pstmt.setString(4, student.getMobile());

		int n = pstmt.executeUpdate();
		con.commit();
		con.close();
		if (n == 1) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean res = false;
		String sql = "delete from student where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int n = pstmt.executeUpdate();
		con.commit();
		if (n == 1) {
			res = true;
		}
		return res;
	}

	@Override
	public Student find(int id) throws Exception {
		Student student = null;

		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "select * from student where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			con.commit();
			if (rs.next()) {
				String name = rs.getNString(2);
				java.util.Date date = rs.getDate(3);
				String dobth = new SimpleDateFormat("dd-MM-YYYY").format(date);
				String email = rs.getString(4);
				String mobile = rs.getString(5);
				student = new Student(id, name, dobth, email, mobile);
			}
		} finally {
			con.close();
		}

		return student;
	}

	@Override
	public ArrayList<Student> findAll() throws Exception {
		ArrayList<Student> students = new ArrayList<>();

		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			String sql = "select * from student";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getNString(2);
				java.util.Date date = rs.getDate(3);
				String dobth = new SimpleDateFormat("dd-MM-yyyy").format(date);
				String email = rs.getString(4);
				String mobile = rs.getString(5);

				Student stdnt = new Student(id, name, dobth, email, mobile);

				students.add(stdnt);
			}
		} finally {
			con.close();
		}

		return students;
	}

}

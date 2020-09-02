package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dxc.beans.Exam;
import com.dxc.util.ConnectionManager;

public class ExamJdbcDAO extends JdbcDAO implements DAO<Exam> {

	public ExamJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Exam e) throws Exception {
		// TODO Auto-generated method stub
		boolean res = false;
			PreparedStatement pstmt = con.prepareStatement("insert into exam values(?,?)");
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getName());
			if (pstmt.executeUpdate() == 1) {
				res = true;
			}
		
		return res;
	}

	@Override
	public boolean edit(Exam e) throws Exception {
		boolean res = false;
		
			PreparedStatement pstmt = con.prepareStatement("update exam set name = ? where id=?");
			pstmt.setInt(2, e.getId());
			pstmt.setString(1, e.getName());
			if (pstmt.executeUpdate() == 1) {
				res = true;
			}
		
		return res;
	}

	@Override
	public Exam find(int id) throws Exception {
		Exam e = null;
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			PreparedStatement pstmt = con.prepareStatement("select * from exam where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString(2);
				e = new Exam(id, name);
			}
		} finally {
			con.close();
		}
		return e;
	}

	@Override
	public boolean delete(int id) throws Exception {
		boolean res = false;
		
			PreparedStatement pstmt = con.prepareStatement("delete from exam where id =" + id);
			if (pstmt.executeUpdate() == 1) {
				res = true;
			}
		
		return res;
	}

	@Override
	public ArrayList<Exam> findAll() throws Exception {
		ArrayList<Exam> exams = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from exam");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Exam e = new Exam(id, name);
				exams.add(e);
			}
		} finally {
			con.close();
		}
		return exams;
	}

	

}

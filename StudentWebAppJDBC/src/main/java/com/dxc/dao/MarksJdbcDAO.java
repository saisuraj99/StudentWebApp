package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dxc.beans.Marks;
import com.dxc.util.ConnectionManager;

public class MarksJdbcDAO extends JdbcDAO implements DAO<Marks> {
	

	public MarksJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Marks m) throws Exception {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("insert into exam values(?,?,?,?,?)");
		pstmt.setInt(1, m.getStudentid());
		pstmt.setInt(2, m.getExamid());
		pstmt.setInt(3, m.getSub1());
		pstmt.setInt(3, m.getSub2());
		pstmt.setInt(5, m.getSub3());
		if(pstmt.executeUpdate()==1) {
			res=true;
		}
		return res;
	}

	@Override
	public boolean edit(Marks m) throws Exception {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("update marks set sub1=?,sub2=?,sub3=? where studentid=? && examid=?");
		pstmt.setInt(1, m.getStudentid());
		pstmt.setInt(2, m.getExamid());
		pstmt.setInt(3, m.getSub1());
		pstmt.setInt(3, m.getSub2());
		pstmt.setInt(5, m.getSub3());
		if(pstmt.executeUpdate()==1) {
			res=true;
		}
			return res;
	}


	@Override
	public ArrayList<Marks> findAll() throws Exception {
		ArrayList<Marks> marks = new ArrayList<>();
		Marks m =null;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from marks");
		while(rs.next()) {
			int studentid = rs.getInt(1);
			int examid = rs.getInt(2);
			int sub1 = rs.getInt(3);
			int sub2 = rs.getInt(4);
			int sub3 = rs.getInt(5);	
			m= new Marks(studentid, examid, sub1, sub2, sub3);
			marks.add(m);
		}
		return null;
	}

	@Override
	public Marks find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int studentid, int examid) throws Exception {
		boolean res = false;
		PreparedStatement pstmt= con.prepareStatement("delete from marks where studentid ="+studentid+" &&  examid = "+examid);
		if(pstmt.executeUpdate()==1) {
			res= true;
		}
		return res;
	}

	public Marks find(int studentid, int examid) throws Exception {
		Marks m = null;
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
		
		PreparedStatement pstmt = con.prepareStatement("select * from marks where studentid=? && examid=?");
		pstmt.setInt(1, studentid);
		pstmt.setInt(2, examid);
		
		ResultSet rs =  pstmt.executeQuery();
		if(rs.next()) {
			int sub1 = rs.getInt(3);
			int sub2 = rs.getInt(4);
			int sub3 = rs.getInt(5);
			m= new Marks(studentid, examid, sub1, sub2, sub3);
		}}
		finally {
			con.close();
		}
		return m;
	}

	

}

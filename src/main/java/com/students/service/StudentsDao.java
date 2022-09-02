package com.students.service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.students.dbutil.JDBCConnection;
import com.students.model.Students;

public class StudentsDao {
	
	Connection con= new JDBCConnection().getDBConnection();
	
	public void saveStudents(Students s){
		try {
			
			
			PreparedStatement smt=con.prepareStatement("INSERT INTO Students(rollno,first_name,last_name,phone_no) values(?,?,?,?)");
			smt.setString(1, s.getRollno());
			smt.setString(2, s.getFirst_name());
			smt.setString(3, s.getLast_name());
			smt.setString(4, s.getPhone_no());
			smt.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		 
		 
	}
	
	public List<Students> getStudents() {
		
		List<Students> lt =new ArrayList<Students>();
		try {
			
		java.sql.Statement smt=con.createStatement();
		ResultSet rs= smt.executeQuery("select id, rollno, first_name, last_name, phone_no from students");
		while (rs.next()) {
			Students st = new Students();
			st.setId(rs.getInt("id"));
			st.setRollno(rs.getString("rollno"));
			st.setFirst_name(rs.getString("first_name"));
			st.setLast_name(rs.getString("last_name"));
			st.setPhone_no(rs.getString("phone_no"));
			lt.add(st);
			
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		return lt;
	
	}	
	
	public Students getStudent(int studentId) {
		Students st=new Students();
		try {
			java.sql.Statement smt=con.createStatement();
			ResultSet rs= smt.executeQuery("select id, rollno, first_name, last_name, phone_no from students where id="+studentId);
			while(rs.next()) {
				st.setId(rs.getInt("id"));
				st.setRollno(rs.getString("rollno"));
				st.setFirst_name(rs.getString("first_name"));
				st.setLast_name(rs.getString("last_name"));
				st.setPhone_no(rs.getString("phone_no"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return st;
		
	}
	
	
	public void deleteStudent(int studentId) {
		Students st=new Students();
		try {
			java.sql.Statement smt=con.createStatement();
			smt.executeUpdate("delete from students where id="+studentId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void updateStudent(Students updateStudent) {
		try {
			java.sql.Statement smt=con.createStatement();
			smt.executeUpdate("update students set rollno='"+updateStudent.getRollno()+"', first_name='"+updateStudent.getFirst_name()+"', last_name='"+updateStudent.getLast_name()+"', phone_no='"+updateStudent.getPhone_no()+"' where id="+updateStudent.getId());

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
}
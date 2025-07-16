package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.pentagon.studentapp.connection.Connector;
import in.ps.Studentapp.dto.Student;

public class Studentimpl implements StudentDAO{
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
	String query1="select * from student where mail=? and password=? ";
	public Studentimpl(){
		con=Connector.getConnection();
		
	}
	

	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		int res;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLoc());
			ps.setString(6,s.getPassword());
			res=ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE ID=?";
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6,s.getPassword());
			ps.setInt(7,s.getId());
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
			
		}	
	}

	@Override
	public Student getStudent(String mail, String password) {
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail); 
			ps.setString(2, password); 
			ResultSet rs=ps.executeQuery(); 
			   while(rs.next()) { 
				    s=new Student(); 
				    s.setId(rs.getInt("id")); 
				    s.setName(rs.getString("name")); 
				    s.setPhone(rs.getLong("phone")); 
				    s.setMail(rs.getString("mail")); 
				    s.setBranch(rs.getString("branch")); 
				    s.setLoc(rs.getString("location")); 
				    s.setPassword(rs.getString("password")); 
				    s.setDate(rs.getString("date")); 
				   } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
		PreparedStatement ps=null; 
		  String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?"; 
		  Student s=null; 
		  try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone); 
			ps.setString(2, mail); 
			   ResultSet rs=ps.executeQuery(); 
			   while(rs.next()) { 
			    s=new Student(); 
			    s.setId(rs.getInt("id")); 
			    s.setName(rs.getString("name")); 
			    s.setPhone(rs.getLong("phone")); 
			    s.setMail(rs.getString("mail")); 
			    s.setBranch(rs.getString("branch")); 
			    s.setLoc(rs.getString("location")); 
			    s.setPassword(rs.getString("password")); 
			    s.setDate(rs.getString("date")); 
			   } 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public ArrayList<Student> getStudent() {
		PreparedStatement ps=null; 
		  ArrayList<Student> studentsList=new ArrayList<Student>(); 
		  Student s=null; 
		  String query="SELECT * FROM STUDENT WHERE ID!=1"; 
		  try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery(); 
			   while(rs.next()) { 
			    s=new Student(); 
			    s.setId(rs.getInt("id")); 
			    s.setName(rs.getString("name")); 
			    s.setPhone(rs.getLong("phone")); 
			    s.setMail(rs.getString("mail")); 
			    s.setBranch(rs.getString("branch")); 
			    s.setLoc(rs.getString("location")); 
			    s.setPassword(rs.getString("password")); 
			    s.setDate(rs.getString("date")); 
			    studentsList.add(s); 
			   } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return studentsList;
	}


	@Override
	public boolean deleteStudent(int id) {
		String query="DELETE FROM STUDENT WHERE ID=? AND ID!=8";
		
		return true;
	}


	@Override
	public ArrayList<Student> getStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

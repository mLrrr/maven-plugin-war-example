package student.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sports.connection.ConnectionManager;
import student.model.Student;

public class StudentDAO {

	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static Statement stmt=null;
	private static String name,programmename, programmecode, sql;
	private static int sid, id; 

	//get all student
	public static List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement  
			sql = "SELECT * FROM student ORDER BY sid";
			stmt = con.createStatement();

			//4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt("sid"));
				student.setName(rs.getString("name"));
				student.setProgrammecode(rs.getString("programmecode"));
				student.setProgrammename(rs.getString("programmename"));
				student.setId(rs.getInt("id"));
				students.add(student);
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return students;
	}

	//get student by sid
	public static Student getStudentById(int sid) {
		Student student = new Student();
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();

			//3. create statement  
			sql = "SELECT * FROM student WHERE sid='"+sid+"'";
			stmt = con.createStatement();

			//4. execute query
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	            
				student.setSid(rs.getInt("sid"));
				student.setName(rs.getString("name"));
				student.setProgrammecode(rs.getString("programmecode"));
				student.setProgrammename(rs.getString("programmename"));
				student.setId(rs.getInt("id"));
			}
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();

		}

		return student;
	}

	//get student by id
	public static Student getStudentId(int id) {
		Student student = new Student();
		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();

			//3. create statement  
			sql = "SELECT * FROM student WHERE id='"+id+"'";
			stmt = con.createStatement();

			//4. execute query
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	            
				student.setSid(rs.getInt("sid"));	
				student.setName(rs.getString("name"));
				student.setProgrammecode(rs.getString("programmecode"));
				student.setProgrammename(rs.getString("programmename"));
				student.setId(rs.getInt("id"));
			}
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return student;
	}

	//update student
	public void updateStudent(Student bean) {

		sid = bean.getSid();
		name = bean.getName();
		programmecode = bean.getProgrammecode();
		programmename = bean.getProgrammename();
	
		

		try {
			//call getConnection() method  
			con = ConnectionManager.getConnection();

			//3. create statement  
			sql = "UPDATE student SET name=?, programmecode=?,programmename=? WHERE sid=?";
			ps=con.prepareStatement(sql); 		
			ps.setString(1, name);	
			ps.setString(2, programmecode);	
			ps.setString(3, programmename);	
			ps.setInt(4,sid);

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();

		}
	}
}

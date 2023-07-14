package student.dao;



import java.security.*;
import java.sql.*;
import java.util.*;

import sports.connection.ConnectionManager;
import student.model.Users;

public class UserDAO {

	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static Statement stmt=null;
	private static String email, password, role, sql;
	private static int id;

	//login
	public static Users login(Users bean) throws NoSuchAlgorithmException{
		//get email and password
		email = bean.getEmail();
		password = bean.getPassword();

		//convert the password to MD5
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		try {
		      //call getConnection() method 
		      con = ConnectionManager.getConnection();
		      
		      //3. create statement
		      sql = "SELECT * FROM users WHERE email='" + email + "' AND password='" + sb.toString() + "'";
		      stmt = con.createStatement();
		      
		        //4. execute query
		      rs = stmt.executeQuery(sql);

		      // if user exists set the isValid variable to true
		      if (rs.next()) {
		        bean.setId(rs.getInt("id"));
		        bean.setEmail(rs.getString("email"));
		        bean.setRole(rs.getString("role"));
		        System.out.println("email form : "+ email + "|| email db : " + rs.getString("email"));
		        System.out.println("password form : "+ sb.toString() + "|| password db : " + rs.getString("password"));
		        bean.setValid(true);
		      }
		      // if user does not exist set the isValid variable to false
		      else{
		        bean.setValid(false);
		      }

		      //5. close connection
		      con.close();
		    }catch(Exception e) {
		      e.printStackTrace();    
		    }

		    return bean;
		  }

	//add new user (register)
	public void add(Users bean) throws NoSuchAlgorithmException{
		//get email,name and password
		email = bean.getEmail();
		password = bean.getPassword();
		role = bean.getRole();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte byteData[] = md.digest();

		//convert the byte to hex format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "INSERT INTO users(email,password,role)VALUES(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,sb.toString());
			ps.setString(3,role);
			System.out.println("Role:"+role);  //haris punya testing if role jadi or not
			//4. execute query
			ps.executeUpdate();			
				
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}

	//get user
	public static Users getUsers (Users bean)  {   
		//get email
		email = bean.getEmail();
		
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM users WHERE email='" + email + "'";
			stmt = con.createStatement();
			
			//execute statement
			rs = stmt.executeQuery(sql);

			// if user exists set the isValid variable to true
			if (rs.next()) {
				bean.setId(rs.getInt("id"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setRole(rs.getString("role"));
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else{
				bean.setValid(false);
			}
			//5. close connection
			con.close();	
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return bean;
	}

	//get user by email
	public static Users getUsersByEmail(String email) {
		Users users = new Users();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM users WHERE email='" + email + "'";
			stmt = con.createStatement();
			
			//execute statement
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	            
				users.setId(rs.getInt("id"));
				users.setEmail(rs.getString("email"));				
				users.setPassword(rs.getString("password"));
				users.setRole(rs.getString("role"));
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}

	//get user by id
	public static Users getUsersById(int id) {
		Users users = new Users();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT * FROM users WHERE id='" + id + "'";
			stmt = con.createStatement();
			
			//execute statement
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				users.setId(rs.getInt("id"));
				users.setEmail(rs.getString("email"));
				users.setPassword(rs.getString("password"));
				users.setRole(rs.getString("role"));
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
	
	//get all user by id
	public static List<Users> getUsersId() {
		List<Users> user = new ArrayList<Users>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			sql = "SELECT id, email, FROM user";
			stmt = con.createStatement();
			
			//4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("id"));
				users.setEmail(rs.getString("email"));
				user.add(users);
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return user;
	}
	//get all user role student
	public static List<Users> getUsersStudent() {
		List<Users> user = new ArrayList<Users>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement  
			stmt = con.createStatement();
			
			//4. execute query
			sql = "SELECT * FROM users u INNER JOIN student s ON u.id = s.id";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Users users = new Users();
				users.setId(rs.getInt("id"));
				users.setEmail(rs.getString("email"));
				users.setStudent(StudentDAO.getStudentId(rs.getInt("id")));
				user.add(users);
			}
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return user;
	}
	//get all user role admin
		public static List<Users> getUsersAdmin() {
			List<Users> user = new ArrayList<Users>();
			try {
				//call getConnection() method 
				con = ConnectionManager.getConnection();
				
				//3. create statement  
				stmt = con.createStatement();
				
				//4. execute query
				sql = "SELECT * FROM users u INNER JOIN admin a ON u.id = a.id";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Users users = new Users();
					users.setId(rs.getInt("id"));
					users.setEmail(rs.getString("email"));
					users.setAdmin(AdminDAO.getAdminId(rs.getInt("id")));
					user.add(users);
				}
				//5. close connection
				con.close();
				
			}catch(Exception e) {
				e.printStackTrace();		
			}

			return user;
		}
		
	//delete admin and student from table users
	public void deleteUsers(int id) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement 
			sql = "DELETE FROM users WHERE id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	
	
}

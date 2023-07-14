package student.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sports.connection.ConnectionManager;
import student.model.Admin;
import student.model.Student;

public class AdminDAO {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static Statement stmt=null;
	private static String name,sql;
	private static int adminid; 	

	//get all admin
	public static List<Admin> getAllAdmin() {
		List<Admin> admins = new ArrayList<Admin>();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM admin ORDER BY adminid";
			stmt = con.createStatement();

			//4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setName(rs.getString("name"));
				admin.setId(rs.getInt("id"));
				admins.add(admin);

			}
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return admins;
	}


	//get admin by adminid
	public static Admin getAdminById(int adminid) {
		Admin admin = new Admin();
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement 
			sql = "SELECT * FROM admin WHERE adminid='"+adminid+"'";
			stmt = con.createStatement(); 

			//4. execute query
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {	            
				admin.setAdminid(rs.getInt("adminid"));
				admin.setName(rs.getString("name"));
				admin.setId(rs.getInt("id"));
			}
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return admin;
	}
	//get admin by id
		public static Admin getAdminId(int id) {
			Admin admin = new Admin();
			try {
				//call getConnection() method  
				con = ConnectionManager.getConnection();

				//3. create statement  
				sql = "SELECT * FROM admin WHERE id='"+id+"'";
				stmt = con.createStatement();

				//4. execute query
				rs = stmt.executeQuery(sql);

				if (rs.next()) {	            
					admin.setAdminid(rs.getInt("adminid"));	
					admin.setName(rs.getString("name"));
					admin.setId(rs.getInt("id"));
				}
				//5. close connection
				con.close();

			}catch(Exception e) {
				e.printStackTrace();
			}

			return admin;
		}

	//update admin
	public void updateAdmin(Admin bean) {

		adminid = bean.getAdminid();
		name = bean.getName();

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();
			
			//3. create statement 
			sql = "UPDATE admin SET name=? WHERE adminid=?";
			ps=con.prepareStatement(sql); 	
			ps.setString(1,name);
			ps.setInt(2,adminid);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

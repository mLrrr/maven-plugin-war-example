package student.dao;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sports.connection.ConnectionManager;
import student.model.Equipment;

public class EquipmentDAO {
	private static Connection con = null;
	private static ResultSet rs = null; 
	private static PreparedStatement ps=null;
	private static Statement stmt=null;
	private static String equipmentname, brand, model, sql;
	private static double price;
	private static int eid, quantity,sid;

	//add Equipment
	public void add(Equipment bean){		
		equipmentname = bean.getEquipmentname();
		System.out.println("equipmentname : "+equipmentname);
		brand = bean.getBrand();
		model = bean.getModel();
		price = bean.getPrice();
		quantity = bean.getQuantity();
		sid = bean.getSid();
	

		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			sql = "INSERT INTO equipment(equipmentname, brand, model, price, quantity, sid)VALUES (:1, :2, :3, :4, :5, :6)";
//			sql = "INSERT INTO equipment(equipmentname,brand,model,price,quantity,sid)VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,equipmentname);
			ps.setString(2,brand);
			ps.setString(3,model);
			ps.setDouble(4,price);
			ps.setInt(5,quantity);
			ps.setInt(6,sid);
			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//get all Equipments
	public static List<Equipment> getAllEquipment() { 
		List<Equipment> equipments = new ArrayList<Equipment>(); 
		try { 
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement
			sql = "SELECT * FROM equipment ORDER BY eid";
			stmt = con.createStatement(); 

			//4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) { 
				Equipment equipment = new Equipment();
				equipment.setEid(rs.getInt("eid"));	  
				equipment.setEquipmentname(rs.getString("Equipmentname"));
				equipment.setBrand(rs.getString("Brand"));
				equipment.setModel(rs.getString("Model"));
				equipment.setPrice(rs.getDouble("price"));
				equipment.setQuantity(rs.getInt("quantity"));
				equipment.setSid(rs.getInt("sid"));
				equipments.add(equipment);

			} 
			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return equipments; 
	}

	//get Equipment by Id
	public static Equipment getEquipmentById(int eid) {
		Equipment equipment = new Equipment();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM equipment WHERE eid='"+eid+"'";
			stmt = con.createStatement(); 

			//4. execute query
			rs = stmt.executeQuery(sql);

			if (rs.next()) {	            
				equipment.setEid(rs.getInt("eid"));	  
				equipment.setEquipmentname(rs.getString("Equipmentname"));
				equipment.setBrand(rs.getString("Brand"));
				equipment.setModel(rs.getString("Model"));
				equipment.setPrice(rs.getDouble("price"));
				equipment.setQuantity(rs.getInt("quantity"));
				equipment.setSid(rs.getInt("sid"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return equipment;
	}

	//delete Equipment
	public void deleteEquipment(int eid) {
		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "DELETE FROM equipment WHERE eid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, eid);

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//update Equipment
	public void updateEquipment(Equipment bean) {

		eid = bean.getEid();
		equipmentname = bean.getEquipmentname();
		brand = bean.getBrand();
		model = bean.getModel();
		price = bean.getPrice();
		quantity = bean.getQuantity();
		sid = bean.getSid();

		try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "UPDATE Equipment SET equipmentname=?,brand=?,model=?, price=?, quantity=?, sid=? WHERE eid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,equipmentname);
			ps.setString(2,brand);
			ps.setString(3,model);
			ps.setDouble(4,price);
			ps.setInt(5,quantity);
			ps.setInt(6,sid);
			ps.setInt(7,eid);

			//4. execute query
			ps.executeUpdate();

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	//get Equipments and student
	public static List<Equipment> getStudentEquipments() { 
		List<Equipment> equipments = new ArrayList<Equipment>(); 
		try { 
			//call getConnection() method 
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM equipment e INNER JOIN student s ON e.sid = s.sid";
			stmt = con.createStatement(); 

			//4. execute query
			rs = stmt.executeQuery(sql);

			while (rs.next()) { 
				Equipment equipment = new Equipment();
				equipment.setEid(rs.getInt("eid"));	  
				equipment.setEquipmentname(rs.getString("Equipmentname"));
				equipment.setPrice(rs.getDouble("price"));
				equipment.setQuantity(rs.getInt("quantity"));
				equipment.setSid(rs.getInt("sid"));
				equipment.setStudent(StudentDAO.getStudentById(rs.getInt("sid")));
				equipments.add(equipment);
			} 

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return equipments; 
	}
}


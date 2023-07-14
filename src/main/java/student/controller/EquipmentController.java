package student.controller;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.dao.EquipmentDAO;
import student.dao.StudentDAO;
import student.model.Equipment;

import java.io.IOException;

/**
 * Servlet implementation class EquipmentController
 */
public class EquipmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher view;
	private static EquipmentDAO dao;
	private int eid;
	private String action="", forward="";
	private static String LIST = "admin/listEquipment.jsp";
	private static String VIEW = "admin/viewEquipment.jsp";	
	private static String UPDATE = "admin/updateEquipment.jsp";
	private static String ADD = "admin/addEquipment.jsp";	
	private static String LISTALL = "admin/listAll.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipmentController() {
        super();
        dao = new EquipmentDAO();     
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("listEquipment")) {
			forward = LIST;
	        request.setAttribute("equipments", EquipmentDAO.getAllEquipment());       
		}		
		if(action.equalsIgnoreCase("listAll")) {
			forward = LISTALL;
			request.setAttribute("equipments", EquipmentDAO.getStudentEquipments());
		}
		if(action.equalsIgnoreCase("viewEquipment")) { 
			forward = VIEW;
			eid = Integer.parseInt(request.getParameter("eid"));  
	        request.setAttribute("equipment", EquipmentDAO.getEquipmentById(eid));
		}
		if(action.equalsIgnoreCase("updateEquipment")) {
			forward = UPDATE;
			Equipment equipment = new Equipment();			
			eid = Integer.parseInt(request.getParameter("eid"));    	        
	        equipment = EquipmentDAO.getEquipmentById(eid);	        	       
	        request.setAttribute("selectedStudent", equipment.getSid()); 	      	       	                
	        request.setAttribute("equipment", equipment); //EquipmentDAO.getEquipmentById(eid)
			request.setAttribute("students", StudentDAO.getAllStudent());	        
		}
		if(action.equalsIgnoreCase("deleteEquipment")) {
			forward = LIST;
			eid = Integer.parseInt(request.getParameter("eid"));  
			dao.deleteEquipment(eid);
			request.setAttribute("equipments", EquipmentDAO.getAllEquipment());    
		}		
		if(action.equalsIgnoreCase("addEquipment")) {
			forward = ADD;			
			request.setAttribute("sups", StudentDAO.getAllStudent());	   
		}
         
        view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Equipment equipment = new Equipment();
		equipment.setEquipmentname(request.getParameter("equipmentname"));
		equipment.setBrand(request.getParameter("brand"));
		equipment.setModel(request.getParameter("model"));
		equipment.setPrice(Double.parseDouble(request.getParameter("price")));
		equipment.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		equipment.setSid(Integer.parseInt(request.getParameter("sid")));
		    
		String eid = request.getParameter("eid");
	    
	    if(eid ==null || eid.isEmpty()) {
	    	dao.add(equipment);
		}
		else {
			equipment.setEid(Integer.parseInt(eid));
			dao.updateEquipment(equipment);
		}
	    
	    request.setAttribute("equipments", EquipmentDAO.getAllEquipment());
	    view = request.getRequestDispatcher("admin/listEquipment.jsp");
        view.forward(request, response);
	}

}

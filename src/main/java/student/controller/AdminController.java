package student.controller;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import student.dao.UserDAO;
import student.dao.AdminDAO;

import student.model.Admin;

import java.io.IOException;

/**
 * Servlet implementation class StudentController
 */

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher view; 
	private static AdminDAO dao;  
	private static UserDAO udao;
	private int adminid;
	private String action="", forward="";
	private static String LIST = "admin/listAdmin.jsp";
	private static String UPDATE = "admin/updateAdmin.jsp";
	private static String VIEW = "admin/viewAdmin.jsp";	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
        dao = new AdminDAO();
        udao = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("listAdmin")) {
			forward = LIST;
	        request.setAttribute("users", UserDAO.getUsersAdmin());        
		}		
		if(action.equalsIgnoreCase("viewAdmin")) {    
			forward = VIEW;
			adminid = Integer.parseInt(request.getParameter("adminid"));
			request.setAttribute("admin", AdminDAO.getAdminById(adminid));
		}		
		if(action.equalsIgnoreCase("updateAdmin")) { 
			forward = UPDATE;
			adminid = Integer.parseInt(request.getParameter("adminid"));
	        request.setAttribute("admin", AdminDAO.getAdminById(adminid));	        
		}
        view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		admin.setName(request.getParameter("name"));
	    dao.updateAdmin(admin);
	   
	    request.setAttribute("users", UserDAO.getUsersAdmin());
	    view = request.getRequestDispatcher("admin/listAdmin.jsp");
        view.forward(request, response);
	}
}
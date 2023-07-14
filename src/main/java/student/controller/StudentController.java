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
import student.dao.UserDAO;
import student.model.Equipment;
import student.model.Student;
import student.model.Users;

import java.io.IOException;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher view;
	private static StudentDAO dao;  
	private static UserDAO udao;
	private int sid;
	private String action="", forward="";
	private static String LIST = "admin/listStudent.jsp";
	private static String UPDATE = "admin/updateStudent.jsp";
	private static String VIEW = "admin/viewStudent.jsp";	
	private static String VIEW_PROFILE = "student/viewProfile.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();
        dao = new StudentDAO();
        udao = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");
        
		if(action.equalsIgnoreCase("listStudent")) {
			forward = LIST;
	        request.setAttribute("users", UserDAO.getUsersStudent());        
		}		
		if(action.equalsIgnoreCase("viewStudent")) {    
			forward = VIEW;
			sid = Integer.parseInt(request.getParameter("sid"));
			request.setAttribute("student", StudentDAO.getStudentById(sid));
		}		
		if(action.equalsIgnoreCase("updateStudent")) { 
			forward = UPDATE;
			sid = Integer.parseInt(request.getParameter("sid"));
	        request.setAttribute("student", StudentDAO.getStudentById(sid));	        
		}
		if(action.equalsIgnoreCase("deleteStudent")) {
			forward = LIST;
	        int id = Integer.parseInt(request.getParameter("id"));
		    udao.deleteUsers(id);		    
		    request.setAttribute("users", UserDAO.getUsersStudent());        
		}
		if(action.equalsIgnoreCase("viewProfile")) {
			forward = VIEW_PROFILE;
			int id = Integer.parseInt(request.getParameter("id"));
	        request.setAttribute("student", StudentDAO.getStudentId(id));      
		}
         
        view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setSid(Integer.parseInt(request.getParameter("sid")));
		student.setName(request.getParameter("name"));
		student.setProgrammename(request.getParameter("programmename"));
		student.setProgrammecode(request.getParameter("programmecode"));
	    dao.updateStudent(student);
	   
	    request.setAttribute("users", UserDAO.getUsersStudent());
	    view = request.getRequestDispatcher("admin/listStudent.jsp");
        view.forward(request, response);
	}
}
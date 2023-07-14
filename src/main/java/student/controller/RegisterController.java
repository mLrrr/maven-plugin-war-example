package student.controller;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import student.dao.EquipmentDAO;
import student.dao.UserDAO;
import student.model.Users;

import java.io.IOException;

/**
 * Servlet implementation class RegisterController
 */

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao;   
	private RequestDispatcher view;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		dao = new UserDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		view = request.getRequestDispatcher("admin/register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users users = new Users();
		//retrieve input and set
		users.setEmail(request.getParameter("email"));		
		users.setPassword(request.getParameter("password"));
		users.setRole(request.getParameter("role"));
		System.out.println(users.getRole());
		users = UserDAO.getUsers(users);
		
		//check if user exists
		if(!users.isValid()){
			try {
				//if user not exist, add/register the user
				dao.add(users);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//redirect to listAll.jsp
		request.setAttribute("equipment", EquipmentDAO.getStudentEquipments());
			RequestDispatcher view = request.getRequestDispatcher("admin/listAll.jsp"); // staff page
			view.forward(request, response);
		}        
	}
}

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
import student.model.Users;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO dao;	
	private HttpSession session;
	private RequestDispatcher view;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Users users = new Users();
			//retrieve and set email and password
			users.setEmail(request.getParameter("email"));
			users.setPassword(request.getParameter("password"));

			users = UserDAO.login(users);
			//set user session if user is valid
			System.out.println("user valid: " + users.isValid());
			if(users.isValid()){
				session = request.getSession(true);
				session.setAttribute("sessionId", users.getId());
				session.setAttribute("sessionEmail", users.getEmail());  				//set current session based on email
				session.setAttribute("sessionRole", users.getRole()); 

				if(users.getRole().equalsIgnoreCase("admin")) {
					request.setAttribute("users", UserDAO.getUsersByEmail(users.getEmail()));   					
					request.setAttribute("equipments", EquipmentDAO.getStudentEquipments());
					view = request.getRequestDispatcher("admin/listAll.jsp"); 			// admin page
					view.forward(request, response);	
				}
				else {
					request.setAttribute("users", UserDAO.getUsersByEmail(users.getEmail()));					
					request.setAttribute("student", StudentDAO.getStudentId(users.getId()));					
					view = request.getRequestDispatcher("student/viewProfile.jsp"); 	 // student page
					view.forward(request, response);	
				}											
			}
			//redirect to invalidLogin.jsp if user is not valid
			else{
				response.sendRedirect("invalidLogin.jsp");
			}		
		}

		catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

}

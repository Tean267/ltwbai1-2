package murach.email;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.DB.UserDB;
import murach.business.User;

/**
 * Servlet implementation class EmailListServlet
 */
@WebServlet("/EmailListServlet")
public class EmailListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String relativePathToFile = this.getServletConfig().getInitParameter("relativePathToFile");
		String ToEmailList = this.getServletContext().getRealPath(relativePathToFile);
		String url ="index.html";
		//get current action
		String action = request.getParameter("action");
		if(action==null) {
			action ="join";
		}
		if(action.equals("join")) {
			url = "/index.jsp";
		}
		else if(action.equals("add")) {
			//get parameters from the request
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String[] musicTypes = request.getParameterValues("musicTypes[]");
			User user = new User(firstName,lastName,email,musicTypes);
			//store data in User object and save User object in db
		
			String mess1=null;
			String mess2=null;
			String mess3=null;
			if(email==null||email.isEmpty()) {
				mess1 = "Please enter your email in the box"; 
			}
			else if(UserDB.emailExisted(email, ToEmailList)==true){
				mess1="Email already exists";
			}
			if(firstName==null||firstName.isEmpty()) {
				mess2 = "Please enter your firstName in the box"; 
			}
			if(lastName==null||lastName.isEmpty()) {
				mess3 = "Please enter your lastName in the box"; 
			}
			if(mess1!=null||mess2!=null||mess3!=null) {
				url="/index.jsp";
			}
			else {
				url="/Thank.jsp";				
				UserDB.insert(user, ToEmailList);
			}		
			//set User object in request object and set URL
			if(mess1!=null) {
				request.setAttribute("mess1",mess1);
			}
			if(mess2!=null) {
				request.setAttribute("mess2",mess2);
			}
			if(mess3!=null) {
				request.setAttribute("mess3",mess3);
			}
			request.setAttribute("user",user);
		}
		//forward request and response objects to specified URL
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}

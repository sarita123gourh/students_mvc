package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Student;

import Service.StudentService;

public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter p=response.getWriter();
		//read the request 
		
		int id=Integer.parseInt(request.getParameter("u1"));
		p.println(id);
		//process the request
		
		StudentService service=new StudentService();
		Student student=service.UpdateStudent(id);
		
		 
		request.setAttribute("student", student);
		RequestDispatcher rd=request.getRequestDispatcher("Details.jsp");
	    rd.forward(request,response);
	}

}

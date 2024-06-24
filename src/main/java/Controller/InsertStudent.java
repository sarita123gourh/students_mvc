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


public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		//read the request 
		
		int id=Integer.parseInt(request.getParameter("i1"));
		String s1=request.getParameter("i2");
		String s2=request.getParameter("i3");
		int marks=Integer.parseInt(request.getParameter("i4"));
		String s3=request.getParameter("i5");
		
		p.println(id);
		//process the request
		Student s = new Student(id, s1,s2, marks,s3);
		StudentService service=new StudentService();
		Student student=service.InsertStudent(s);
		
		request.setAttribute("student",student);
		RequestDispatcher rd=request.getRequestDispatcher("Details.jsp");
	    rd.forward(request,response);
	}

}

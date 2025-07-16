package in.pentagon.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.Studentimpl;
import in.ps.Studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//creating pojo class
		
		StudentDAO sdao=new Studentimpl();
		HttpSession session=req.getSession(true);
		PrintWriter out=resp.getWriter();
		
		Student s=sdao.getStudent(req.getParameter("mail"),req.getParameter("pass"));
		if(s!=null) {
			//out.println("logged in successfully welcome"+s.getName());
			session
			
			.setAttribute("student", s);
			req.setAttribute("success","Logged in successfully!!");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);;
		}else {
//			out.println("Failed to login");
			req.setAttribute("error","Failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		
		
	}
	
	

}

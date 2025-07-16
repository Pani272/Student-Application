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
@WebServlet("/forgot")

public class Forgot extends  HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		StudentDAO sdao=new Studentimpl();
		PrintWriter out=resp.getWriter();
		
		Student s=sdao.getStudent(Long.parseLong(req.getParameter("phonenumber")),req.getParameter("email"));
		
		if(s!=null) {
		if(req.getParameter("password").equals(req.getParameter("cnfpassword"))){
			s.setPassword(req.getParameter("password"));
			boolean pass=sdao.updateStudent(s);
			if(pass) {
				req.setAttribute("success", "Password Updated Successfully!");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
				
			}else {
				req.setAttribute("error", "Password not Updated!");
				RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
				rd.forward(req, resp);
		}
		}else{
			req.setAttribute("error", "Password Doesn't Match!");
			RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
			rd.forward(req, resp);
		}
	}else {
		req.setAttribute("error", "Id not Matched!");
		RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
		rd.forward(req, resp);
	}
	}
	

}

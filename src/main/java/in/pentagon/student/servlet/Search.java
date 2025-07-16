package in.pentagon.student.servlet;

import java.io.IOException;
import java.util.ArrayList;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.Studentimpl;
import in.ps.Studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Search extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new Studentimpl();
		ArrayList<Student> users=sdao.getStudent(req.getParameter("search"));
		req.setAttribute("users", users);
		RequestDispatcher rd= req.getRequestDispatcher("Dashboard.jsp");
		rd.forward(req, resp);
	}
}

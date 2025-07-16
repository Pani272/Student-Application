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
@WebServlet("/Signup")
public class Signup  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// creation of POJO class object
		Student s=new Student();
		StudentDAO sdao=new Studentimpl();
		PrintWriter out=resp.getWriter();
		
		//collecting the data from the UI
		//String name=req.getParameter("name");
		//s.setName(name);
		s.setName(req.getParameter("name"));
		
		//String phone=req.getParameter("phone");
		//long phone_no=Long.parseLong(phone);
		//s.setPone(phone_no);
		
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		if(req.getParameter("password").equals(req.getParameter("confpass"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data saved successfully</h1>");
				req.setAttribute("success", "Account created successfully");//package
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");//destination
				rd.forward(req, resp);//delivery guy
			}
			else {
				//out.println("<h1>Failed to save data</h1>");
				req.setAttribute("error","Failed to create an account");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
		}
		else {
//			out.println("<h1>Password mismatch</h1>");
			req.setAttribute("error","Password mismatch!");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
			
		}
	}

}

package in.pentagon.student.servlet;

import java.io.IOException;

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
@WebServlet ("/Update")

public class Update extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("student");
		StudentDAO sdao=new Studentimpl();
		if(s!=null) {
			s.setName(req.getParameter("name"));
			s.setPhone(Long.parseLong(req.getParameter("phone")));
			s.setMail(req.getParameter("mail"));
			s.setBranch(req.getParameter("branch"));
			s.setLoc(req.getParameter("loc"));
			boolean res=sdao.updateStudent(s);
			if(res) {
				req.setAttribute("success", "Account updated successfully");
				RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("error", "Account doesn't updated");
				RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error", "Session Expired");
			RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
	}

}

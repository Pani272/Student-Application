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
@WebServlet("/resetPassword")
public class Reset extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new Studentimpl();
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("student");
		if(s!=null) {
			if(Long.parseLong(req.getParameter("phone"))==s.getPhone() && req.getParameter("mail")==s.getMail()) {
				if(req.getParameter("password").equals(req.getParameter("confirm"))) {
					s.setPassword(req.getParameter("password"));
					boolean res=sdao.updateStudent(s);
					if(res) {
						req.setAttribute("success", "Password update successfully!");
						RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
						rd.forward(req, resp);
					}
					else {
						req.setAttribute("error", "Failed to update the password!");
						RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
						rd.forward(req, resp);

					}
				}
			}
		}
	}

}

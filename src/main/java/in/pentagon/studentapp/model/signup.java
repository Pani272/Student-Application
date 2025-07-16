package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.Studentimpl;
import in.ps.Studentapp.dto.Student;

public class signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		Student s=new Student();//Pojo class
		StudentDAO sdao=new Studentimpl();
		//Collecting Data from user
		System.out.println("Welcome to signup page:");
		System.out.println("Enter Name:");
		s.setName(sc.next());
		System.out.println("Enter Phone number:");
		s.setPhone(sc.nextLong());
		System.out.println("enter the email:");
		s.setMail
		(sc.next());
		System.out.println("enter the branch:");
		s.setBranch(sc.next());
		System.out.println("enter the Locatio:n");
		s.setLoc(sc.next());
		System.out.println("enter the password:");
		String Password=sc.next();
		System.out.println("enter the confirm password:");
		String cnfmpassword=sc.next();
		if(Password.equals(cnfmpassword)) {
			s.setPassword(cnfmpassword);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("Data Add Successfull");
			}else {
				System.out.println("No Data Added");
			}
				
			}else {
				System.out.println("Password Missmatching");
			
		}
		
	}

}

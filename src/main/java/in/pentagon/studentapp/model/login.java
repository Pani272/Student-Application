package in.pentagon.studentapp.model;



import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.Studentimpl;
import in.ps.Studentapp.dto.Student;

public class login {
	
	public static void login() {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		StudentDAO sdao=new Studentimpl();
		System.out.println("Welcom to login page:");
		System.out.println("Enter your Email");
		String mail=sc.next();
		System.out.println("Enter your password");
		String password=sc.next();
		Student s=sdao.getStudent(mail,password);
		if(s!=null) {
			System.out.println("login successfull welcome  "+s.getName());
			do{
				System.out.println("Enter your choice:");
				System.out.println("1,View your account:");
				System.out.println("2,Update your account:");
				System.out.println("3,Forgot password:");
				System.out.println("4,Reset password:");
				System.out.println("5,Back to main");
				if(s.getId()==8) {
					System.out.println("6,View all users:");
					System.out.println("7,Delete user:");
				}
				choice=sc.nextInt();
				switch(choice) {
				case 1:System.out.println(s.toString());
				break;
				case 2:Update.update(s);
				break;
				case 3:
				break;
				case 4: System.out.println("Going back to main menu..");
				break;
				case 5: System.out.println("Enter the Student ID to be deleted:");
				
				boolean res=sdao.deleteStudent(sc.nextInt());
				
				if(res) {
					System.out.println("Data deleted successfully");
				}
				else {
					System.out.println("Failed to delete the data");
				}
				break;
				case 6: ArrayList<Student> studentList=sdao.getStudent();
				for(Student s1:studentList) {
					System.out.println(s1);
				}
				default:System.out.println("Invalid choice,choose the right one");
				break;
					
				}
			}while(choice!=4);
		}
		else{
			System.out.println("Failed to login");
		}
	}
}


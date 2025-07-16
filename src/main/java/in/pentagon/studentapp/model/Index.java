package in.pentagon.studentapp.model;

import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("Welcom to Student App");
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. FORGOT PASSWORD");
			System.out.println("4. EXIT");
			choice=sc.nextInt();
			switch(choice) {
			case 1:signup.signup();
				break;
			case 2:login.login();
				break;
			case 3: //Passsword.Forgot();
				break;
			case 4:
				System.out.println("Application closed");
				break;
			default:
				System.out.println("invalid choice!Try again");
				break;
			}
		}while(choice!=3);
		}
	
	}



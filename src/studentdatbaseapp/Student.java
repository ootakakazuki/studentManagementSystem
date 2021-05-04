package studentdatbaseapp;
import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses;
	private int tuitionBalance = 0;
	private static int costOfCource = 600;
	private static int id = 1001;
	
	// コンストラクタ:生徒に名前と年を尋ねる
	public Student() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();

		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level:");
		this.gradeYear = in.nextInt();
		
		
		
		setStudentID();
		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);
		
	}
	
	// IDの生成
	private void setStudentID() 
	{
		// id のインクリメント
		id++;
		// 学年 + ID で生成
		this.studentID = gradeYear + "" + id;
	}
	
	// 講義の登録
	public void enroll() 
	{
		do {
			System.out.println("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q"))
			{
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCource;
			}
			else 
			{
				break;
			}
		} while (true);
	}	
	
	// 残高を見る
	public void viewBalance() 
	{
		System.out.println("Your balance is : $" + tuitionBalance);
	}
	
	// 授業料を払う
	public void payTuition() 
	{
		viewBalance();
		System.out.println("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}
	
	// ステータス確認
	public String toString() 
	{
		return "Name: " + firstName + " " + lastName + 
				"\nGrade Level: " + gradeYear + 
				"\nStudent ID: " + studentID + 
				"\nCoutrces Enrolled: " + courses + 
				"\nBalance: $" + tuitionBalance;
	}
}

import java.io.*;
import java.util.Scanner;

class Student {

	private String USN;
	private String name;
	private String branch;
	private String phoneNumber;


	public Student() {
		USN = "";
		name = "";
		branch = "";
		phoneNumber = "";
	}

	public void printStudentDetails(int Tab) {

		System.out.print(USN);
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");

		System.out.print(name);
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");

		System.out.print(branch);
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");

		System.out.print(phoneNumber);
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");
		System.out.println();
	}

	public int getStudentDetails() {

		Scanner sc = new Scanner(System.in);
		int Tab = 0;

		System.out.print("USN:");
		USN = sc.next();
		if(Tab < USN.length()/8)
			Tab = USN.length()/8;

		System.out.print("Name:");
		name = sc.next();
		if(Tab < name.length()/8)
			Tab = name.length()/8;

		System.out.print("Branch:");
		branch = sc.next();
		if(Tab < branch.length()/8)
			Tab = branch.length()/8;

		System.out.print("Phone Number:");
		phoneNumber = sc.next();
		if(Tab < phoneNumber.length()/8)
			Tab = phoneNumber.length()/8;

		return Tab;
	}

}

class PrintStudent {

	public static void main(String args[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		int Tab = 0;

		System.out.println("\n\n\tSTUDENT DETAILS\n");

		System.out.print("Enter the number of students:");
		int number = sc.nextInt();

		Student[] student = new Student[number];

		for(int i = 0; i < number; i++) {

			student[i] = new Student();
			System.out.println("\nStudent "+(i+1));
			int studentTab = student[i].getStudentDetails();
			if(Tab < studentTab) {
				Tab = studentTab;
			}
		}

		System.out.print("USN");
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");

		System.out.print("Name");
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");

		System.out.print("Branch");
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");

		System.out.print("Phone Number");
		for(int i = 0; i <= Tab; i++)
			System.out.print("\t");
		System.out.println();

		for(int i = 0; i < number; i++) {

			student[i].printStudentDetails(Tab);
		}
	}
}

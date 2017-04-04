/**
 * Name: Divyaksh Shukla
 * USN:  1PE15CS051
 * Date: 10/02/2017
 * Purpose: To store the data of the Faculty belonging to 3 different classes of Teaching, Technical and Contract
 */
import java.util.Scanner;

class Staff {

	//SuperClass
	private String staffId;
	private String name;
	private String phone;
	private String salary;
	
	public Staff() {
		staffId = "";
		name = "";
		phone = "";
		salary = "";
	}
	
	public void setStaffDetails() {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Staff ID:");
		staffId = scanner.nextLine();
		
		System.out.print("Name:");
		name = scanner.nextLine();
		
		System.out.print("Phone:");
		phone = scanner.nextLine();
		
		System.out.print("Salary:");
		salary = scanner.nextLine();
	}
	
	public void printStaffDetails() {
		System.out.print(staffId+"\t"+name+"\t"+phone+"\t"+salary+"\t");
	}

}

class Contract extends Staff {

	private int period;
	
	public void setContractDetails() {
		
		super.setStaffDetails();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Period:");
		period = scanner.nextInt();
	}
	
	public void printContractDetails() {
		super.printStaffDetails();
		System.out.println(period);
	}
}

class Teaching extends Staff {

	private String domain;
	private String publications;
	
	public void setTeachingDetails() {
		super.setStaffDetails();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Domain:");
		domain = scanner.nextLine();
		
		System.out.print("Publications:");
		publications = scanner.nextLine();
	}
	
	public void printTeachingDetails() {
		super.printStaffDetails();
		System.out.println(domain+"\t"+publications);
	}
}

class Technical extends Staff {

	private String skills;
	
	public void setSkills() {
		super.setStaffDetails();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.print("Skills:");
		skills = scanner.nextLine();
	}
	
	public void printSkills() {
		super.printStaffDetails();
		System.out.println(skills);
	}
}

class MainClass {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of employees:");
		int num = scanner.nextInt();

		Teaching teaching[] = new Teaching[num];
		Technical technical[] = new Technical[num];
		Contract contract[] = new Contract[num];

		int numTeaching = 0;
		int numTechnical = 0;
		int numContract = 0;

		for(int count = 0; count < num; count++) {
			System.out.println("\n\tSTAFF DETAILS");
			System.out.println("1.Teaching\n2.Technical\n3.Contract");
			System.out.print("CHOICE:");
			int choice = scanner.nextInt();

			switch(choice) {
				case 1:
					teaching[numTeaching] = new Teaching();
					teaching[numTeaching].setTeachingDetails();
					numTeaching++;
					break;
				case 2:
					technical[numTechnical] = new Technical();
					technical[numTechnical].setSkills();
					numTechnical++;
					break;
				case 3:
					contract[numContract] = new Contract();
					contract[numContract].setContractDetails();
					numContract++;
					break;

				default:
					System.out.println("INVALID CHOICE");
			}
		}
		
		System.out.println("ID\tNAME\tPHONE\tSALARY\tDOMAIN\tPUBLICATIONS");
		for(int i = 0; i < numTeaching; i++) {
			teaching[i].printTeachingDetails();
		}
		
		System.out.println("ID\tNAME\tPHONE\tSALARY\tSKILLS");
		for(int i = 0; i < numTechnical; i++) {
			technical[i].printSkills();
		}
		
		System.out.println("ID\tNAME\tPHONE\tSALARY\tPERIOD");
		for(int i = 0; i < numContract; i++) {
			contract[i].printContractDetails();
		}
	}
}

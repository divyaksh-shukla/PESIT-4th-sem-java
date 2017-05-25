import java.util.Scanner;

class Staff {

	private int staffId;
	private String name;
	private String phone;
	private String salary;

	public Staff() {
		staffId = 0;
		name = "";
		phone = "";
		salary = "";
	}

	public void setStaffDetails() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Staff ID:");
		staffId = sc.nextInt();

		System.out.print("Name:");
		name = sc.next();

		System.out.print("Phone:");
		phone = sc.next();

		System.out.print("Salary:");
		salary = sc.next();
	}

	public void printStaffDetails() {
		System.out.print(staffId+"\t"+name+"\t"+phone+"\t"+salary+"\t");
	}
}

class Teaching extends Staff {

	private String domain;
	private String publications;

	public Teaching() {
		domain = "";
		publications = "";
	}

	public void setTeachingDetails() {

		Scanner sc = new Scanner(System.in);

		super.setStaffDetails();
		System.out.print("Domain:");
		domain = sc.next();
		System.out.print("Publications:");
		publications = sc.next();
	}

	public void printTeachingDetails() {
		super.printStaffDetails();

		System.out.println(domain+"\t"+publications);
	}
}

class Technical extends Staff {

	private String skills;

	public Technical() {
		skills = "";
	}

	public void setTechnicalDetails() {

		Scanner sc = new Scanner(System.in);

		super.setStaffDetails();
		System.out.print("Skills:");
		skills = sc.next();
	}

	public void printTechnicalDetails() {
		super.printStaffDetails();

		System.out.println(skills);
	}
}

class Contract extends Staff {

	private String period;

	public Contract() {
		period = "";
	}

	public void setContractDetails() {

		Scanner sc = new Scanner(System.in);

		super.setStaffDetails();
		System.out.print("Contract Period:");
		period = sc.next();
	}

	public void printContractDetails() {
		super.printStaffDetails();

		System.out.println(period);
	}
}

class Q2a_Staff{

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		System.out.println("\tSTAFF DETAILS");
		System.out.print("Enter the number of staff members:");
		int nStaff = sc.nextInt();

		Teaching teaching[] = new Teaching[nStaff];
		Technical technical[] = new Technical[nStaff];
		Contract contract[] = new Contract[nStaff];
		int iTeaching = 0,iTechnical = 0,iContract = 0;

		for (int iStaff = 0; iStaff < nStaff; iStaff++) {
			System.out.println("\n1.Teaching\n2.Technical\n3.Contract");
			System.out.print("Choice:");
			int choice = sc.nextInt();

			switch(choice) {
				case 1:
					System.out.println("\n\tTEACHING DETAILS");
					teaching[iTeaching] = new Teaching();
					teaching[iTeaching].setTeachingDetails();
					iTeaching++;
					break;
				case 2:
					System.out.println("\n\tTECHNICAL DETAILS");
					technical[iTechnical] = new Technical();
					technical[iTechnical].setTechnicalDetails();
					iTechnical++;
					break;

				case 3:
					System.out.println("\n\tCONTRACT DETAILS");
					contract[iContract] = new Contract();
					contract[iContract].setContractDetails();
					iContract++;
					break;

			}
		}

		if(iTeaching != 0) {
			System.out.println("\n\nID\tNAME\tPHONE\tSALARY\tDOMAIN\tPUBLICATIONS");
			for(int i = 0; i < iTeaching; i++) {
				teaching[i].printTeachingDetails();
			}
		}

		if(iTechnical != 0) {
			System.out.println("\n\nID\tNAME\tPHONE\tSALARY\tSKILLS");
			for(int i = 0; i < iTechnical; i++) {
				technical[i].printTechnicalDetails();
			}
		}

		if(iContract != 0) {
			System.out.println("\n\nID\tNAME\tPHONE\tSALARY\tCONTRACT");
			for(int i = 0; i < iContract; i++) {
				contract[i].printContractDetails();
			}
		}
	}
}

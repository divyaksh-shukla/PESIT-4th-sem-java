import java.util.Scanner;
import java.util.StringTokenizer;

class Customer {

	private String name;
	private String dob;
	
	public Customer() {
		name = "";
		dob = "";
	}
	
	public void setCustomerData() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Name:");
		name = scanner.nextLine();
		System.out.print("Date of Birth (dd/mm/yyyy):");
		dob = scanner.nextLine();
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}
	
	public int getDate() {
		StringTokenizer stringTokenizer = new StringTokenizer(dob,"/");
		return Integer.parseInt(stringTokenizer.nextToken());
	}
	
	public int getMonth() {
		StringTokenizer stringTokenizer = new StringTokenizer(dob,"/");
		String val = stringTokenizer.nextToken();
		return Integer.parseInt(stringTokenizer.nextToken());
	}
	
	public int getYear() {
		StringTokenizer stringTokenizer = new StringTokenizer(dob,"/");
		String val = stringTokenizer.nextToken();
		val = stringTokenizer.nextToken();
		return Integer.parseInt(stringTokenizer.nextToken());
	}

	public void printCustomerData() {
		StringTokenizer stringTokenizer = new StringTokenizer(dob,"/");
		System.out.println(name + ",\t" + stringTokenizer.nextToken() + "," + stringTokenizer.nextToken() + "," + stringTokenizer.nextToken());
	}
	
}

class Q2b_CustomerData {
	
	public static void main(String args[]) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n\tCUSTOMER DATA");
		System.out.print("Enter the number of customers:");
		int n = scanner.nextInt();
		//int n = 1;
		
		Customer[] customer = new Customer[n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("Customer "+i);
			customer[i] = new Customer();
			customer[i].setCustomerData();
		}

		System.out.println();

		for(int i = 0; i < n; i++) {
			System.out.println("Customer " + i);
			customer[i].printCustomerData();
		}
	}
}

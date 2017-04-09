import java.util.Scanner;

class Floyd {

	private int cost[][];
	private int distance[][];
	private int size;

	public Floyd(int size) {
		cost = new int[size][size];
		distance = new int [size][size];
		this.size = size;
	}

	public void enterCost() {

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cost[i][j] = scanner.nextInt();

				if (i == j) {
					cost[i][j] = 0;
				}
				else if (cost[i][j] == 0) {
					cost[i][j] = Integer.MAX_VALUE % 10000;
				}
			}
		}
	}

	public void floydAPSP() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				distance[i][j] = cost[i][j];
			}
		}

		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j]);
				}
			}
		}
	}

	public int min(int num1, int num2) {
		if(num1 < num2) {
			return num1;
		}
		return num2;
	}

	public void printDistance() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(distance[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

class MainClass {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\t\tFLOYD\'S APSP ALGORITHM\n\n");
		System.out.print("Enter the number of nodes:");
		int size = scanner.nextInt();

		Floyd floyd = new Floyd(size);

		System.out.println("Enter the cost matrix:");
		floyd.enterCost();

		floyd.floydAPSP();

		System.out.println("\nAll-pair shortest path is:");
		floyd.printDistance();
	}
}

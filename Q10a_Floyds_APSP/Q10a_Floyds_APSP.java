import java.util.Scanner;

public class Q10a_Floyds_APSP {
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		/*System.out.println("\n\t\tFLOYDS ALGORITHM\n\n");
		System.out.print("Enter the number of nodes:");
		int size = scanner.nextInt();*/

		/*For user input matrix*/
		/*Floyd floyd = new Floyd(size);
		System.out.println("Enter the cost matrix:");
		floyd.enterCost();
		floyd.applyFloyd();
		System.out.println("\nThe all pair shortest path in the graph is:");
		floyd.displayShortest();*/

		Floyd floyd = new Floyd();
		floyd.displayShortest();
		floyd.applyFloyd();
		floyd.displayShortest();

	}
}

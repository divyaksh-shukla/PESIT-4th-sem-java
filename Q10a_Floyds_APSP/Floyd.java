import java.util.Scanner;
import java.util.Random;

public class Floyd {
	private int cost[][];
	private int size;
	public int shortDistance[][];

	public static final int BOUND = 100;
	public static final int MAX_NODES = 10;
	public static final int THRESHOLD = 20;

	public Floyd() {

		this.size = MAX_NODES;
		cost = new int[size][size];
		shortDistance = new int[size][size];

		Random random = new Random();

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				shortDistance[i][j] = cost[i][j] = Integer.MAX_VALUE % 10000;
				int val = random.nextInt(BOUND);
				if(val > THRESHOLD && i != j) {
					cost[i][j] = random.nextInt(BOUND);
				}
				if(i == j) {
					cost[i][j] = 0;
				}

				shortDistance[i][j] = cost[i][j];
			}
		}
	}

	public Floyd(int size) {
		cost = new int[size][size];
		shortDistance = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j <size; j++) {
				shortDistance[i][j] = cost[i][j] = Integer.MAX_VALUE % 10000;
				if(i == j){
					cost[i][j] = 0;
				}
			}
		}
		this.size = size;
	}

	public void enterCost() {

		Scanner scanner = new Scanner(System.in);

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				cost[i][j] = scanner.nextInt();
				if((cost[i][j] == 0 || cost[i][j] == 999) && i != j) {
					cost[i][j] = Integer.MAX_VALUE % 10000;
				}
				shortDistance[i][j] = cost[i][j];
			}
		}
	}

	public void applyFloyd() {

		for(int k = 0; k < size; k++) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j <size; j++) {
					shortDistance[i][j] = min(shortDistance[i][j], (shortDistance[i][k] + shortDistance[k][j]));
				}
			}
		}
	}

	public int min(int val1, int val2) {
		return (val1 < val2) ? val1 : val2;
	}

	public void displayShortest() {
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(shortDistance[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

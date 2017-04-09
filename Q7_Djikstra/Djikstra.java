import java.util.Scanner;

class Djikstra {

	private int cost[][];
	private int distance[];
	private boolean visited[];
	private int size;

	public Djikstra(int size) {
		cost = new int[size][size];
		distance = new int[size];
		visited = new boolean[size];
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
				else if(cost[i][j] == 0) {
					cost[i][j] = Integer.MAX_VALUE % 10000;
				}
			}
		}
	}

	public void djikstra(int source) {
		
		for (int i = 0; i < size; i++) {
			distance[i] = cost[source][i];
			visited[i] = false;
		}

		visited[source] = true;
		int mincost = 0;
		int minpos = 0;
		
		for (int i = 0; i < size; i++) {
			mincost = Integer.MAX_VALUE % 10000;
			for (int j = 0; j < size; j++) {
				if (mincost > distance[j] && visited[j] == false) {
					mincost = distance[j];
					minpos = j;
				}
			}

			visited[minpos] = true;
			for (int j = 0; j < size; j++) {
				if (distance[j] > mincost + cost[minpos][j]) {
					distance[j] = mincost + cost[minpos][j];
				}
			}
		}
	}

	public void printDistance(int source) {
		for (int i = 0 ; i < size; i++) {
			System.out.println(source + "-->" + i + ":" + distance[i]);
		}
	}
}

class MainClass {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\t\tDJIKSTRA SINGLE NODE SHORTEST PATHS\n\n");
		System.out.print("Enter the number of nodes:");
		int size = scanner.nextInt();

		Djikstra dji = new Djikstra(size);

		System.out.println("Enter the cost matrix of the graph:");
		dji.enterCost();
		
		System.out.print("Enter a source node:");
		int source = scanner.nextInt();

		dji.djikstra(source);
		System.out.println("\nThe distance from source to each node:");
		dji.printDistance(source);
	}
}

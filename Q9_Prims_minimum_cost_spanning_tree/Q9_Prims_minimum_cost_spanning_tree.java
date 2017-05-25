/** 
 * Friday 24 March 2017 
*/

import java.util.Scanner;

class SpanningTree {

	private int cost[][];
	private boolean visited[];
	private int size;

	public SpanningTree(int size) {
		cost = new int[size][size];
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
				else if (cost[i][j] == 0) {
					cost[i][j] = Integer.MAX_VALUE % 10000;
				}
			}
		}
	}
    
    	public int primsMinimumCost() {

		for (int i = 0; i < size; i++) {
			visited[i] = false;
		}

		visited[0] = true;
		int edges = 0;
		int mincost = 0;
		int min = 0;
		int u = 0,v = 0;

		while(edges < size-1) {

			min = Integer.MAX_VALUE % 10000;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(min > cost[i][j] && visited[i] == true && visited[j] == false) {
						min = cost[i][j];
						u = i;
						v = j;
					}
				}
			}

			visited[v] = true;
			edges++;
			mincost += min;

			System.out.println(u + "-->" + v);
		}

		return mincost;
	}
}

class Q9_Prims {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("\t\tPRIMS ALGORITHM\n\n");
		System.out.print("Enter the number of nodes:");
		int size = scanner.nextInt();

		SpanningTree st = new SpanningTree(size);

		System.out.println("Enter the cost matrix of the graph:");
		st.enterCost();

		System.out.println("\nThe tree nodes are:");
		int treeCost = st.primsMinimumCost();
		System.out.println("\nTree Cost = " + treeCost);
	}
}

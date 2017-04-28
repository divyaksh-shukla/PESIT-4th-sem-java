import java.util.Scanner;

class SpanningTree {

	private int cost[][];
	private int edges[][];
	private int size;

	public SpanningTree(int size) {

		cost = new int[size][size];
		edges = new int[size * size][3];
		this.size = size;
	}

	public void createEdges() {

		int min, u, v;

		for (int k = 0; k < (size * size); k++) {
			min = Integer.MAX_VALUE % 10000;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < i; j++) {
					if(min > cost[i][j] ) {
						min = cost[i][j];
						u = i;
						v = j;
					}
				}
			}

			edges[k][0] = u;
			edges[k][1] = v;
			edges[k][2] = cost[u][v];

			cost[u][v] = cost[v][u] = Integer.MAX_VALUE % 10000;
		}
	}
}

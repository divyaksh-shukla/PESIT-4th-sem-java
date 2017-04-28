import java.util.Scanner;

class SpanningTree {

	private int cost[][];
	private int size;

	public SpanningTree(int size) {
		this.size = size;
		cost = new int size;
	}

	public int Prims() {
		int visited[] = new int[size];

		for(int i = 0; i < size; i++) {
			visited[i] = 0;
		}

		visited[0] = 1;
		int nv = 0, i, j, u, v, mincost = 0, min;
		
		while(nv < size) {

			min = Integer.MAX_VALUE % 10000;

			for(i = 0; i < size; i++) {
				for(j = 0; j < size; j++) {
					if(visited[i] == 1 && visited[j] == 0 && cost[i][j] < min) {
						min = cost[i][j];
						u = i;
						v = j;
					}
				}
			}

			if(visited[v] == 0) {

				visited[v] = 1;
				nv++;
				cost[u][v] = Integer.MAX_VALUE;
				mincost += min;

				System.out.println(u + "-" + v + ":" + min);
			}
		}

		return mincost;
	}

	public void enterCost() {

	}
}

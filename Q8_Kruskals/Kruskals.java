import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
	int u, v, w;

	public Edge (int u, int v, int w) {
		this.u = u;
		this.v = v;
		this.w = w;
	}

	public int compareTo(Edge edge) {
		return this.w - edge.w;
	}
}

class Kruskals {

	int parent[];
	int cost[][];
	int size;

	public void makeKruskals () {
		int n = size;
		ArrayList<Edge> edges = new ArrayList<Edge>();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				edges.add(new Edge(i,j,cost[i][j]));
			}
		}

		Collections.sort(edges);
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		int i = 0;
		ArrayList<Edge> tree = new ArrayList<Edge>();

		while (i < n - 1 && !edges.isEmpty()) {
			Edge x = edges.remove(0);
			int j = findParent(x.u);
			int k = findParent(x.v);
			if(j != k) {
				i++;
				tree.add(x);
				union(j, k);
			}
		}

		if (i != n-1) {
			System.out.println("Graph does not give a spanning tree");
		}
		else {
			System.out.println("\t\tSPANNING TREE\nEdge\tWeight");
			for (i = 0; i < n-1; i++) {
				System.out.println(tree.get(i).u + " " + tree.get(i).v + "\t" + tree.get(i).w);
			}
		}
	}

	public int findParent(int i) {
		while(i != parent[i]) {
			i = parent[i];
		}
		return i;
	}

	public void union(int j, int k) {
		parent[j] = k;
	}

	public void inputGraph() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of nodes:");
		size = scanner.nextInt();
		cost = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				cost[i][j] = scanner.nextInt();
				if(i == j) {
					cost[i][j] = 0;
				}
				else if(cost[i][j] == 0) {
					cost[i][j] = Integer.MAX_VALUE % 10000;
				}
			}
		}
	}

	public static void main(String args[]) {
		Kruskals k = new Kruskals();
		k.inputGraph();
		k.makeKruskals();
	}
}

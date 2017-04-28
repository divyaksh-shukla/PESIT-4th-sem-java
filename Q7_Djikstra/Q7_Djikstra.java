class Djikstra {
	private int distance[];
	private int cost[][];
	static int INF_VAL = Integer.MAX_VALUE;

	public void createValues(int size) {

		distance = new int[size];
		cost = new int[size][size];
	}

	public void calcDistance( int n, int s) {

		int flag[] = new int[n+1];
		int minpos = 1, c, minimum;

		for(int i = 1; i <= n; i++) {
			flag[i] = 0;
			distance[i] = cost[s][i];
			if(cost[s][i] == 0) {

			}
		}

		c = 2;
		while (c <= n) {

			minimum = INF_VAL;

			for(int k = 1; k <= n; k++) {

				if(this.distance[k] < minimum && flag[k] != 1) {
					minimum = this.distance[k];
					minpos = k;
				}
			}
			flag[minpos] = 1;
			c++;

			for(int k = 1; k <= n; k++) {

				if(this.distance[minpos] + this.cost[minpos][k] < this.distance[k] && flag[k] != 1) {

					this.distance[k] = this.distance[minpos] + this.cost[minpos][k];
				}
			}
		}
	}

	public static void main(String args[]) throws IOException {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of nodes:");
		int size = scanner.nextInt();

		createValues(size);

		System.out.print("Enter the source node:");
		int source = scanner.nextInt();

		calcDistance(size, source);

		for(int i = 2; i <= n; i++) {
			System.out.println(i + " " + distance[i]);
		}
	}
}

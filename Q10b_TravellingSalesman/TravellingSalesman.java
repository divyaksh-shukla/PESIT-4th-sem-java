import java.util.Scanner;

class TravellingSalesman {
    int size;
    int cost[][];

    public void getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ENter the size of the array:");
        size = scanner.nextInt();

        cost = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cost[i][j] = scanner.nextInt();
            }
        }
    }

    public int TSPStart() {
        int vertices = new int[size];
        for (int i = 0; i < size; i++) {
            vertices[i] = i;
        }
        return TSP(0,vertices);
    }

    public int TSP (int node, int vertices[]) {

        if (vertices.length == 0) {
            return cost[0][node];
        }

        vertices = removeElement(vertices, 0);
        vertices = removeElement(vertices, node);
        int minCost = Integer.MAX_VALUE % 10000;
        int totalCost = 0;

        for (int val:vertices) {
            totalCost = cost[node][val] + TSP(val, removeElement(vertices, val));
            if(minCost > totalCost){
                minCost = totalCost;
            }
        }
        return minCost;
    }

    public int[] removeElement(int vertices[], int node) {
        int temp = new int[vertices.length];
        int i = 0;

        for (int val:vertices) {
            if (val != node) {
                temp[i] = val;
                i++;
            }
        }
        return temp;
    }
}
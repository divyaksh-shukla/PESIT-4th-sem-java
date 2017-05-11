import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Item implements Comparable<Item> {
        int p, w;

        Item(int p, int w) {
                this.p = p;
                this.w = w;
        }

        public int compareTo(Item item) {
                return (this.p / this.w) - (item.p / item.w);
        }
}

class Knapsack {
        int n, c, profit, capacity;

        ArrayList<Item> items = new ArrayList<Item>();

        Scanner sc = new Scanner(System.in);

        Knapsack() {
                profit = capacity = 0;
        }

        public int max(int a, int b) {
                return (a > b) ? a : b;
        }

        public void getData() {
                int p, w;

                System.out.print("Enter the number of items : ");
                n = sc.nextInt();
                System.out.print("Enter the knapsack capacity : ");
                c = sc.nextInt();

                for(int i = 0; i < n; i++) {
                        System.out.print("Enter profit for item " + (i + 1) + " : ");
                        p = sc.nextInt();
                        System.out.print("Enter weight for item " + (i + 1) + " : ");
                        w = sc.nextInt();
                        items.add(new Item(p, w));
			System.out.println();
                }
        }

        public void knapsackDynamic() {
                int i = 0, j = 0;
                int v[][] = new int[n + 1][c + 1];

                for(i = 0; i <= n; i++) {
                        for(j = 0; j <= c; j++) {
                                if(i == 0 || j == 0) {
                                        v[i][j] = 0;
                                }
                                else {
                                        v[i][j] = -1;
                                }
                        }
                }

                for(i = 1; i <= n; i++) {
                        for(j = 1; j <= c; j++) {
                                if(items.get(i - 1).w > j) {
                                        v[i][j] = v[i - 1][j];
                                }
                                else {
                                        v[i][j] = max(v[i - 1][j],  items.get(i - 1).p + v[i - 1][j - items.get(i - 1).w]);
                                }
                        }
                }

                profit = v[i - 1][j - 1];
        }

        public void knapsackGreedy() {
                int i = 0, j = 0;

                Collections.sort(items, Collections.reverseOrder());

                while(capacity <= c && i < n) {
                        if(items.get(i).w <= c - capacity) {
                                profit += items.get(i).p;
                                capacity += items.get(i).w;
                        }
                        i++;
                }
        }

        public void displayData() {
                System.out.println("Max profit = " + profit);
                profit = capacity = 0;
        }
}

class MainClass {
        public static void main(String args[]) {

		System.out.println("\t\t0/1 KNAPSACK PROBLEM\n");
                Knapsack knapsack = new Knapsack();

                knapsack.getData();
                
                System.out.println("Dynamic Programming method");
                knapsack.knapsackDynamic();
                knapsack.displayData();
                
                System.out.println("Greedy method");
                knapsack.knapsackGreedy();
                knapsack.displayData();
        }
}

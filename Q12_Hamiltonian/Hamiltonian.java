import java.util.*;

class Hamiltonian {
	static boolean solutionExists;
	int x[];
	int n;
	int adj[][];
	public Hamiltonian(){
		solutionExists = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of vertices:");
		n = sc.nextInt();
		adj =new  int [n][n];
		System.out.println("Enter adjacency matrix:");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				adj[i][j]=sc.nextInt();
			}
		}

		x = new int[n];	
		x[0]=0;
		System.out.println("SOLUTION:");
		hamil(1);
	}
	public void hamil(int k){
		while(true){
			nextValue(k);
			if(x[k] == 0){
				return;
			}
			if(k == n-1){
				solutionExists = true;
				disp();
			}
			else {
				hamil(k+1);
			}
		}
	}
	public void nextValue(int k){
		int j=0;
		while(true){

			x[k] = (x[k]+1)%(n);
			if(x[k] == 0){
				return;	
			}
			if(adj[x[k-1]][x[k]] != 0){
				for(j=0;j<k;j++){
					if(x[k] == x[j])
						break;
				}
				if(j == k){
					if( (k < n-1) || ( ( k==n-1 )&& (adj[x[k]][x[0]] != 0) ) ){
						return;
					}
				}
			}
		}
	}
	public void disp(){
		for(int i=0;i<n-1;i++){
			System.out.print((x[i] + 1) + "->");
		}
		System.out.println(x[n-1] + 1);
	}

} 

class Q12_Hamiltonian {
	public static void main(String args[]){
		System.out.println("\t\tHamiltonian Circuits\n");
		Hamiltonian hamiltonian = new Hamiltonian();
		if(Hamiltonian.solutionExists == false) {
			System.out.println("No Solution Exists");
		}
	}
}

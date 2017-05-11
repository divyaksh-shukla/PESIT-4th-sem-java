import java.util.*;

class Hamiltonian {
	int x[];
	int n;
	int adj[][];
	Hamiltonian(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices");
		n = sc.nextInt();
		adj =new  int [n][n];
		System.out.println("Enter input matrix ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				adj[i][j]=sc.nextInt();
			}
		}
		
		x = new int[n];	
		x[0]=0;
		hamil(1);
	}
	public void hamil(int k){
		while(true){
			nextValue(k);
			if(x[k] == 0){
				return;
			}
			if(k == n-1){
				disp();
				System.out.println();
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
		for(int i=0;i<n;i++){
			System.out.print(" "+x[i]);
		}
	}

} 

class Lab12 {
	public static void main(String args[]){
		new Hamiltonian();
	}
}

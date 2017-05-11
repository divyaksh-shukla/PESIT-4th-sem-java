import java.util.*;

class Subset {
	int sum,w[],x[],n;
	void subset(int s, int k, int r) {
		x[k] = 1;
		if(s+w[k] == sum) {
			System.out.println();
			for(int i=1;i<=k;++i) {
				if(x[i] == 1)
					System.out.print("  "+w[i]);
			}
			System.out.println();
		}
		else if(s+w[k]+w[k+1] <= sum)
			subset(s+w[k],k+1,r-w[k]);
		if( (s+r-w[k])>=sum && (s+w[k+1])<=sum ) {
			x[k]=0;
			subset(s,k+1,r-w[k]);
		}
	}

	void getData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter number of elements :\t");
		n=sc.nextInt();	
		w = new int[n+1];
		x = new int[n+1];
		int total = 0;
		System.out.println("Enter Elements :");
		for(int i=1;i<=n;++i) {
			w[i]=sc.nextInt();
			total+=w[i];
		} 
		System.out.print("Enter Sum :\t");
		sum=sc.nextInt();
		if(total<sum) {
			System.out.print("\nNot Possible\n");
			System.exit(1);
		}
		System.out.println("\nThe Subsets are :\n");
		subset(0,1,total);
	}

	public static void main(String args[]) {
		Subset s = new Subset();
		s.getData();
	}
}

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;

class SortElements {

	private int arr[];
	private int size;

	public final int LOWER = 1000;
	public final int UPPER = 1000000;
	public final int STEP = 100;
	public final int BOUND = 1000;

	public void makeArray(int size) {

		Random random = new Random();
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(BOUND);
		}
		this.size = size;
	}


	public void mergeSort(int low, int high) {

		if(low < high) {
			int mid  = (low + high) / 2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			merge(low, mid, high);
		}
	}

	public void merge(int low, int mid, int high) {

		for(int i = mid+1; i <= high; i++) {
			int value = arr[i];
			int j = i - 1;
			while(j >= low && arr[j] > value){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = value;
		}
	}


	public void printArr() {
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}
}

class Q5_MergeSort {

	public static void main(String args[]) throws IOException {

		SortElements sort = new SortElements();

		FileWriter fileWriter = new FileWriter("MERGE_SORT_TIME.TXT");
		long startTime, finishTime;

		for(int i = sort.LOWER; i <= sort.UPPER; i+=sort.STEP) {

			sort.makeArray(i);
			startTime = System.currentTimeMillis();
			sort.mergeSort(0,i-1);
			//sort.printArr();
			finishTime = System.currentTimeMillis();

			fileWriter.write(""+i+" "+(finishTime - startTime)+"\n");
			fileWriter.flush();
		}
		fileWriter.close();
	}
}

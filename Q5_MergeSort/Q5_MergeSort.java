

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class MergeSort {

    public final int LOWER = 1000;
    public final int UPPER = 100000;
    public final int STEP = 1000;
    public final int BOUND = 1000;
	private int arr[];
	private int size;
	
	public void makeArray(int size) {

        Random random = new Random();
        this.size = size;
        arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = random.nextInt(BOUND);
        }
	}

	public void printArray() {

        for(int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public void mergeSort(int low, int high) {
        if(low < high) {
            int mid = (low + high)/2;
            mergeSort(low,mid);
            mergeSort(mid+1,high);
            merge(low,mid,high);
        }
    }

    public void merge(int low, int mid, int high) {

        for(int i = mid+1; i <= high; i++) {

            int value = arr[i];
            int j = i-1;
            while(j >= low && arr[j] > value) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }
}

class MainClass {
    public static void main(String args[]) throws IOException {

        MergeSort mergeSort = new MergeSort();
        FileWriter fileWriter = new FileWriter("MERGE_SORT_TIME.TXT");
        long startTime, finishTime;

        for (int i = mergeSort.LOWER; i <= mergeSort.UPPER; i += mergeSort.STEP) {
            mergeSort.makeArray(i);

            startTime = System.currentTimeMillis();
            mergeSort.mergeSort(0,i-1);
            //mergeSort.printArray();
            finishTime = System.currentTimeMillis();

            fileWriter.write(""+i+" "+(finishTime-startTime)+"\n");
            fileWriter.flush();
        }

        fileWriter.close();
    }
}

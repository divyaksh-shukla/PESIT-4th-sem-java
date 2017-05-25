import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class QuickSort {

	public final int LOWER = 1000;
	public final int UPPER = 1000000;
	public final int STEP = 100;
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

	public void quickSort(int left, int right) {
		if(left < right) {
			int mid = partition(left, right);

			quickSort(left, mid - 1);
			quickSort(mid + 1, right);
		}
	}

	public int partition(int left, int right) {

		int p = arr[left];
		int i = left;
		int j = right + 1;
		int temp;

		do {
			do {
				i++;
			}while ( i != right && arr[i] < p);
			do {
				j--;
			}while (j != left && arr[j] >= p);

			if(i < j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}while (!(i >= j));

		//Swap pivot with partition location so that the array could be parted
		temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;

		return j;
	}
}

class Q4_QuickSort {
	public static void main(String args[]) throws IOException {

		QuickSort quickSort = new QuickSort();
		FileWriter fileWriter = new FileWriter("QUICK_SORT_TIME.TXT");
		long startTime, finishTime;

		for (int i = quickSort.LOWER; i <= quickSort.UPPER; i += quickSort.STEP) {
			quickSort.makeArray(i);

			startTime = System.currentTimeMillis();
			quickSort.quickSort(0,i - 1);
			//quickSort.printArray();
			finishTime = System.currentTimeMillis();

			fileWriter.write(""+i+" "+(finishTime-startTime)+"\n");
			fileWriter.flush();
		}

		fileWriter.close();
	}
}

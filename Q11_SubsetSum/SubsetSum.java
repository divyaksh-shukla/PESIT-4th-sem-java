import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class SubsetSum {
    int data[];
    int size;
    int finalSum;
    Stack<Integer> stack;

    public void getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the set:");
        size = scanner.nextInt();
        System.out.println("Enter the set data:");
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = scanner.nextInt();
        }

        System.out.print("Enter the final required sum:");
        finalSum = scanner.nextInt();

        stack = new Stack<Integer>();
    }

    public void subsetSum(int index,int sum) {
        int currsum = 0;

        for (int i = index; i < size; i++) {
            currsum = sum + data[i];

            if(currsum > finalSum)
                return;
            else if (currsum == finalSum) {

                stack.push(new Integer(data[i]));
                printStack();
                stack.pop();

                return;
            }
            stack.push(new Integer(data[i]));
            subsetSum(i + 1, currsum);
            stack.pop();
        }
    }

    public void printStack() {

        System.out.print("SOLUTION: ");
        /*for (int i = 0; i < stack.capacity() - 1; i++) {
            System.out.print(stack.elementAt(i) + ",");
        }*/
        System.out.print(Arrays.toString(stack.toArray()));
        System.out.println();
    }
}

class Q11_SubsetSum {
    public static void main(String args[]) {
        System.out.println("\t\tSUBSET SUM\n");
        SubsetSum subsetSum = new SubsetSum();
        subsetSum.getData();
        subsetSum.subsetSum(0,0);
    }
}

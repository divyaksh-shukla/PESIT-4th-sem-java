import java.util.Scanner;
import java.util.Random;

class Values {

	public static int num;
	public static int square;
	public static int cube;

	public static final int BOUND = 1000;
	public static final int MAX = 10;
	public static final int SLEEP = 200;
}

class Generator extends Thread {

	public void run() {

		Random random = new Random();
		Values.num = random.nextInt(Values.BOUND);
		System.out.println("Number:" + Values.num);

		Square s = new Square();
		Cube c = new Cube();

		try {
			Thread.sleep(Values.SLEEP);
//		}
//		catch (InterruptedException e) {
//			System.out.println("Inerrupt Exception called...");
//		}

		s.start();
//
//		try {
			Thread.sleep(Values.SLEEP);
//		}
//		catch (InterruptedException e) {
//			System.out.println("Inerrupt Exception called...");
//		}

		c.start();
	} catch(InterruptedException e){
	
	}
	}
}

class Square extends Thread {

	public void run() {
		Values.square = Values.num * Values.num;
		System.out.println("Square:" + Values.square);
	}
}

class Cube extends Thread {

	public void run() {
		Values.cube = Values.num * Values.num * Values.num;
		System.out.println("Cube:" + Values.cube + "\n");
	}
}

class Q3b_Multithreading {

	public static void main(String args[]) {

		for(int i = 0; i < Values.MAX; i++) {

			Generator g = new Generator();
			g.start();
			try {
				Thread.sleep(Values.SLEEP * 5);
			}
			catch(InterruptedException e) {
				System.out.println("Interrupt Exception called...");
			}

		}
	}
}

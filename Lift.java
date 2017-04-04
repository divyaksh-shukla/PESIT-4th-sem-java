package liftProjectV1;

/**
 * Created by divyaksh on 17/2/17.
 */
import java.util.PriorityQueue;
import java.util.Queue;

class LiftMovement {

    private static final int SIZE = 10;
    private static final int OPEN_DR = 0;
    private static final int MOVE_UP = 1;
    private static final int MOVE_DN = 2;
    private static final int IDLE_ST = 3;
    private static final int DIR_UP = 0;
    private static final int DIR_DN = 1;

    public Queue<Integer> upQueue = new PriorityQueue<>(SIZE);
    public Queue<Integer> downQueue = new PriorityQueue<>(SIZE);

    int currentFloor, previousFloor, requestFloor, dir;

    public LiftMovement() {
        currentFloor = 1;
        previousFloor = 1;
        requestFloor = 1;
        dir = DIR_UP;
    }

    public void setDir() {
        if(currentFloor > previousFloor) {
            dir = DIR_UP;
        } else if(currentFloor < previousFloor){
            dir = DIR_DN;
        }
    }

    public void updateQueues() {
        if(requestFloor > currentFloor) {
            upQueue.add(requestFloor);
        } else {
            downQueue.add(requestFloor);
        }
    }

    public int checkQueue(int d) {
        if(d == DIR_UP) {
            if(upQueue.isEmpty()) {
                if(downQueue.isEmpty()) {
                    return IDLE_ST;
                } else {
                    return MOVE_DN;
                }
            } else {
                return MOVE_UP;
            }
        } else { // dir = DN
            if(downQueue.isEmpty()) {
                if(upQueue.isEmpty()) {
                    return IDLE_ST;
                } else {
                    return MOVE_UP;
                }
            } else {
                return MOVE_DN;
            }
        }
    }

    public int liftAction() {
        if(currentFloor == requestFloor && currentFloor != previousFloor) {
            if(upQueue.contains(currentFloor)) {
                upQueue.remove();
            } else if(downQueue.contains(currentFloor)) {
                downQueue.remove();
            } else {
                return IDLE_ST;
            }
            return OPEN_DR;
        } else {
            return checkQueue(dir);
        }
    }

    // Call before opening door and after closing door
    // To be called on movement of lift on each floor Argument: Floor number
    public int setCurrentFloor(int f) {
        setDir();
        previousFloor = currentFloor;
        currentFloor = f;

        if(dir == DIR_UP) {
            if(!upQueue.isEmpty()) {
                requestFloor = upQueue.remove();
                upQueue.add(requestFloor);
            }
        } else {
            if(!downQueue.isEmpty()) {
                requestFloor = downQueue.remove();
                downQueue.add(requestFloor);
            }
        }

        return liftAction();
    }

    // To be called by respective button inside and outside the lift Argument: Requested Floor Number
    public int setRequestFloor(int f) {
        requestFloor = f;
        updateQueues();

        return liftAction();
    }
}

class LiftClass {
	
	
public static void main(String args[]) {
        LiftMovement ob = new LiftMovement();

        System.out.println(ob.setCurrentFloor(2));
        System.out.println(ob.setRequestFloor(6));

        System.out.println(ob.setCurrentFloor(3));
        System.out.println(ob.setRequestFloor(4));

        System.out.println(ob.setCurrentFloor(4));
        System.out.println(ob.setRequestFloor(2));

        System.out.println(ob.setCurrentFloor(5));

        System.out.println(ob.setCurrentFloor(6));
        System.out.println(ob.setCurrentFloor(6));  // After closing door

        System.out.println(ob.setCurrentFloor(5));

        System.out.println(ob.setCurrentFloor(4));

        System.out.println(ob.setCurrentFloor(3));

        System.out.println(ob.setCurrentFloor(2));
        System.out.println(ob.setCurrentFloor(2));
        System.out.println(ob.setCurrentFloor(2));

        System.out.println(ob.setRequestFloor(6));
    }
}

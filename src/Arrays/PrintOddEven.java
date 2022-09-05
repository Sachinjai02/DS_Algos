package Arrays;

import java.util.concurrent.Semaphore;

public class PrintOddEven {

    private volatile int counter = 1;
    private int MaxNumber;

    private Semaphore oddSema = new Semaphore(1);
    private Semaphore evenSema = new Semaphore(0);

    private void printOdd() {
        while(true) {
            try {
                oddSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (counter > MaxNumber) {
                evenSema.release();
                return;
            }
            System.out.println(counter++ + " by " + Thread.currentThread().getName());
            evenSema.release();
        }
    }

    private void printEven()  {
        while(true) {
            try {
                evenSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (counter > MaxNumber) {
                oddSema.release();
                return;
            }
            System.out.println(counter++ + " by " + Thread.currentThread().getName());
            oddSema.release();
        }
    }

    public static void main(String[] args) {
        PrintOddEven printer = new PrintOddEven();
        printer.MaxNumber = 10;
        Thread t1 = new Thread(()-> {
            printer.printOdd();
        });

        Thread t2 = new Thread(()-> {
            printer.printEven();
        });
        t1.start();
        t2.start();
    }
}

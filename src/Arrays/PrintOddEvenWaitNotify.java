package Arrays;

public class PrintOddEvenWaitNotify {
    private volatile int counter = 1;
    private int maxNumber;

    private void printOdd() {
        synchronized (this) {
            while (counter <= maxNumber) {
                if (counter % 2 != 0) {
                    System.out.println(counter++ + " by " + Thread.currentThread().getName());
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void printEven() {
        synchronized (this) {
            while (counter <= maxNumber) {
                if (counter % 2 == 0) {
                    System.out.println(counter++ + " by " + Thread.currentThread().getName());
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintOddEvenWaitNotify printer = new PrintOddEvenWaitNotify();
        printer.maxNumber = 551;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printOdd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printEven();
            }
        });
        t1.start();
        t2.start();
    }
}

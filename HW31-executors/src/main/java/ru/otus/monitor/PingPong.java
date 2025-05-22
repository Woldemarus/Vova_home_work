package ru.otus.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingPong {
    private static final Logger logger = LoggerFactory.getLogger(PingPong.class);
    private boolean isFirstThreadTurn = true;
    private int thread1Number = 1;
    private int thread2Number = 1;
    private boolean thread1Ascending = true;
    private boolean thread2Ascending = true;

    private synchronized void action(boolean isFirstThread) {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                while (isFirstThread != isFirstThreadTurn) {
                    this.wait();
                }

                int currentNumber;
                
                if (isFirstThread) {
                    currentNumber = thread1Number;
                    
                    if (currentNumber == 10) {
                        thread1Ascending = false;
                    } else if (currentNumber == 1) {
                        thread1Ascending = true;
                    }
                    
                    thread1Number = thread1Ascending ? currentNumber + 1 : currentNumber - 1;
                } else {
                    currentNumber = thread2Number;
                    
                    if (currentNumber == 10) {
                        thread2Ascending = false;
                    } else if (currentNumber == 1) {
                        thread2Ascending = true;
                    }
                    
                    thread2Number = thread2Ascending ? currentNumber + 1 : currentNumber - 1;
                }

                logger.info("Поток {}: {}", isFirstThread ? "1" : "2", currentNumber);
                
                isFirstThreadTurn = !isFirstThreadTurn;
                sleep();
                notifyAll();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        new Thread(() -> pingPong.action(true)).start();
        new Thread(() -> pingPong.action(false)).start();
    }

    private static void sleep() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

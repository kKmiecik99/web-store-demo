package pl.sda.intermediate25.bank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankExample {

    @Test
    public void bankTest() {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // tworzymy pracownika(Thread) i dajemy mu prace do wykonania (Transaction)
            Thread th = new Thread(new Transaction());
            threadList.add(th);
        }
        threadList.forEach(thread -> thread.start());
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("final balance = " + Bank.getBalance());
        System.out.println("final counter = " + Bank.getCounter());
    }
}

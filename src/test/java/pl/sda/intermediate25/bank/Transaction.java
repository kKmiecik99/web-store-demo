package pl.sda.intermediate25.bank;

import java.util.Random;

public class Transaction implements Runnable {

    @Override
    public void run() {
        Integer amount = new Random().nextInt(100);
        Bank.withdraw(amount);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bank.deposit(amount);

    }
}

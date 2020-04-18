package pl.sda.intermediate25.bank;


import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    @Getter
    private static AtomicInteger balance = new AtomicInteger(1000);
    @Getter
    private static AtomicInteger counter = new AtomicInteger(0);

    public static /*synchronized*/ void withdraw(Integer amount) {
        balance.getAndAdd(-amount);
        System.out.println(Thread.currentThread().getName() + "Im in withdraw and balance is " + balance);
    }

    public static /*synchronized*/ void deposit(Integer amount) {
        balance.getAndAdd(amount);
        counter.getAndIncrement();
        System.out.println(Thread.currentThread().getName() + "Im in deposit and balance is " + balance);
        System.out.println("counter value = " + counter);
    }
}

package pl.sda.intermediate25;

import org.junit.jupiter.api.Test;

public class ThreadsExample {

    @Test
    void runnableBasic() {

        Runnable ourRunnable = new OurRunnable();
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " im in anonymous Runnable");
            }
        };

        Runnable lambdaRunnable = () -> System.out.println(Thread.currentThread().getName() + " im in lambda Runnable ");
//        anonymousRunnable.run();
//        lambdaRunnable.run();
        Thread thread1 = new Thread(ourRunnable);
        Thread thread2 = new Thread(anonymousRunnable);
        Thread thread3 = new Thread(lambdaRunnable);
//        thread1.run(); wykonanie metody run spowoduje odpalenie pracy w Mainie
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

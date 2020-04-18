package pl.sda.intermediate25;

public class OurRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " jakis napis z klasy OurRunnable");
    }
}

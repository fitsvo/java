import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    CyclicBarrier cb;
    CountDownLatch cdlStart;
    CountDownLatch cdlEnd;
    Lock lock = new ReentrantLock();

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdlStart, CountDownLatch cdlEnd, Lock lock) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
        this.cdlStart = cdlStart;
        this.cdlEnd = cdlEnd;
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdlStart.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
                cb.await();
        }
        catch (Exception e) {
                e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        cdlEnd.countDown();
        if(lock.tryLock()){
            lock.lock();
            System.out.println(this.name + " - WINNER!!!");
        }
    }
}

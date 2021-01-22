import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
        public static final int CARS_COUNT = 4;
        public static void main(String[] args) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Semaphore smp = new Semaphore(CARS_COUNT / 2);
            CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
            CountDownLatch cdlStart = new CountDownLatch(CARS_COUNT);
            CountDownLatch cdlEnd = new CountDownLatch(CARS_COUNT);
            Lock lock = new ReentrantLock();

            Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));
            Car[] cars = new Car[CARS_COUNT];

            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdlStart, cdlEnd, lock);
            }


            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
            try {
                cdlStart.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            try {
                cdlEnd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
}

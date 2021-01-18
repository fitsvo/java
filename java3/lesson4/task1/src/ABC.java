public class ABC {
    static final Object mon = new Object();
    static volatile char currentLetter = 'A';

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                printLetter('A', 'B');

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                printLetter('B', 'C');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                printLetter('C', 'A');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static char printLetter(char printLetter, char setLetter) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            synchronized (mon) {
                while (currentLetter != printLetter) {
                    mon.wait();
                }
                System.out.print(printLetter);
                currentLetter = setLetter;
                mon.notifyAll();
            }
        }
        return currentLetter;
    }
}

public class ThreadArrayExample implements Runnable {
    private int id;

    public ThreadArrayExample(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Thread-" + id + " 시작");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread-" + id + " 종료");
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ThreadArrayExample(i));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("모든 스레드 종료");
    }
}
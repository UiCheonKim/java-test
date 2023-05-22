public class ThreadJoinExample implements Runnable {
    private int id;

    public ThreadJoinExample(int id) {
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

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        // 5개의 스레드를 생성하고 실행시킵니다.
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new ThreadJoinExample(i));
            threads[i].start();
        }

        // 모든 스레드가 종료될 때까지 대기합니다.
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("모든 스레드 종료");
    }
}

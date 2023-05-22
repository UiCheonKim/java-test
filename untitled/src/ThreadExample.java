public class ThreadExample extends Thread {
    private int count;

    public ThreadExample(int count) {
        this.count = count;
    }

    public void run() {
        System.out.println("Thread-" + count + " 시작");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread-" + count + " 종료");
    }

    public static void main(String[] args) {
        ThreadExample thread1 = new ThreadExample(1);
        ThreadExample thread2 = new ThreadExample(2);
        ThreadExample thread3 = new ThreadExample(3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
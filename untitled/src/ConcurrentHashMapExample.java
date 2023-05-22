import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample extends Thread {
    private static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
    private int id;

    public ConcurrentHashMapExample(int id) {
        this.id = id;
    }

    public void run() {
        // 1000번 반복하면서 map에 key-value 쌍을 추가합니다.
        for (int i = 0; i < 1000; i++) {
            map.put(i, "Thread-" + id);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 10개의 스레드를 생성하여 실행합니다.
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ConcurrentHashMapExample(i);
            threads[i].start();
        }

        // 모든 스레드가 종료될 때까지 대기합니다.
        for (Thread thread : threads) {
            thread.join();
        }

        // 결과를 출력합니다.
        System.out.println("Map size: " + map.size());
    }
}
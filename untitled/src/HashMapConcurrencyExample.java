import java.util.HashMap;

/*
    아래 예제에서는 10개의 스레드가 HashMap 에 값을 추가합니다.
    각 스레드는 0부터 999까지의 key-value 쌍을 추가합니다.
    그러나 여러 스레드가 동시에 같은 key 에 접근하면서 값이 덮어써질 가능성이 있으므로,
    실행 결과에 따라 map 의 크기가 예상과 다를 수 있습니다.

    따라서 멀티스레드 환경에서 HashMap 을 사용할 때에는
    ConcurrentHashMap 등의 스레드 세이프한 맵을 사용하는 것이 좋습니다.
 */
public class HashMapConcurrencyExample extends Thread {
    private static HashMap<Integer, String> map = new HashMap<Integer, String>();
    private int id;

    public HashMapConcurrencyExample(int id) {
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
            threads[i] = new HashMapConcurrencyExample(i);
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
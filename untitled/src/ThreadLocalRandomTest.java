import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    private static volatile BigInteger nonce = BigInteger.TEN;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 101); // 1~100 사이의 랜덤 값 생성
//                System.out.println("랜덤 숫자: " + randomNum);

                synchronized (ThreadLocalRandomTest.class) {
                    nonce = nonce.add(BigInteger.valueOf(randomNum));
                    System.out.println("nonce 값: " + nonce);
                }

                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 101); // 1~100 사이의 랜덤 값 생성
//                System.out.println("랜덤 숫자: " + randomNum);

                synchronized (ThreadLocalRandomTest.class) {
                    nonce = nonce.add(BigInteger.valueOf(randomNum));
                    System.out.println("nonce 값: " + nonce);
                }

                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}

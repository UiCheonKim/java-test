public class ErrorTest {
    public static void main(String[] args) {
        try {
            throw new Exception("고의로 발생시켰음.");
        } catch (Exception e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        }
    }
}
import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModelViewTest {
    public static void main(String[] args) {

        Corgi corgi = new Corgi("viewNameCorgi");

        corgi.getModel().put("Kim", "10");
        corgi.getModel().put("Lee", "11");
        corgi.getModel().put("Choi", "12");
        corgi.getModel().put("Kang", "13");

        System.out.println(corgi.getViewName());
        System.out.println(corgi.getModel().get("Kim"));
        Collection<String> values = corgi.getModel().values();
        for (String value : values) {
            System.out.println(value);
        }

        // generateLottoNumbers() 메소드를 호출하여 로또 번호 생성
        int[] lottoNumbers = generateLottoNumbers();

        // 로그 출력
        for (int lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }


    }


    public static class Corgi {
        private String viewName;
        private Map<String, String> model = new HashMap<>();


        public Corgi(String viewName) {
            this.viewName = viewName;
        }

        public String getViewName() {
            return viewName;
        }

        public void setViewName(String viewName) {
            this.viewName = viewName;
        }

        public Map<String, String> getModel() {
            return model;
        }

        public void setModel(Map<String, String> model) {
            this.model = model;
        }

    }

    // 로또 번호 생성
    public static int[] generateLottoNumbers() {
        SecureRandom random = new SecureRandom();
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < lottoNumbers.length; i++) {
            int number = random.nextInt(45) + 1;
            if (isDuplicated(lottoNumbers, number)) {
                i--;
                continue;
            }
            lottoNumbers[i] = number;
        }
        return lottoNumbers;
    }

    private static boolean isDuplicated(int[] lottoNumbers, int number) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber == number) {
                return true;
            }
        }
        return false;
    }

    // web3j 라이브러리를 이용한 니모닉 코드 생성


}

public class TypeCheckTest {
    public static void main(String[] args) {
        String str1 = "123";
        Integer int1 = 123;
        String oriFileExt = "cute.jpg";
        oriFileExt = oriFileExt.substring(oriFileExt.lastIndexOf("."));
        System.out.println(oriFileExt);

        System.out.println(str1 + "의 타입: " + determineType(str1));
        System.out.println(int1 + "의 타입: " + determineType(int1.toString()));
    }

    public static boolean determineType(String obj) {
        try {
            Integer.parseInt(obj);
        } catch (NumberFormatException e1) {
            try {
                Double.parseDouble(obj);
            } catch (NumberFormatException e2) {
                return false;
            }
        }
        return true;
    }

}


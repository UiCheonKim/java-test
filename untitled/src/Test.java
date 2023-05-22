import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(Dog.valueOf("WELSHCORGI").getNum());
        System.out.println(Dog.valueOf("WELSHCORGI").getDog());

        Method[] welshcorgis = Dog.valueOf("WELSHCORGI").getClass().getDeclaredMethods();
        for(Method method : welshcorgis) {
            System.out.println("method.getName() = " + method.getName());
        }
        

        for (Dog dog : Dog.values()){
            System.out.println("dog = " + dog.getDog());
        }

        Dog dog1 = Dog.WELSHCORGI;
        System.out.println("dog.ordinal() = " + dog1.ordinal());

        Dog dog2 = Dog.SIBADOG;
        System.out.println("dog.ordinal() = " + dog2.ordinal());
    }

    public enum Dog {
        WELSHCORGI(100, "웰시코기"),
        SIBADOG(200, "시바견");

        private final int num;
        private final String dog;
        Dog(int num, String dog) {
            this.num = num;
            this.dog = dog;
        }
        public int getNum() {
            return num;
        }

        public String getDog() {
            return dog;
        }
    }

}

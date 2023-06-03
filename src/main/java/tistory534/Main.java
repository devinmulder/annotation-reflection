package tistory534;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Hello hello = new Hello();

        try {
            Method method = hello.getClass().getDeclaredMethod("hello");
            if (method.isAnnotationPresent(DoRepeat100.class)) {
                System.out.println("어노테이션이 존재합니다.");
                for (int i = 0; i < 5; i++) {
                    hello.hello();
                }
            } else {
                System.out.println("어노테이션이 존재하지 않습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

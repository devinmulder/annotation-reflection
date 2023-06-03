package codingwithjohn;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatingAnnotations {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat myCat = new Cat("Stella");
        Dog myDog = new Dog("Jerry");

        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This thing is very important");

        } else {
            System.out.println("This thing is not very important :(");
        }

        Method[] methods = myCat.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RunImmediately.class)) {

                RunImmediately annotation = method.getAnnotation(RunImmediately.class);

                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(myCat);
                }

            }
        }


        Field[] fields = myCat.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object o = field.get(myCat);

                if (o instanceof String) {
                    String value = (String) o;
                    System.out.println("value = " + value);
                }
            }

        }


    }
}

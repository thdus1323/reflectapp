package ex02;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        String path = "/updatePassword";

        UserController con = new UserController();

        //UserController의 클래스를 들고와서 거기 안에 있는 메서드 다 들고와
        Method[] methods = con.getClass().getDeclaredMethods();
//        System.out.println(methods.length);
//
        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;

            if (rm.uri().equals(path)) {
                try {
                    method.invoke(con); // =con.login()이랑 같은 코드임
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

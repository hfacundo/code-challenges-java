package com.challenge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

    public void method() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main m = new Main();
        Method method = m.getClass().getMethod("testReflection");
        method.setAccessible(true);
        System.out.println(method.invoke(m));
    }

    public static void main(String[] args) {
        ReflectionExample r = new ReflectionExample();
        try {
            r.method();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

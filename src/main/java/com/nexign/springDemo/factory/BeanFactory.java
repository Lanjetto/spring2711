package com.nexign.springDemo.factory;

import com.nexign.springDemo.annotation.Inject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BeanFactory {
    private static  ApplicationContext context = new ApplicationContext();

    public static <T> T getBean(Class<T> clazz) {

        T bean = null;
        try {
            bean = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException
                 | IllegalAccessException
                 | InvocationTargetException
                 | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, context.getBean(field.getType()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

}

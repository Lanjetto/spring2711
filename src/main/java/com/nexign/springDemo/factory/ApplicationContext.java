package com.nexign.springDemo.factory;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private  final Map<Class<?>, Object> cache = new HashMap<>();

    public <T> T getBean(Class<T> clazz) {
        if (cache.containsKey(clazz)) {
            return (T) cache.get(clazz);
        }
        T bean = BeanFactory.getBean(clazz);
        System.out.println("bean created");
        cache.put(clazz, bean);
        return bean;
    }
}

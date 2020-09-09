package com.xwzj.spring.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPoint extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
}

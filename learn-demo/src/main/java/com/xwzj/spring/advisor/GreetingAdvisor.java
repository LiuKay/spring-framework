package com.xwzj.spring.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

@SuppressWarnings("serial")
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }
}

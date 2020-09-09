package com.xwzj.spring.advisor;

import org.springframework.aop.framework.ProxyFactory;

public class AdvisorTest {
    public static void main(String[] args) {


     /*   ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("advisorBeans.xml");

        Waiter waiter = (Waiter) classPathXmlApplicationContext.getBean("waiter");
        Seller seller = (Seller) classPathXmlApplicationContext.getBean("seller");

        waiter.greetTo("xxx");

        seller.greetTo("==");*/
        testByProxyFactory();
    }

    /**
     * ProxyFactory使用addAdvisor添加StaticMethodMatcherPointcutAdvisor的实现类
     * 代理接口实现类正常，代理非接口实现类，会报错无法生成CGLib对象子类
     */
    public static void testByProxyFactory() {
        ProxyFactory proxyFactory = new ProxyFactory();

        // StaticMethodMatcherPointcutAdvisor的实现类

		GreetingAdvisor greetingAdvisor = new GreetingAdvisor();
		greetingAdvisor.setAdvice(new GreetingBeforeAdvice());

		proxyFactory.addAdvice(new GreetingBeforeAdvice());
		proxyFactory.addAdvisor(greetingAdvisor);

        //DynamicMethodMatcherPointcut实现类
      /*  DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(new GreetingDynamicPoint());
        defaultPointcutAdvisor.setAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvisor(defaultPointcutAdvisor);*/
        // 正常
//        Sport sport = new BasketBall();
//        proxyFactory.setTarget(sport);
//        Sport sportProxy = (Sport) proxyFactory.getProxy();
//        sportProxy.run("ball");
//        System.out.println("===================================");

        // 异常
        Waiter waiter = new Waiter();
        proxyFactory.setTarget(waiter);
        Waiter waiterProxy = (Waiter) proxyFactory.getProxy();
        waiterProxy.greetTo("John");
    }
}

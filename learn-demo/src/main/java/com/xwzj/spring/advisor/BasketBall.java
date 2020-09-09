package com.xwzj.spring.advisor;

public class BasketBall implements Sport {
    @Override
    public void run(String name) {
        System.out.println("BasketBall" + name);
    }
}

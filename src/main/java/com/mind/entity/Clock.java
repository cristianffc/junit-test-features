package com.mind.entity;

public class Clock {

    public void sleep(int time) {
        System.out.println("Before timeout");
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        System.out.println("After timeout");
    }
}

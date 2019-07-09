package com.tiantianchat.heartstone.test;

/**
 * @author Ramble
 */
public class Test {
    public static void main(String[] args) {
        Father f = new Father();
        Son s1 = new Son();
        Son s2 = new Son();

        s1.setName("aaa");
        s2.setName("bbb");

        System.out.println(f.getName());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.getName());
        System.out.println(s2.getName());
    }
}

package com.gwnu.mybatis.chap02.lifecycle;

import static com.gwnu.mybatis.chap02.lifecycle.Template.getSqlSession;

public class Application {
    public static void main(String[] args) {
        System.out.println("1st Time!");
        getSqlSession();

        System.out.println("2nd Time!");
        getSqlSession();

        System.out.println("3rd Time!");
        getSqlSession();
    }
}

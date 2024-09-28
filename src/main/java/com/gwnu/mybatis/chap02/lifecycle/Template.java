package com.gwnu.mybatis.chap02.lifecycle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if(sqlSessionFactory == null) {
            // factory 객체 생성
            String resource = "mybatis-config.xml"; // resource에서의 상대 경로

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        SqlSession session = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory hashCode() = " + sqlSessionFactory.hashCode());
        System.out.println("sqlSession hashCode() = " + session.hashCode());

        return session;
    }
}

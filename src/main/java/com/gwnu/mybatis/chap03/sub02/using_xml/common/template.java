package com.gwnu.mybatis.chap03.sub02.using_xml.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class template {
    private static SqlSessionFactory sqlSessionFactory;
    // SqlSessionFactory는 MyBatis 라이브러리에서 제공하는 클래스

    public static SqlSession getSqlSession() {

        if(sqlSessionFactory == null) {
            String resource = "com/gwnu/mybatis/chap03/sub02/using_xml/mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return sqlSessionFactory.openSession(false);
    }
}

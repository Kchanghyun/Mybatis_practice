package com.gwnu.mybatis.chap03.sub01.using_interface.common;

import com.gwnu.mybatis.chap03.sub01.using_interface.model.dao.DepartmentMapper;
import com.gwnu.mybatis.chap03.sub01.using_interface.model.dao.EmployeeMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://dokalab.iptime.org:10992/db_gwteam";
    private static String USER = "gwteam";
    private static String PASSWORD = "gwteam";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) { // 아직 생성되지 않았다면
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(), // JDBC를 사용한 트랜잭션 처리를 위한 팩토리
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD) // 데이터베이스 연결을 관리하기 위한 커넥션 풀
            );
            Configuration configuration = new Configuration(environment); // MyBatis의 설정 클래스, 매퍼와 환경 설정을 포함

            configuration.addMapper(DepartmentMapper.class);
            configuration.addMapper(EmployeeMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        return sqlSessionFactory.openSession(false); // 새로운 SqlSession을 생성, false를 전달하면 자동 커밋이 비활성화
    }
}

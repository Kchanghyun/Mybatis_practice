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
        if (sqlSessionFactory == null) {
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD)
            );
            Configuration configuration = new Configuration(environment);

            configuration.addMapper(DepartmentMapper.class);
            configuration.addMapper(EmployeeMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        return sqlSessionFactory.openSession(false);
    }
}

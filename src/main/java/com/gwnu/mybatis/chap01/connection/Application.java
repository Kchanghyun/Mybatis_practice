package com.gwnu.mybatis.chap01.connection;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.Connection;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://dokalab.iptime.org:10992/db_gwteam";
        final String USERNAME = "gwteam";
        final String PASSWORD = "gwteam";
        // 데이터 베이스 서버와 연결하기 위한 변수들..?
        /*
         * DB접속에 관한 환경 설정
         * ===================================
         * JdbcTransactionFactory : 수동 커밋
         * ManagedTransactionFactory : 자동 커밋
         * =======================================
         * PooledDataSource : ConnectionPool 사용
         * UnpooledDataSource : ConnectionPool 미사용
         * -> ConnectionPool은 DB와의 연결을 미리 만들어 놓고, 필요할 때마다 빌려주고 반납받는 방식
         * -> ConnectionPool을 사용하면 DB와의 연결을 매번 생성하는 비용을 줄일 수 있다.
         * 반대로 UnpooledDataSource는 매번 새로운 Connection을 생성한다. (비효율적)
         * =========================================
         * */
        // 트랜젝션을 쓰는 이상 자동 커밋은 쓰지 않는다.

        // Step1. Database에 대한 연결 환경 정보를 설정한다.
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD)
        );

        // Step2. Connection(Session)을 위한 Config 객체 생성
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(Mapper.class); // Mapper(인터페이스)를 사용해서
                                                // MyBatis 프레임워크 내에서 사용할
                                                // Mapper 타입의 Bean을 만들어 등록한다.

        // Step3. SqlSessionFactory 객체 생성
        /*
         * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할
         * build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된
         *           Stream을 매개변수로 전달하면 SqlSessionFactory 인터페이스 타입의 객체를 반환하는 메소드
         * */
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        // Step4. 연결 정보 객체 생성
        SqlSession session = sqlSessionFactory.openSession();
        Mapper mapper = session.getMapper(Mapper.class);

        // Step5. 실제로 사용해보기
        Date curDate = mapper.getCurrentDate();
        System.out.println(curDate);

        // Step6. Session close
        session.close();
    }
}

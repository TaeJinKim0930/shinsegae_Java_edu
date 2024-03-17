package com.ssg.springex.sample;

import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class) // Junit5 에서 사용하는 'spring-text'
// spring container 에 내가 등록한 beans 을 가져다가 이 파일에서 configuration 을 하겠다는 뜻
// 스프링의 설정 정보를 로딩하기 위해 사용
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    @Autowired // 만일 해당 타입의 Bean 이 존재한다면 여기에 주입해 주길 원한다.
    private SampleService sampleService;

    @Autowired
    private DataSource ds;

    @Test
    public void testService1() {
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testConnection() throws Exception {
        Connection connection = ds.getConnection();
        Assertions.assertNotNull(connection);
        connection.close();
    }
}

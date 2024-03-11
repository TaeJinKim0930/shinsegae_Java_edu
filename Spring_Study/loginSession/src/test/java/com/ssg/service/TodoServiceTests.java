package com.ssg.service;

import com.example.jdbcex.dao.TodoDAO;
import com.example.jdbcex.domain.TodoVO;
import com.example.jdbcex.dto.TodoDTO;
import com.example.jdbcex.todoService.TodoServiceEnum;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    // 1.TodoService 객체 선언
    private TodoServiceEnum todoServiceEnum;

    // 2. @BeforeEach 를 통해서 ready() 메소드를 이용하여 TodoService 객체 생성
    @BeforeEach
    public void ready() {
        todoServiceEnum = TodoServiceEnum.INSTANCE;
    }

    // 3. @Test : testRegister 메소드에 TodoDTO 하나를 빌더를 통해서 (title, dueDate)를 생성
    @Test
    public void testRegister() {
        TodoDTO todoDTO = new TodoDTO().builder()
                .title("hihh")
                .dueDate(LocalDate.now())
                .build();
        System.out.println(todoDTO);
        log.info(todoDTO);
        todoServiceEnum.register(todoDTO);
    }

    // 4. testRegister() 실행한 후 정상적으로 TodoVO 의 내용이 출력되는지 확인

    // 5. tbl_todo 테이블에 insert가 정상적으로 입력 되었는지 확인

}

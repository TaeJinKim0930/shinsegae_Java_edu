package com.ssg.dao;

import com.example.jdbcex.dao.TodoDAO;
import com.example.jdbcex.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder().title("hi").dueDate(LocalDate.now()).finished(false).build();
        todoDAO.insert(todoVO);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;
        TodoVO todoVO = todoDAO.selectOne(tno);
        System.out.println(todoVO);
    }

    @Test
    public void deleteOne() throws Exception {
        Long tno = 1L;
        todoDAO.deleteOne(tno);

    }

    @Test
    public void updateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder().tno(1L).title("h2").dueDate(LocalDate.now()).finished(false).build();
        todoDAO.updateOne(todoVO);
    }

}

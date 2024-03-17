package com.ssg.todoservice.mapper;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PageResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import com.ssg.todoservice.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {
    @Autowired(required = false)
    private TodoMapper todoMapper;



    @Test
    public void testGetTimeNow() {
        log.info(todoMapper.getTime());
    }

    @Test public void testInsert() {
        TodoVO todoVO = new TodoVO().builder()
                .title("title2")
                .dueDate(LocalDate.now())
                .writer("TJK")
                .build();
        todoMapper.insert(todoVO);

        log.info("insertion made");
    }

    @Test
    public void testSelectAll() {
        List<TodoVO> list = todoMapper.selectAll();
        list.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        TodoVO vo = todoMapper.selectOne(3L);
        log.info("vo: " + vo);
    }

    @Test
    public void testDelete() {
        todoMapper.delete(5L);
        log.info("Deletion Succeed");
    }

    @Test
    public void testUpdate() {
        TodoVO todoVO = new TodoVO().builder()
                .tno(3L)
                .title("title3")
                .dueDate(LocalDate.now())
                .writer("TJK")
                .build();
        todoMapper.update(todoVO);
    }

    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }


}

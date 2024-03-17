package com.ssg.todoservice.service;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PageResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor // 생성자 DI 방식으로 필요한 BEAN 주입
public class TodoServiceImpl implements TodoService {
    /**
     * Constructor Injection 을 위한 private final
     */
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info("TodoServiceImpl/register ...");
        try {
            TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
            todoMapper.insert(todoVO);
            log.info("Register done");
        } catch (Exception e) {
            log.info("Register Fail");
            e.getMessage();
        }
    }

//    @Override
//    public List<TodoDTO> getAll() {
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                .map(vo -> modelMapper.map(vo, TodoDTO.class))
//                .collect(Collectors.toList());
//        return dtoList;
//    }

    @Override
    public TodoDTO getOne(Long tno) {
        return modelMapper.map(todoMapper.selectOne(tno), TodoDTO.class);
    }

    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        todoMapper.update(modelMapper.map(todoDTO, TodoVO.class));
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> vos = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtos = vos.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .toList();

        int total = todoMapper.getCount(pageRequestDTO);

        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>All()
                .dtoList(dtos)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }


}

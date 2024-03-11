package com.example.jdbcex.todoService;

import com.example.jdbcex.dao.TodoDAO;
import com.example.jdbcex.domain.TodoVO;
import com.example.jdbcex.dto.TodoDTO;
import com.example.jdbcex.util.MapperUtil;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.stream.Collectors;


@Log4j2
public enum TodoServiceEnum {
    INSTANCE;

    private ModelMapper modelMapper;
    private TodoDAO todoDAO;

    /**
     * ToService 는 DTO, VO 사용하는 구조이므로, ModelMapper 와 TodoDAO를 이용하도록 구성한다.
     */
    TodoServiceEnum() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    /**
     * TodoDTO 를 Param 으로 받아서 TodoVO 로 변환하는 기능
     * @param todoDTO
     */
    public void register(TodoDTO todoDTO) {
//        System.out.println("DEBUG..." + todoDTO );
        // map 은 첫번째 param 을 두번째 param 의 타입으로 변경을 해줌
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);
//        System.out.println("todoVO" + vo);
        log.info(vo);
        todoDAO.insert(vo);
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = todoDAO.selectAll();
        List<TodoDTO> todoDTOList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return todoDTOList;
    }

    public TodoDTO get(Long tno) throws Exception {
        return modelMapper.map(todoDAO.selectOne(tno), TodoDTO.class);
    }

    public void update(TodoVO todoVo) throws Exception {
        todoDAO.updateOne(todoVo);
//        System.out.println("update done");
    }

    public void delete(Long tno) throws Exception {
        todoDAO.deleteOne(tno);
//        System.out.println("deleted");
    }

}

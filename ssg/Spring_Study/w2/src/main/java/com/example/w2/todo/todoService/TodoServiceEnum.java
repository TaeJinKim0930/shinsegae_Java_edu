package com.example.w2.todo.todoService;

import com.example.w2.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoServiceEnum {
    INSTANCE;

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG..." + todoDTO );
    }

    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOList = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo-" + i);
            dto.setDueDate(LocalDate.now());
            dto.setFinished(false);
            return dto;
        }).collect(Collectors.toList());
        return todoDTOList;
    }

    // 특정 지정된 TNO를 전달 받아서 해당 todo를 return 하는 메소드 get 를 구현해주세요
    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno((long)1);
        dto.setTitle("Todo-" + 1);
        dto.setDueDate(LocalDate.now());
        dto.setFinished(false);
        return dto;
//        List<TodoDTO> todoDTOList = getList();
//        int tno2 = tno.intValue();
//        return todoDTOList.get(tno2);
    }

}

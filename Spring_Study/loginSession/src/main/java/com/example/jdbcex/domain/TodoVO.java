package com.example.jdbcex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder    // TodoVO.builder().build() 로 객체 생성
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}

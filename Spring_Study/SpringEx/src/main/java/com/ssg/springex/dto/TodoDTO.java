package com.ssg.springex.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
}

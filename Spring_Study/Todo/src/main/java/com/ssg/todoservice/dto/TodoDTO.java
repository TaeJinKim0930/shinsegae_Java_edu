package com.ssg.todoservice.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private long tno;
    @NotNull
    private String title;
    @Future // 지금 아니면 미래에 대한 시간만 받을 수 있게끔 해주는 Annotation.
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer;
}

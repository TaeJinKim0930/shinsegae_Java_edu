package com.ssg.springproduct.domain;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    @NotNull
    private long pno;

    @NotNull
    @Min(1)
    @Max(100)
    private String pname;

    @Positive
    @Min(1)
    @Max(1000000)
    private long price;

    @Positive
    @Min(1)
    @Max(100000)
    private long quantity;
}


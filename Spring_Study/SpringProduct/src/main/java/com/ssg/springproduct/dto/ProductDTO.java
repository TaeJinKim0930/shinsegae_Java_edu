package com.ssg.springproduct.dto;

import lombok.*;

import javax.validation.constraints.*;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull
    private long pno;
    @NotNull
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




package com.example.webmvc_member.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String memail;
    private LocalDate reg_date;
}

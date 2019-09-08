package com.example.mybatisxml.demo.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private Integer age;
    private Integer gender;

}

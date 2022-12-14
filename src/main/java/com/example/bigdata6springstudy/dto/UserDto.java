package com.example.bigdata6springstudy.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserDto {
    private int userNo;
    private String name;
    private int sal;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 문자열파라미터를 Date객체로 파싱
    private Date brith; // 파싱을 해야해
}

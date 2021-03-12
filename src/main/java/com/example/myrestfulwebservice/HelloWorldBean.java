package com.example.myrestfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 현재 HelloWorldBean가 가지고 있는 모든 프로퍼티, 필드에 대한 setter, getter, 생성자 ToString을 만든다.
@AllArgsConstructor // 모든 필드를 가진 생성자를 만든다.
@NoArgsConstructor
public class HelloWorldBean {

    private String message;


}

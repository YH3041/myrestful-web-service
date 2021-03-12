package com.example.myrestfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//RestController 선언으로 반환하고자 하는 값을 ResponseBody에 저장하지 않더라도 자동으로 JSON 포멧으로 변경되어 반환된다.
public class HelloWorldController {
    // GET
    // /hello-world -> (endpoint)
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World Bean, %s", name));
    }
}

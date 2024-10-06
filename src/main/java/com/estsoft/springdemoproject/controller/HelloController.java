package com.estsoft.springdemoproject.controller;

import com.estsoft.springdemoproject.ioc.Member;
import com.estsoft.springdemoproject.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private  HelloService service;   // Dependency Injection

    public HelloController(HelloService service) {   // 요즘엔 이렇게 생성자 주입 방식으로 많이 씀
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "param", defaultValue = "Spring") String param) {
        // 기존 객체 직접 생성, 호출
//        HelloService service = new HelloService();
//        return service.printHello(param);

        // spring에게 제어권 맡기기 (DI사용해서)
        Member member = new Member(1, "sungyeon", "address");
        return service.printHello(param);
    }
}

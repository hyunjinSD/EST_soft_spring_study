package com.estsoft.springdemoproject.controller;

import com.estsoft.springdemoproject.model.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 요청을 담당할 컨트롤러이다라고 스프링한테 알려주기 위한것 ==> @RestController
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public Student getStudent(@RequestParam(required = false) String name) {
        return studentService.getStudentByname(name);
    }

    @PostMapping(/"student")
    public ResponseEntity<String> registStudent(@RequestBody Map<String, Object> params) {
        return ResponseEntity.ok().body(studentService.saveStudent(params));
    }
    // DI 여러가지 방식이 있을 수 있다.
    // 1. setter method를 통해서 DI 처리하기
    // 2. 생성자를 통해서 DI 처리하기.
    // 3. autowired 어노테이션을 이용해서 처리하기.
    // 각각의 장단점이 있다. 순환참조. cirular reference. -> local 개발시 겪을수 있는 문제

    // service class -> class 설계를 잘하는게 중요.
    // StudentService -> LectureService
    // LectureService -> StudentService
    // ==> 방지 or 사전인지 할 수 있는 좋은 방안이 생상자 기반의 DI 처리하기 -> bootrun 시점에 순환참조된거를 사전인지해서 방지할수 있다

}

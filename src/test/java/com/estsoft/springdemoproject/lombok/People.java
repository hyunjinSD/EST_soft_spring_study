package com.estsoft.springdemoproject.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

// POJO (Plain Object Java Object)
@AllArgsConstructor
@Getter
@Setter
public class People {
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;


}

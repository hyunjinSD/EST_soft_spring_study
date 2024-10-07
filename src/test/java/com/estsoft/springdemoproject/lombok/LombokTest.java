package com.estsoft.springdemoproject.lombok;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LombokTest {
    @Test
    public void test() {
        People people = new People(1L, "name", 20, Arrays.asList("달리기", "등등"));
        people.setHobbies(Arrays.asList("그의 취미", "."));
        System.out.println(people.getHobbies());

//        People people2 = new People(2L, "required 생성자 사용");
    }
}

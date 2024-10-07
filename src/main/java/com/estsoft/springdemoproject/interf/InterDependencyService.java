package com.estsoft.springdemoproject.interf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InterDependencyService {
    private  final Inter inter;

    // interface 타팁으로 의존성주입(DI)할 때 구현체 지정하는 2가지 방법
    // 단 interface의 구현체가 하나일 경우에는 구현체를 지정하지 않아도 됨
    // 1. Qualifier 사용 (빈 이름 (구현체) 지정)
    // 2. Primary
    public InterDependencyService(@Qualifier("iterImplA")Inter inter) {
        this.inter = inter;
    }

    public void printMethod() {
        inter.method();
    }
}

package com.estsoft.springdemoproject.model.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "desc")
    private String desc;
    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDate.now();
//    }
    // 이 필드는 DB 칼럼으로는 미존재하는 상태지만 이 엔티티 클래스에서는 개발자가 사용할 필드
    @Transient
    private String nickname;

    public String getNickname() {
        return this.name+"_(" + this.age + ")";
    }
}

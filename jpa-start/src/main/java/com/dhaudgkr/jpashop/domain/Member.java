package com.dhaudgkr.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/* 제약조건은 최대한 명시해 주는것이 좋다. */

@Entity
@Getter @Setter
//@Table(indexes = "") /* index가 있을시 Table에 index도 명시해주는것이 좋다.*/
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID") /* 컬럼명은 소문자/대문자를 회사 컨벤션에 따라서 적으면 된다. */
    private Long id;
    @Column(length = 10) /* length와 같은 제약조건을 추가하는 것이 직관적인 이점이 있다. */
    private String name;
    private String city;
    private String street;
    private String zipcode;
}

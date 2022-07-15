package com.dhaudgkr.jpa01.hellojpa.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/* JPA가 사용하는 Entity 설정 */
@Entity
/* entity의 테이블 명명 */
//@Table(name = "USER")
/* JPA(영속성 컨텍스트)가 접근하기 위해서는 빈 생성자가 필요하다
* 접근제어자는 public 외에 아무거나 줘도 상관이없지만, 캡슐화를 위해 PROTECTED를 권장*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    /* 테이블의 ID 컬럼 설정 */
    @Id
    private Long id;

    /* 해당 변수의 컬럼명 매칭 */
//    @Column(name = "username")
    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.dhaudgkr.jpastart.hellojpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* JPA가 사용하는 Entity 설정 */
@Entity
/* entity의 테이블 명명 */
//@Table(name = "USER")
public class Member {

    /* 테이블의 ID 컬럼 설정 */
    @Id
    private Long id;

    /* 해당 변수의 컬럼명 매칭 */
//    @Column(name = "username")
    private String name;

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

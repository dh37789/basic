package com.dhaudgkr.jpa05.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;
    /* 객체지향의 연관관계로 변경 */

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

}

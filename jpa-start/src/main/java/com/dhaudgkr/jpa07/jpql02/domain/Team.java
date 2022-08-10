package com.dhaudgkr.jpa07.jpql02.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

}

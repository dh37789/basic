package com.dhaudgkr.jpa03.manytomany.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "USERNAME")
    private String username;

//    @ManyToMany
//    @JoinColumn(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> products = new ArrayList<>();

}

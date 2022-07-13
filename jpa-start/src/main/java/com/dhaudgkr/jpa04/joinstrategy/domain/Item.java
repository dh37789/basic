package com.dhaudgkr.jpa04.joinstrategy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}

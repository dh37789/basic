package com.dhaudgkr.jpa04.singlestrategy.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}

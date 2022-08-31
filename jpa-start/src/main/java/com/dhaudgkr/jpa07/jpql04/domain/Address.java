package com.dhaudgkr.jpa07.jpql04.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}

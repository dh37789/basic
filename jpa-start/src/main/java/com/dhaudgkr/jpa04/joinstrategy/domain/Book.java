package com.dhaudgkr.jpa04.joinstrategy.domain;

import com.dhaudgkr.jpa04.singlestrategy.domain.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@DiscriminatorValue("B")
public class Book extends Item {
    private String author;
    private String isbn;
}

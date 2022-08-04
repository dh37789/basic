package com.dhaudgkr.jpashop.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/*
 @Column(length = 10) 와 같은 공통 룰이나.
 private String fullAddress()와 같은 비지니스 로직을 구현하기 용이하다.
 */
@Embeddable
@Getter
public class Address {

    @Column(length = 10)
    private String city;
    @Column(length = 10)
    private String street;
    @Column(length = 10)
    private String zipcode;

    private String fullAddress() {
        return getCity() + " " + getClass() + " " + getZipcode();
    }

    public boolean isValid() {
        return false;
    }

    /* 필드에 직접 접근시 proxy일 경우에는 접근이 되지 않기 때문에
       Use getters during code generation 옵션을 체크해주고 만들어 주자 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}

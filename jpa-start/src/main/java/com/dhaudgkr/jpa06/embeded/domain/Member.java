package com.dhaudgkr.jpa06.embeded.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "USERNAME")
    private String username;

    /* Period 타입으로 치환 */
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    @Embedded
    private Period workPeriod;

    /* Address 타입으로 치환 */
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                    column=@Column(name="COMPANY_CITY")),
            @AttributeOverride(name="street",
                    column=@Column(name="COMPANY_STREET")),
            @AttributeOverride(name="zipcode",
                    column=@Column(name="COMPANY_ZIPCODE"))
    })
    private Address companyAddress;
}

package com.dhaudgkr.jpa06.collector.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
//    @Embedded
//    private Period workPeriod;

    /* Address 타입으로 치환 */
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

//    @AttributeOverrides({
//            @AttributeOverride(name="city",
//                    column=@Column(name="COMPANY_CITY")),
//            @AttributeOverride(name="street",
//                    column=@Column(name="COMPANY_STREET")),
//            @AttributeOverride(name="zipcode",
//                    column=@Column(name="COMPANY_ZIPCODE"))
//    })
//    private Address companyAddress;
}

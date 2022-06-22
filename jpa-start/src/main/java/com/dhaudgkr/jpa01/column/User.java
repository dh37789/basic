package com.dhaudgkr.jpa01.column;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TB_USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SequenceGenerator(name = "user_seq_generator", sequenceName = "user_seq")
//@TableGenerator(
//        name = "USER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "USER_SEQ", allocationSize = 1)
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "USER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name",unique = true)
    private String username;

    private Integer age;

    @Enumerated(EnumType.ORDINAL)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;
}

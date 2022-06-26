package com.dhaudgkr.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS") /* ORDER가 예약어라 생성이 안되는 DB가 있어서 ORDERS를 많이 사용 */
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(name = "MEMBER_ID")
//    private Long memberId;
    @ManyToOne
    @JoinColumn(name= "MEMBER_ID")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}

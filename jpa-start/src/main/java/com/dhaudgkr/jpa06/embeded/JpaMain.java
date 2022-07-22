package com.dhaudgkr.jpa06.embeded;

import com.dhaudgkr.jpa06.embeded.domain.Address;
import com.dhaudgkr.jpa06.embeded.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa06_1");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Address address = new Address("city", "street", "zipcode");

            Member member1 = new Member();
            member1.setHomeAddress(address);
            member1.setUsername("mho1");
//            member.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));
            entityManager.persist(member1);

            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setHomeAddress(copyAddress);
            member2.setUsername("mho2");
//            member.setWorkPeriod(new Period(LocalDateTime.now(), LocalDateTime.now()));
            entityManager.persist(member2);

            member1.getHomeAddress().setCity("newCity");

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

}

package com.dhaudgkr.jpa06.collector;

import com.dhaudgkr.jpa06.collector.domain.Address;
import com.dhaudgkr.jpa06.collector.domain.AddressEntity;
import com.dhaudgkr.jpa06.collector.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa06_2");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Member member = new Member();
            member.setUsername("mho");
            member.setHomeAddress(new Address("city1", "street1", "zipcode1"));

            member.getFavoriteFoods().add("버거킹");
            member.getFavoriteFoods().add("케이크");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("city_old1", "street_old1", "zipcode_old1"));
            member.getAddressHistory().add(new AddressEntity("city_old2", "street_old2", "zipcode_old2"));

            entityManager.persist(member);
//            System.out.println("=============== START ===============");
//            Member findMember = entityManager.find(Member.class, member.getId());

//            /* addressHistory 호출 */
//            System.out.println("=============== addressHistory START ===============");
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory)
//                System.out.println("addressHistory : " + address.getCity());
//
//            /* favoriteFoods 호출 */
//            System.out.println("=============== favoriteFoods START ===============");
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods)
//                System.out.println("favoriteFood : " + favoriteFood);

            /* homeCity -> newCity */
//            findMember.getHomeAddress().setCity("newCity");

//            Address oldAddress = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", oldAddress.getStreet(), oldAddress.getZipcode()));
//
//            /* 피자 -> 치킨 */
//            findMember.getFavoriteFoods().remove("피자");
//            findMember.getFavoriteFoods().add("치킨");
//
//            /* city_old1 -> city_new1 */
//            findMember.getAddressHistory().remove(new Address("city_old1", "street_old1", "zipcode_old1"));
//            findMember.getAddressHistory().add(new Address("city_new1","street_old1", "zipcode_old1"));


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

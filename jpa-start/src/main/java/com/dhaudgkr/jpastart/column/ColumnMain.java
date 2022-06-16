package com.dhaudgkr.jpastart.column;

import com.dhaudgkr.jpastart.hellojpa.entity.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
public class ColumnMain {

    public static void main(String[] args) {
        /* EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유 */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        /* DB 커넥션과 같이 EntityManager는 쓰레드간에 공유를 하지 않으므로, 사용하면 닫아줘야한다. */
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /* EntityManager의 트랜잭션 정보 get */
        /* JPA의 모든 데이터 변경은 트랜잭션 안에서 실행한다. */
        EntityTransaction entityTransaction = entityManager.getTransaction();

//        insertJpa(entityManagerFactory, entityManager, entityTransaction);
//        anotationId(entityManagerFactory, entityManager, entityTransaction);
//        identityId(entityManagerFactory, entityManager, entityTransaction);
        sequenceId(entityManagerFactory, entityManager, entityTransaction);
//        tableId(entityManagerFactory, entityManager, entityTransaction);

        /* JPQL 사용 */
        /* JQPL이란 SQL을 추상화한 객체 지향 쿼리 언어 */
//        findByJpql(entityManagerFactory, entityManager, entityTransaction);
    }

    private static void tableId(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();

        try {
            User user = new User();
            user.setUsername("TABLE");
            user.setRoleType(RoleType.USER);
            entityManager.persist(user);

            /* 영속성 컨텍스트의 member의 영속상태를 준영속 상태로 분리한다.*/
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void sequenceId(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();

        try {
            User user = new User();
            user.setUsername("만득이");
            user.setRoleType(RoleType.USER);
            log.debug("persist BEFORE");
            entityManager.persist(user);
            log.debug("persist AFTER");

            /* 영속성 컨텍스트의 member의 영속상태를 준영속 상태로 분리한다.*/
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void identityId(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();

        try {
            User user = new User();
            user.setUsername("만득이");
            user.setRoleType(RoleType.USER);
            log.debug("persist BEFORE");
            entityManager.persist(user);
            log.debug("persist AFTER");

            /* 영속성 컨텍스트의 member의 영속상태를 준영속 상태로 분리한다.*/
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void anotationId(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        entityTransaction.begin();

        try {
            /* @Id만 사용했을 경우 임의의 PK값을 넣을 수 있음 */
//            User user = new User();
//            user.setId("PK_A");
//            user.setUsername("만득이");
//            user.setRoleType(RoleType.USER);
//            entityManager.persist(user);

            /* 영속성 컨텍스트의 member의 영속상태를 준영속 상태로 분리한다.*/
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

    private static void insertJpa(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        /* insert */
        /* badcase - 에러가 날경우 close나 트랜잭션이 작용 안할 수도 있음 */
        entityTransaction.begin();

        try {
            User user = new User();
            user.setId(1L);
            user.setUsername("만득이");
            user.setRoleType(RoleType.USER);
            entityManager.persist(user);

            /* 영속성 컨텍스트의 member의 영속상태를 준영속 상태로 분리한다.*/
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

}

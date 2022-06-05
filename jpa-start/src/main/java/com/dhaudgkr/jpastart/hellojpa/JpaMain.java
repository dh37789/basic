package com.dhaudgkr.jpastart.hellojpa;

import com.dhaudgkr.jpastart.hellojpa.entity.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 해당 작업중 트랜잭션처리나 팩토리를 통해 정보를 가져오는 것은
 * 스프링 부트를 사용할 경우 알아서 처리해준다.
 */
@Slf4j
public class JpaMain {

    public static void main(String[] args) {
        /* EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유 */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        /* DB 커넥션과 같이 EntityManager는 쓰레드간에 공유를 하지 않으므로, 사용하면 닫아줘야한다. */
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /* EntityManager의 트랜잭션 정보 get */
        /* JPA의 모든 데이터 변경은 트랜잭션 안에서 실행한다. */
        EntityTransaction entityTransaction = entityManager.getTransaction();

        insertJpa(entityManagerFactory, entityManager, entityTransaction);
        findJpa(entityManagerFactory, entityManager, entityTransaction);
        removeJpa(entityManagerFactory, entityManager, entityTransaction);
        updateJpa(entityManagerFactory, entityManager, entityTransaction);
    }

    private static void updateJpa(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        /* update */
        entityTransaction.begin();

        try {
            Member findMember = entityManager.find(Member.class, 1L);
            /* Entity의 변경을 확인하고 JPA가 자체적으로 update 쿼리를 만들어서 날린다. */
            findMember.setName("HelloJPA");

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void removeJpa(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        /* delete */
        entityTransaction.begin();

        try {
            Member findMember = entityManager.find(Member.class, 1L);
            entityManager.remove(findMember);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    private static void findJpa(EntityManagerFactory entityManagerFactory, EntityManager entityManager, EntityTransaction entityTransaction) {
        /* search */
        entityTransaction.begin();

        try {
            Member findMember = entityManager.find(Member.class, 1L);
            log.debug("findMember.id = " + findMember.getId());
            log.debug("findMember.name = " + findMember.getName());

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

/*        Member member = new Member();
        member.setId(2L);
        member.setName("HelloB");
        entityManager.persist(member);
        entityTransaction.commit();

        // code
        entityManager.close();
        entityManagerFactory.close();*/

        /* goodcase */
        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            entityManager.persist(member);
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }

}

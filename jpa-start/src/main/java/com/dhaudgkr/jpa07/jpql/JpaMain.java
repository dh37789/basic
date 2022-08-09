package com.dhaudgkr.jpa07.jpql;

import com.dhaudgkr.jpa07.jpql.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa07_1");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // jpql
//            List<Member> members = entityManager.createQuery(
//                    "select m From Member m where m.username like '%hello%'",
//                    Member.class
//            ).getResultList();

//            //Criteria 사용 준비
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            //루트 클래스 (조회를 시작할 클래스)
//            Root<Member> m = query.from(Member.class);
//
//            //쿼리 생성
//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
//            List<Member> members = entityManager.createQuery(cq).getResultList();

            // native sql
            String sql = "SELECT ID, TEAM_ID, USERNAME FROM MEMBER WHERE USERNAME LIKE '%hello%'";
            List<Member> members = entityManager.createNativeQuery(sql, Member.class).getResultList();

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }
}

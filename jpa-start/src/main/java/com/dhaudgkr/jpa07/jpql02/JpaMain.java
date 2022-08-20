package com.dhaudgkr.jpa07.jpql02;

import com.dhaudgkr.jpa07.jpql02.domain.*;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa07_2");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            entityManager.persist(team);

            Member member = new Member();
            member.setUsername(null);
            member.setAge(10);
            member.setType(MemberType.valueOf("USER"));
            member.setTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

//            jpqlBasic(entityManager);
//            projections(entityManager);
//            projections2(entityManager);
//            paging(entityManager);
//            join(entityManager);
//            subQuery(entityManager);
//            typeQuery(entityManager);

//            String conditionalQuery = "select " +
//                                        "m.username," +
//                                        "case when m.age <= 10 then '학생요금'" +
//                                        "     when m.age >= 60 then '경로요금'" +
//                                        "     else '일반요금' " +
//                                        "end " +
//                                        "from Member m ";
//            List<Object[]> result = entityManager.createQuery(conditionalQuery)
//                    .getResultList();
//
//            for (Object[] obj : result) {
//                System.out.println("username : " + obj[0]);
//                System.out.println("fee : " + obj[1]);
//            }

//            String conditionalQuery = "select " +
//                                        "t.name," +
//                                        "case t.name" +
//                                        "     when 'teamA' then '개발팀A'" +
//                                        "     when 'teamB' then '개발팀B'" +
//                                        "     else '개발팀C' " +
//                                        "end " +
//                                        "from Team t";
//            List<Object[]> result = entityManager.createQuery(conditionalQuery)
//                    .getResultList();
//
//            for (Object[] obj : result) {
//                System.out.println("name : " + obj[0]);
//                System.out.println("이름 : " + obj[1]);
//            }

//            String query = "select coalesce(m.username, '이름 없는 회원') as username from Member m";
//            List<String> result = entityManager.createQuery(query, String.class)
//                            .getResultList();
//
//            for (String name : result) {
//                System.out.println("member name : " + name);
//            }

            String query2 = "select nullif(m.username, '관리자') as username from Member m";
            List<String> result2 = entityManager.createQuery(query2, String.class)
                            .getResultList();

            for (String name : result2) {
                System.out.println("member name : " + name);
            }

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

    private static void jpqlBasic(EntityManager entityManager) {
        /* JQPL 문법 */
        entityManager.createQuery("SELECT m FROM Member m", Member.class);

        /* TypedQuery, Query */
        TypedQuery<Member> query1 = entityManager.createQuery("SELECT m FROM Member m", Member.class);
        TypedQuery<String> query2 = entityManager.createQuery("SELECT m.username FROM Member m", String.class);
        Query query3 = entityManager.createQuery("SELECT m.username, m.age FROM Member m");

        /* 결과 조회 API */
        Member resultMember = query1.getSingleResult();
        System.out.println("resultMember = " + resultMember);

        /* 파라미터 바인딩 */
        TypedQuery<Member> query = entityManager.createQuery("SELECT m FROM Member m WHERE m.username = :username", Member.class);
        query.setParameter("username", "member1");
        Member member1 = query.getSingleResult();
        System.out.println("member1 : " + member1.getUsername());
    }

    private static void projections(EntityManager entityManager) {
        /* 프로젝션 */
        List<Member> members = entityManager.createQuery("SELECT m from Member m", Member.class)
                .getResultList();

        Member findMember = members.get(0);
        findMember.setAge(30);

        /* 프로젝션 */
        List<Team> teams = entityManager.createQuery("SELECT m.team from Member m", Team.class)
                .getResultList();

        /* 프로젝션 */
        entityManager.createQuery("SELECT o.address from Order o", Address.class)
                .getResultList();

        /* 스칼라 프로젝션 */
        entityManager.createQuery("SELECT m.username, m.age from Member m")
                .getResultList();
    }

    private static void projections2(EntityManager entityManager) {
        /* Object */
        List objectList = entityManager.createQuery("SELECT m.username, m.age from Member m")
                .getResultList();

        Object o = objectList.get(0);
        Object[] objects = (Object[]) o;
        System.out.println("objects.username : " + objects[0]);
        System.out.println("objects.age : " + objects[1]);

        /* Object[] */
        List<Object[]> results = entityManager.createQuery("SELECT m.username, m.age from Member m")
                .getResultList();

        Object[] objects2 = results.get(0);
        System.out.println("objects.username : " + objects2[0]);
        System.out.println("objects.age : " + objects2[1]);


        /* new 이용 방식 */
        List<MemberDto> result = entityManager.createQuery("SELECT new com.dhaudgkr.jpa07.jpql02.domain.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                .getResultList();
        MemberDto memberDto = result.get(0);
        System.out.println("MemberDto.username : " + memberDto.getUsername());
        System.out.println("MemberDto.age : " + memberDto.getAge());
    }

    private static void paging(EntityManager entityManager) {
        for (int i = 0; i < 100; i++) {
            Member member = new Member();
            member.setUsername("member" + i);
            member.setAge(i+5);
            entityManager.persist(member);
        }

        List<Member> memberList = entityManager.createQuery("SELECT m FROM Member m ORDER BY m.age DESC", Member.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();

        System.out.println("memberList.size : " + memberList.size());
        for (Member findMember : memberList) {
            System.out.println("findMember.username : " + findMember);
        }
    }

    private static void join(EntityManager entityManager) {
        /* inner join */
        String innerJoin = "select m from Member m inner join m.team t";
        /* left outer join */
        String leftOuterJoin = "select m from Member m inner join m.team t";
        /* 세타 조인 */
        String thetaJoin = "select m from Member m, Team t where m.username = t.name";
        /* 조인 대상 필터링 */
        String on1 = "select m from Member m left outer join m.team t on t.name = 'teamA'";
        /* 연관관계 없는 엔티티 외부 조인 */
        String on2 = "select m from Member m left join Team t on m.username = t.name";
        List<Member> result = entityManager.createQuery(on2, Member.class)
                .getResultList();
    }

    private static void subQuery(EntityManager entityManager) {
        String subQuery = "select (select avg(m1.age) from Member m1) as avgAge from Member";
        List<Object[]> result = entityManager.createQuery(subQuery)
                .getResultList();
    }

    private static void typeQuery(EntityManager entityManager) {
            String typeQuery = "select m.username, 'HELLO', 10L, TRUE from Member m";
            List<Object[]> result = entityManager.createQuery(typeQuery)
                    .getResultList();

            for (Object[] objects : result) {
                System.out.println("member : " + objects[0]);
                System.out.println("String : " + objects[1]);
                System.out.println("Long : " + objects[2]);
                System.out.println("Boolean : " + objects[3]);
            }

        String typeQuery2 = "select m.username from Member m " +
                "where m.type = :userType";
        List<Object[]> result2 = entityManager.createQuery(typeQuery2)
                .setParameter("userType", MemberType.USER)
                .getResultList();
    }
}

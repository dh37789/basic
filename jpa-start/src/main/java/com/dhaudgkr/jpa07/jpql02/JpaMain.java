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
            member.setUsername("관리자1");
            member.setAge(10);
            member.setType(MemberType.valueOf("USER"));
            member.setTeam(team);
            entityManager.persist(member);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setAge(10);
            member2.setType(MemberType.valueOf("USER"));
            member2.setTeam(team);
            entityManager.persist(member2);

            entityManager.flush();
            entityManager.clear();

//            jpqlBasic(entityManager);
//            projections(entityManager);
//            projections2(entityManager);
//            paging(entityManager);
//            join(entityManager);
//            subQuery(entityManager);
//            typeQuery(entityManager);
//            conditionalQuery(entityManager);
//            function(entityManager);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

    /*jpql 문법*/
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

    /* 프로젝션 */
    private static void projections(EntityManager entityManager) {
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

    /* 다양한 타입의 반환법 */
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

    /* 페이징 */
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

    /* 조인 */
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

    /* 서브쿼리 */
    private static void subQuery(EntityManager entityManager) {
        String subQuery = "select (select avg(m1.age) from Member m1) as avgAge from Member";
        List<Object[]> result = entityManager.createQuery(subQuery)
                .getResultList();
    }

    /* 기타 타입의 쿼리 */
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

    /* 조건식 */
    private static void conditionalQuery(EntityManager entityManager) {
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
    }

    public static void function(EntityManager entityManager) {
//            String query1 = "SELECT 'A' || 'B' FROM Member m";
//            String query1 = "SELECT CONCAT('A','B') FROM Member m";
//            List<String> result1 = entityManager.createQuery(query1, String.class)
//                            .getResultList();
//
//            for (String str : result1) {
//                System.out.println("concat : " + str);
//            }

//            String query2 = "SELECT SUBSTRING('abcdefg', 2, 3) FROM Member m";
//            List<String> result2 = entityManager.createQuery(query2, String.class)
//                            .getResultList();
//
//            for (String str : result2) {
//                System.out.println("substring : " + str);
//            }

//            String query3 = "SELECT TRIM('   ab  cdefg   ') FROM Member m";
//            List<String> result3 = entityManager.createQuery(query3, String.class)
//                    .getResultList();
//
//            for (String str : result3) {
//                System.out.println("trim : " + str);
//            }
//
//            String query4 = "SELECT LOWER('ABCDEFG'), UPPER('abcdefg') FROM Member m";
//            List<Object[]> result4 = entityManager.createQuery(query3)
//                    .getResultList();
//
//            for (Object[] objects : result4) {
//                System.out.println("lower : " + objects[0]);
//                System.out.println("upper : " + objects[1]);
//            }

//            String query5 = "SELECT LENGTH('abcdefggg') FROM Member m";
//            List<Integer> result5 = entityManager.createQuery(query5, Integer.class)
//                    .getResultList();
//
//            for (Integer integer : result5) {
//                System.out.println("length : " + integer);
//            }

//            String query6 = "SELECT LOCATE('ggg', 'abcdefggg') FROM Member m";
//            List<Integer> result6 = entityManager.createQuery(query6, Integer.class)
//                    .getResultList();
//
//            for (Integer integer : result6) {
//                System.out.println("locate : " + integer);
//            }

//            String query7 = "SELECT SIZE(t.members) FROM Team t";
//            List<Integer> result7 = entityManager.createQuery(query7, Integer.class)
//                    .getResultList();
//
//            for (Integer integer : result7) {
//                System.out.println("size : " + integer);
//            }

//            String query8 = "SELECT INDEX(t.members) FROM Team t";
//            List<Integer> result8 = entityManager.createQuery(query8, Integer.class)
//                    .getResultList();
//
//            for (Integer integer : result8) {
//                System.out.println("index : " + integer);
//            }

        String query9 = "SELECT function('group_concat', m.username) FROM Member m";
        List<String> result9 = entityManager.createQuery(query9, String.class)
                .getResultList();

        for (String str : result9) {
            System.out.println("function : " + str);
        }
    }
}

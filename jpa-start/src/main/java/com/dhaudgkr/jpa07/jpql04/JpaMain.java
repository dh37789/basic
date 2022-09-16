package com.dhaudgkr.jpa07.jpql04;

import com.dhaudgkr.jpa07.jpql04.domain.Member;
import com.dhaudgkr.jpa07.jpql04.domain.MemberType;
import com.dhaudgkr.jpa07.jpql04.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa07_4");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            Team teamA = new Team();
            teamA.setName("teamA");
            entityManager.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            entityManager.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(10);
            member1.setType(MemberType.valueOf("USER"));
            member1.setTeam(teamA);
            entityManager.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(10);
            member2.setType(MemberType.valueOf("USER"));
            member2.setTeam(teamA);
            entityManager.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(10);
            member3.setType(MemberType.valueOf("USER"));
            member3.setTeam(teamB);
            entityManager.persist(member3);

            bulkCalculation(entityManager, member1);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.clear();
        }
        entityManagerFactory.close();
    }

    private static void fetchJoin1(EntityManager entityManager) {
//        String query1 = "SELECT m FROM Member m";
        String query1 = "SELECT m FROM Member m join fetch m.team";
        List<Member> members = entityManager.createQuery(query1, Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member : " + member.getUsername() + ", team : " + member.getTeam().getName());
            // 회원1, 팀A(SQL에서 조회)
            // 회원2, 팀A(1차캐시에서 조회)
            // 회원3, 팀B(SQL에서 조회)
        }
    }

    private static void fetchJoin2(EntityManager entityManager) {
        String query2 = "SELECT t FROM Team t join fetch t.members";
        List<Team> teams = entityManager.createQuery(query2, Team.class)
                .getResultList();

        for (Team team : teams) {
            System.out.println("team : " + team.getName() + ", size : " + team.getMembers().size());
            for (Member member : team.getMembers()) {
                System.out.println("-> member : " + member.getUsername() + ", hashcode : " + member.hashCode());
            }
        }
    }

    private static void distinct(EntityManager entityManager) {
        String query3 = "SELECT distinct t FROM Team t join fetch t.members";
        List<Team> teams = entityManager.createQuery(query3, Team.class)
                .getResultList();

        for (Team team : teams) {
            System.out.println("team : " + team.getName() + ", size : " + team.getMembers().size());
            for (Member member : team.getMembers()) {
                System.out.println("-> member : " + member.getUsername() + ", hashcode : " + member.hashCode());
            }
        }
    }

    private static void entityRoad(EntityManager entityManager) {
        String query3 = "SELECT t FROM Team t join fetch t.members m";
        List<Team> teams = entityManager.createQuery(query3, Team.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getResultList();

        for (Team team : teams) {
            System.out.println("team : " + team.getName() + ", size : " + team.getMembers().size());
            for (Member member : team.getMembers()) {
                System.out.println("-> member : " + member.getUsername() + ", hashcode : " + member.hashCode());
            }
        }
    }

    private static void bulkCalculation(EntityManager entityManager, Member member) {
        int resultCount = entityManager.createQuery("update Member m set m.age = 20")
                .executeUpdate();
        System.out.println("resultCount : " + resultCount);

        entityManager.clear();

        Member findMember = entityManager.find(Member.class, member.getId());
        System.out.println("findMember.getAge : " + findMember.getAge());
    }

}

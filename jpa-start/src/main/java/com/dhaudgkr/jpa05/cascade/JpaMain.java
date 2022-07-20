package com.dhaudgkr.jpa05.cascade;

import com.dhaudgkr.jpa05.cascade.domain.Child;
import com.dhaudgkr.jpa05.cascade.domain.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa05_3");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            /* CASCADE */
            /*Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            entityManager.persist(parent);*/
//            entityManager.persist(child1);
//            entityManager.persist(child2);

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            entityManager.persist(parent);

            entityManager.flush();
            entityManager.clear();

            Parent findParent = entityManager.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

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

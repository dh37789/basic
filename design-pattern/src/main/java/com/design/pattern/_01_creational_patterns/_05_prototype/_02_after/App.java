package com.design.pattern._01_creational_patterns._05_prototype._02_after;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {
        GithubRepository repository = new GithubRepository();
        repository.setUser("dh37789");
        repository.setName("design-pattern-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제: 프로토 타입 패턴에 대해 알아보자");

        String url = githubIssue.getUrl();
        System.out.println(url);

        GithubIssue clone = (GithubIssue) githubIssue.clone();
        repository.setName("new-design-pattern");
        System.out.println(clone.getUrl());


        System.out.println("clone != githubIssue: " + (clone != githubIssue));
        System.out.println("clone.equals(githubIssue): " + clone.equals(githubIssue));
        System.out.println("clone.getClass() == githubIssue.getClass(): " + (clone.getClass() == githubIssue.getClass()));
        System.out.println("clone.getRepository() == githubIssue.getRepository(): " + (clone.getRepository() == githubIssue.getRepository()));
    }
}

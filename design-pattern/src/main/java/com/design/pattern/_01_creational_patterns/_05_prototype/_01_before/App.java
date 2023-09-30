package com.design.pattern._01_creational_patterns._05_prototype._01_before;

public class App {

    public static void main(String[] args) {
        GithubRepository repository = new GithubRepository();
        repository.setUser("dh37789");
        repository.setName("design-pattern-study");

        GithubIssue githubIssue = new GithubIssue(repository);
        githubIssue.setId(1);
        githubIssue.setTitle("1주차 과제: 프로토 타입 패턴에 대해 알아보자");

        String url = githubIssue.getUrl();
        System.out.println(url);
    }

}

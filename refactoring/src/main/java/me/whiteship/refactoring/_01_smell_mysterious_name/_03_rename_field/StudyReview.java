package me.whiteship.refactoring._01_smell_mysterious_name._03_rename_field;

/**
 * Java 14부터 지원
 * Getter, Setter, Hashcode, equals 가 자동으로 생성
 * */
public record StudyReview(String reviewer, String review) {
}

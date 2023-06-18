package com.effectiveJava.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {
    public static void main(String[] args) throws IOException{
        Path dictionary = Path.of(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }

    private static void base(String[] args) throws IOException{
        Path dictionary = Path.of(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)){
            while (s.hasNext()) {
                String word = s.next();

                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String word) {
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    private static void streamMethod(String[] args) throws IOException{
        Path dictionary = Path.of(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                            groupingBy(word -> word.chars().sorted()
                                    .collect(StringBuilder::new,
                                            (sb, c) -> sb.append((char) c),
                                            StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    }
}

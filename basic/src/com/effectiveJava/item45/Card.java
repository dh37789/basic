package com.effectiveJava.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    public Card(Suit suit, Rank rank) {
    }

    private static List<Card> newDeckStream() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }

    private static List<Card> newDeckList() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));
        return result;
    }

    public static enum Suit {

    }

    public static enum Rank {

    }
}

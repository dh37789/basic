package com.effectiveJava.item37;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.*;

class PlantTest {

    @Test
    void print_식물_구분_Test() {
        Plant[] garden = new Plant[5];
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i =0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s$n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    @Test
    void print_식물_구분_by_EnumMap_Test() {
        Plant[] garden = new Plant[5];
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<Plant.LifeCycle, Set<Plant>>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);
    }

    @Test
    void print_식물_구분_by_EnumMap_Stream_Test() {
        Plant[] garden = new Plant[5];
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));
    }

    @Test
    void print_식물_구분_by_EnumMap_Stream2_Test() {
        Plant[] garden = new Plant[5];
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
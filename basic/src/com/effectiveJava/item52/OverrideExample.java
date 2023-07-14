package com.effectiveJava.item52;

import java.util.List;

public class OverrideExample {

    public static class Wine {
        String name() { return "포도주"; }
    }
    public static class SparklingWine extends Wine {
        @Override String name() {return "발포성 포도주";}
    }

    public static  class Champagne extends SparklingWine {
        @Override String name() {return "샹페인";}
    }

    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne()
        );


        for (Wine w : wineList)
            System.out.println(w.name());
    }
}


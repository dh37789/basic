package com.effectiveJava.item40;

import java.io.Serializable;
import java.nio.file.Files;
import java.util.*;

public class Bigram implements Serializable {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram))
            return false;
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }
    @Override
    public int hashCode() {
        return 31 * this.first + this.second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Files.readString();
    }
}

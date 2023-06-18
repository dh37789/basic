package com.effectiveJava.item48;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;


public class Example {
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();

        pi(100000000);

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("소요시간(ms) : "+secDiffTime);
    }

    private static void mersen() {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .parallel()
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}

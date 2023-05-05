package com.effectiveJava.item34;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void 연산_Test() {
        double x = 3.55D;
        double y = 71.13D;
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    @Test
    void ordinal_Test() {
        for (Operation op : Operation.values())
            System.out.printf("%s는 %d번째 상수 입니다.%n", op, op.ordinal());
    }

}
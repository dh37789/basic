package com.effectiveJava.item38;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

class BasicOperationTest {
    @Test
    void 연산_Enum_Test() {
        double x = Double.parseDouble("1.5");
        double y = Double.parseDouble("2.0");
        testOperation(BasicOperation.class, x, y);
        testOperation(ExtendedOperation.class, x, y);
    }

    private <T extends Enum<T> & Operation> void testOperation(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x,y));
    }

    @Test
    void 연산_Enum_wildcard_Test() {
        double x = Double.parseDouble("1.5");
        double y = Double.parseDouble("2.0");
        testOperationByWildCard(Arrays.asList(BasicOperation.values()), x, y);
        testOperationByWildCard(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private void testOperationByWildCard(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x,y));
    }


}
package com.effectiveJava.item39;

import java.util.ArrayList;
import java.util.List;

public class TestSample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { /** 성공 */
        int i = 0;
        i = i / i;
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m2() { /** 실패. (다른 예외 발생) */
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m3() { } /** 실패. (예외가 발생하지 X) */
    @ExceptionTest({IndexOutOfBoundsException.class,
                    NullPointerException.class})
    public static void doublyBad() { /** 성공 */
        List<String> list = new ArrayList<>();
        /** IndexOutOfBoundsException나 NullPointerException 발생 */
        list.addAll(5, null);
    }
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad2() { /** 성공 */
        List<String> list = new ArrayList<>();
        /** IndexOutOfBoundsException나 NullPointerException 발생 */
        list.addAll(5, null);
    }
}

package com.effectiveJava.item89;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ElvisImpersonator {
    /* 진짜 Elvis 인스턴스로는 만들어질 수 없는 바이트 스트림 */
    private static final byte[] serializedForm = {
            -84, -19, 0, 5, 115, 114, 0, 30, 99, 111, 109, 46,
            101, 102, 102, 101, 99, 116, 105, 118, 101, 74, 97,
            118, 97, 46, 105, 116, 101, 109, 56, 57, 46, 69, 108,
            118, 105, 115, -95, -53, -34, 127, -23, -75, 15, -46,
            2, 0, 1, 91, 0, 13, 102, 97, 118, 111, 114, 105, 116,
            101, 83, 111, 110, 103, 115, 116, 0, 19, 91, 76, 106,
            97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114,
            105, 110, 103, 59, 120, 112, 117, 114, 0, 19, 91, 76,
            106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 116,
            114, 105, 110, 103, 59, -83, -46, 86, -25, -23, 29, 123,
            71, 2, 0, 0, 120, 112, 0, 0, 0, 1, 116, 0, 21, 78, 69,
            87, 32, 74, 69, 65, 78, 83, 58, 32, 72, 121, 112, 101,
            32, 66, 111, 121, 32, 126
    };
    public static void main(String[] args) {
        /* ElvisStealer.impersonator를 초기화한 다음,
           진짜 Elvis(즉 Elvis.INSTANCE)를 반환한다. */
        Elvis elvis = (Elvis) deserialize(serializedForm);
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorites();
        impersonator.printFavorites();
    }

    /** 주어진 직렬화 형태(바이트 스트림)로부터 객체르 만들어 반환한다. */
    static Object deserialize(byte[] sf) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(sf)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

package com.effectiveJava.item34;

public enum PhaseOrdinal {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        /** 행은 from의 ordinal을, 열은 to의 ordinal을 인덱스로 쓴다. */
        private static final Transition[][] TRANSITIONS = {
                { null, MELT, SUBLIME },
                { FREEZE, null, BOIL },
                { DEPOSIT, CONDENSE, null }
        };

        /** 한 상태에서 다른 상태로의 전이를 반환한다. */
        public static Transition from(PhaseOrdinal from, PhaseOrdinal to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}

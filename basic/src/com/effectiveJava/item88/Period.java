package com.effectiveJava.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public final class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date start;
    private Date end;

    /**
     * @param start 시작 시간
     * @param end 종료 시각; 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     * @throws NullPointerException start나 end가 null이면 발생한다.
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(
                    start + "가" + end + "보다 늦다."
            );
    }

    public Date start() { return new Date(start.getTime()); }
    public Date end() { return new Date(end.getTime()); }

    @Override
    public String toString() {
        return start + "-" + end;
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        /* 가변 요소를 방어적으로 복사한다. */
        start = new Date(start.getTime());
        end = new Date(end.getTime());

        /* 불변식을 만족하는지 검사한다. */
        if (start.compareTo(end) > 0)
            throw new InvalidObjectException(start + "가 " + end + "보다 늦다.");
    }
}

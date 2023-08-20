package com.effectiveJava.item90;

import com.effectiveJava.item88.Period;

import java.io.Serializable;
import java.util.Date;

public class SerializationProxy implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Date start;
    private final Date end;

    public SerializationProxy(Period p) {
        this.start = p.start();
        this.end = p.end();
    }
}

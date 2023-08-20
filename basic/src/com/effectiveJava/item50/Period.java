//package com.effectiveJava.item50;
//
//import java.io.Serializable;
//import java.util.Date;
//
//public final class Period implements Serializable {
//    private static final long serialVersionUID = 1L;
//    private final Date start;
//    private final Date end;
//
////    public Period(Date start, Date end) {
////        if (start.compareTo(end) > 0)
////            throw new IllegalArgumentException(
////                    start + "가 " + end + "보다 늦다.");
////        this.start = start;
////        this.end = end;
////    }
//
//    public Period(Date start, Date end) {
//        this.start = new Date(start.getTime());
//        this.end = new Date(end.getTime());
//
//        if (this.start.compareTo(this.end) > 0)
//            throw new IllegalArgumentException(
//                    this.start + "가 " + this.end + "보다 늦다.");
//    }
//
//    public Date getStart() {
//        return new Date(start.getTime());
//    }
//
//    public Date getEnd() {
//        return new Date(end.getTime());
//    }
//}

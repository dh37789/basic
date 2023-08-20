package com.effectiveJava.item89;

import com.effectiveJava.item88.Period;

import java.io.*;
import java.util.Date;

public class ObjectToByteStream {
    public static void main(String[] args) {
       Period period = new Period(new Date(), new Date());
       ByteArrayOutputStream bos = new ByteArrayOutputStream();
       ObjectOutputStream out = null;
       try {
           out = new ObjectOutputStream(bos);
           out.writeObject(period);
           out.flush();
           byte[] yourBytes = bos.toByteArray();
           for (byte b : yourBytes) {
               System.out.print(b + ", ");
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       } finally {
           try {
               bos.close();
           } catch (IOException ex) {
               // ignore close exception
           }
       }
   }
}

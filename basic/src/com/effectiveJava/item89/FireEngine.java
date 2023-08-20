package com.effectiveJava.item89;

public class FireEngine extends Car {
    public FireEngine() {
        super.modelName = "소방차";
    }
    
    public void showEngine() {
        System.out.println("모델명 : " + modelName);
    }
}

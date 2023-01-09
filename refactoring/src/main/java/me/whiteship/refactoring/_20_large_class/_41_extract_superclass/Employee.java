package me.whiteship.refactoring._20_large_class._41_extract_superclass;

public class Employee extends Party {

    private Integer id;

    public Employee(String name) {
        super(name);
    }

    private double monthlyCost;

    public Integer getId() {
        return id;
    }

    @Override
    public double monthlyCost() {
        return monthlyCost;
    }
}

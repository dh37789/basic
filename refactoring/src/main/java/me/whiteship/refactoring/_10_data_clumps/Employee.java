package me.whiteship.refactoring._10_data_clumps;

public class Employee {

    private String name;

    private TelephoneNumber personalPhoneNumber;

    public Employee(String name, TelephoneNumber personalPhoneNumber) {
        this.name = name;
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public String personalPhoneNumber() {
        return personalPhoneNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalAreaCode() {
        return this.personalPhoneNumber.getAreaCode();
    }

    public void setPersonalAreaCode(String areaCode) {
        this.personalPhoneNumber.setAreaCode(areaCode);
    }

    public String getPersonalNumber() {
        return personalPhoneNumber.getNumber();
    }

    public void setPersonalNumber(String number) {
        this.personalPhoneNumber.setNumber(number);
    }
}

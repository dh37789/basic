package me.whiteship.refactoring._10_data_clumps;

public class Office {

    private String location;

    private TelephoneNumber telephoneNumber;

    public Office(String location, TelephoneNumber telephoneNumber) {
        this.location = location;
        this.telephoneNumber = telephoneNumber;
    }

    public String officePhoneNumber() {
        return this.telephoneNumber.toString();
    }
}

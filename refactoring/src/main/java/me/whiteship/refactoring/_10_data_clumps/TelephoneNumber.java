package me.whiteship.refactoring._10_data_clumps;

public class TelephoneNumber {

    private String areaCode;

    private String number;

    public TelephoneNumber(String personalAreaCode, String personalNumber) {
        this.areaCode = personalAreaCode;
        this.number = personalNumber;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String toString() {
        return this.areaCode + "-" + this.number;
    }
}

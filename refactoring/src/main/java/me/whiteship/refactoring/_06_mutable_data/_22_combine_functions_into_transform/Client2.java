package me.whiteship.refactoring._06_mutable_data._22_combine_functions_into_transform;

public class Client2 extends ReadingClient{

    private double base;
    private double taxableCharge;

    public Client2(Reading reading) {
        EnricReading enricReading = enricReading(reading);
        this.base = enricReading.baseCharge();
        this.taxableCharge = enricReading.taxableCharge();
    }

    public double getBase() {
        return base;
    }

    public double getTaxableCharge() {
        return taxableCharge;
    }
}

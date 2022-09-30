package me.whiteship.refactoring._05_global_data._17_encapsulate_variable;

public class Thermostats {

    public static Integer targetTemperature = 70;

    public static Boolean heating = true;

    public static Boolean cooling = false;

    public static Boolean readInFahrenheit = true;

    public static Integer getTargetTemperature() {
        return targetTemperature;
    }

    public static void setTargetTemperature(Integer targetTemperature) {
        Thermostats.targetTemperature = targetTemperature;
    }

    public static Boolean getHeating() {
        return heating;
    }

    public static void setHeating(Boolean heating) {
        Thermostats.heating = heating;
    }

    public static Boolean getCooling() {
        return cooling;
    }

    public static void setCooling(Boolean cooling) {
        Thermostats.cooling = cooling;
    }

    public static Boolean getReadInFahrenheit() {
        return readInFahrenheit;
    }

    public static void setReadInFahrenheit(Boolean readInFahrenheit) {
        Thermostats.readInFahrenheit = readInFahrenheit;
    }
}

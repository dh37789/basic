package me.whiteship.refactoring._12_repeated_swtiches;

import java.util.HashMap;
import java.util.Map;

public class EmployeeFactory {

    private static Map<String, Employee> employeeMap = new HashMap<>();

    static {
        employeeMap.put("full-time", new FullTimeEmployee());
        employeeMap.put("part-time", new PartTimeEmployee());
        employeeMap.put("temporal", new TemporalEmployee());
    }

    public static Employee createEmployee(String type) {
        if (employeeMap.containsKey(type))
            return getInstanceEmployee(type);
        else
            throw new IllegalArgumentException(type);
    }

    private static Employee getInstanceEmployee(String type) {
        return employeeMap.get(type);
    }
}

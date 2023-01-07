package me.whiteship.refactoring._12_repeated_swtiches;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void vacationHours_refactor() {
        Employee si = EmployeeFactory.createEmployee("full-time");
        assertEquals(120, si.vacationHours());
    }
}
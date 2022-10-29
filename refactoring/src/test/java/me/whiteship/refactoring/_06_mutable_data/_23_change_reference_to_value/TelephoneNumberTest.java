package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelephoneNumberTest {

    @Test
    void telephone_동일성_비교() {
        TelephoneNumber number1 = new TelephoneNumber("123", "1234");
        TelephoneNumber number2 = new TelephoneNumber("123", "1234");
        assertEquals(number1, number2);
    }

    @Test
    void recordTelephone_동일성_비교() {
        TelephoneNumberRecord number1 = new TelephoneNumberRecord("123", "1234");
        TelephoneNumberRecord number2 = new TelephoneNumberRecord("123", "1234");
        assertEquals(number1, number2);
    }
}

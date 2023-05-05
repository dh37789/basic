package com.effectiveJava.item31;

import java.util.Arrays;
import java.util.List;

public class Test {

    public List<String> getStringList(String... words) {
        return Arrays.asList(words);
    }
}

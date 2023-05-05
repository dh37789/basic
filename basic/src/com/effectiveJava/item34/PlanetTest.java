package com.effectiveJava.item34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {

    @Test
    void 행성_무게_출력_Test() {
        double earthWeight = 60.0D;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("%s에서의 무게는 %f이다.%n", p, p.surfaceWeight(mass));
    }

}
package com.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExample {

    private Main m = new Main();

    @Test
    public void testExample() {
        Assertions.assertThrows(RuntimeException.class, () -> m.generateCombinations(3));
    }

}

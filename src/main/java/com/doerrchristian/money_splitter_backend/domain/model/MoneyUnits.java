package com.doerrchristian.money_splitter_backend.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoneyUnits {
    public static List<BigDecimal> getUnits() {
        return Stream.of("200.0", "100.0", "50.0", "20.0", "10.0", "5.0", "2.0", "1.0", "0.5", "0.2", "0.1", "0.05", "0.02", "0.01")
                .map(BigDecimal::new)
                .collect(Collectors.toList());
    }
}

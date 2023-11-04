package com.doerrchristian.money_splitter_backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class MoneyData {

    private String moneyUnitFormatted;

    private Integer newAmount;

    private Integer oldAmount;

    private Integer difference;

}

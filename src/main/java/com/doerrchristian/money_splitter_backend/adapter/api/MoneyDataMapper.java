package com.doerrchristian.money_splitter_backend.adapter.api;

import com.doerrchristian.money_splitter_backend.domain.model.MoneyData;
import org.openapitools.model.MoneyCalculationDto;
import org.openapitools.model.MoneyDataDto;

import java.util.List;
import java.util.stream.Collectors;

public class MoneyDataMapper {

    public static MoneyCalculationDto mapping(List<MoneyData> moneyData) {
        return new MoneyCalculationDto()
                .data(moneyData.stream()
                        .map(MoneyDataMapper::mapping)
                        .collect(Collectors.toList())
                );
    }

    public static MoneyDataDto mapping(MoneyData moneyData) {
        return new MoneyDataDto()
                .moneyUnitFormatted(moneyData.moneyUnitFormatted())
                .newAmount(moneyData.newAmount())
                .oldAmount(moneyData.oldAmount())
                .difference(moneyData.difference());
    }

}

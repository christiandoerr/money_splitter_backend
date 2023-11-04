package com.doerrchristian.money_splitter_backend.domain.model;

import com.doerrchristian.money_splitter_backend.domain.model.exceptions.NegativeNumberException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MoneyCalculationImpl {

    public static List<MoneyData> calculate(BigDecimal newValue, BigDecimal oldValue) {

        if ((newValue.compareTo(BigDecimal.ZERO) < 0) || (oldValue.compareTo(BigDecimal.ZERO) < 0)) {
            throw new NegativeNumberException();
        }

        List<MoneyData> moneyData = new ArrayList<>();
        for (BigDecimal moneyUnit : MoneyUnits.getUnits()) {
            moneyData.add(new MoneyData(MoneyUtils.getCurrency(moneyUnit),
                    MoneyUtils.getAmount(moneyUnit, newValue),
                    MoneyUtils.getAmount(moneyUnit, oldValue),
                    MoneyUtils.getDifference(moneyUnit, oldValue, newValue)));

            newValue = newValue.remainder(moneyUnit);
            oldValue = oldValue.remainder(moneyUnit);
        }
        return moneyData;
    }

}

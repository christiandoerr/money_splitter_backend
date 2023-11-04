package com.doerrchristian.money_splitter_backend.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class MoneyUtils {

    public static int getAmount(BigDecimal moneyUnit, BigDecimal value) {
        return value.divide(moneyUnit, RoundingMode.FLOOR).setScale(0, RoundingMode.FLOOR).unscaledValue().intValue();
    }

    public static int getDifference(BigDecimal moneyUnit, BigDecimal oldValue, BigDecimal newValue) {
        return MoneyUtils.getAmount(moneyUnit, newValue) - MoneyUtils.getAmount(moneyUnit, oldValue);
    }

    public static String getCurrency(BigDecimal number) {
        return NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("de").setRegion("DE").build()).format(number);
    }

}

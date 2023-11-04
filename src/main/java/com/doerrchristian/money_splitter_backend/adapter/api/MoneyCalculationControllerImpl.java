package com.doerrchristian.money_splitter_backend.adapter.api;

import com.doerrchristian.money_splitter_backend.domain.model.MoneyCalculationImpl;
import com.doerrchristian.money_splitter_backend.domain.model.exceptions.NegativeNumberException;
import org.openapitools.api.MoneycalculationApi;
import org.openapitools.model.MoneyCalculationDto;
import org.openapitools.model.MoneyCalculationErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MoneyCalculationControllerImpl implements MoneycalculationApi {

    private final static String USER_AGENT = "User-Agent";

    @Override
    @CrossOrigin(origins = "*", methods = {RequestMethod.PUT}, allowedHeaders = {USER_AGENT})
    public ResponseEntity<MoneyCalculationDto> calcMoneyCalculation(
            BigDecimal newValue,
            BigDecimal oldValue
    ) {
        return ResponseEntity.ok().body(MoneyDataMapper.mapping(MoneyCalculationImpl.calculate(newValue, oldValue)));
    }

    @ExceptionHandler({NegativeNumberException.class})
    public ResponseEntity<MoneyCalculationErrorDto> handlingException() {
        return ResponseEntity.badRequest().body(new MoneyCalculationErrorDto()
                .errorCode(MoneyCalculationErrorDto.ErrorCodeEnum.NEGATIVE_NUMBER)
                .errorDescription("Value must be greater or equal than zero!"));
    }

}
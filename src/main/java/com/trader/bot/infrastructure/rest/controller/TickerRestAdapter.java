package com.trader.bot.infrastructure.rest.controller;

import com.trader.bot.application.usecase.ITickerInterator;
import com.trader.bot.common.TickerDto;
import com.trader.bot.infrastructure.rest.mapper.TickerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")
@RequiredArgsConstructor
public class TickerRestAdapter {

    private final ITickerInterator tickerInterator;

    @GetMapping("/{symbol}")
    public ResponseEntity<TickerDto> getTicker(@PathVariable String symbol) {

        return new ResponseEntity<>(TickerDtoMapper.fromTickerToTickerDto(tickerInterator.getTicker(symbol)), HttpStatus.OK);
    }
}

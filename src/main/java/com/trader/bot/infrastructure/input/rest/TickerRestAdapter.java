package com.trader.bot.infrastructure.input.rest;

import com.trader.bot.application.input.GetTickerUserCase;
import com.trader.bot.domain.model.Ticker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")
@RequiredArgsConstructor
public class TickerRestAdapter {

    private final GetTickerUserCase getTickerUseCase;

    @GetMapping("/{symbol}")
    public Ticker getTicker(@PathVariable String symbol) {

        return getTickerUseCase.getTicker(symbol);
    }
}

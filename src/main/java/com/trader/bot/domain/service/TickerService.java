package com.trader.bot.domain.service;

import com.trader.bot.application.input.GetTickerUserCase;
import com.trader.bot.application.output.TickerOutputPort;
import com.trader.bot.domain.model.Ticker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TickerService implements GetTickerUserCase {

    private final TickerOutputPort tickerOutputPort;

    @Override
    public Ticker getTicker(String symbol) {
        System.out.println("Getting ticker for " + symbol + " symbol");
        return tickerOutputPort.getTicker(symbol);
    }
}

package com.trader.bot.application.usecase;

import com.trader.bot.domain.model.Ticker;
import com.trader.bot.domain.port.TickerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TickerInteratorImpl implements ITickerInterator{

    private final TickerPort tickerPort;

    public Ticker getTicker(String symbol) {

        return tickerPort.getTicker(symbol);
    }
}

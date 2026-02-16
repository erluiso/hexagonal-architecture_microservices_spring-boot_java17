package com.trader.bot.infrastructure.output;

import com.trader.bot.domain.model.Ticker;
import com.trader.bot.infrastructure.output.adapter.KucoinAdapter;
import com.trader.bot.infrastructure.output.rest.KucoinApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TickerOutputPort implements com.trader.bot.application.output.TickerOutputPort {

    private final KucoinApi kucoinApi;
    private final KucoinAdapter kucoinAdapter;

    @Override
    public Ticker getTicker(String symbol) {

        try {
            return kucoinAdapter.toTicker(kucoinApi.getTicker(symbol));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new Ticker();
        }
    }
}

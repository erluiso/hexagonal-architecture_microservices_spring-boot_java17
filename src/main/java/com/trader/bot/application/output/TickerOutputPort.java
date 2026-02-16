package com.trader.bot.application.output;

import com.trader.bot.domain.model.Ticker;

public interface TickerOutputPort {

    Ticker getTicker(String symbol);

}

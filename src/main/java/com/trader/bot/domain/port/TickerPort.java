package com.trader.bot.domain.port;

import com.trader.bot.domain.model.Ticker;

public interface TickerPort {

    Ticker getTicker(String symbol);
}

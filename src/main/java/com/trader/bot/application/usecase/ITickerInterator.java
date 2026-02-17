package com.trader.bot.application.usecase;

import com.trader.bot.domain.model.Ticker;

public interface ITickerInterator {
    
    Ticker getTicker(String symbol);
}

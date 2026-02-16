package com.trader.bot.application.input;

import com.trader.bot.domain.model.Ticker;

public interface GetTickerUserCase {

    Ticker getTicker(String symbol);

}

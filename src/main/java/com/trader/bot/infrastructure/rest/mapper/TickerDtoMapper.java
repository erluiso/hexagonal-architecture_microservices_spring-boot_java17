package com.trader.bot.infrastructure.rest.mapper;

import com.trader.bot.common.TickerDto;
import com.trader.bot.domain.model.Ticker;

public class TickerDtoMapper {

    public static TickerDto fromTickerToTickerDto(Ticker ticker)
    {
        return new TickerDto(
                ticker.getPrice(),
                ticker.getBestBid(),
                ticker.getBestBidSize(),
                ticker.getBestAsk(),
                ticker.getBestAskSize()
        );
    }
}

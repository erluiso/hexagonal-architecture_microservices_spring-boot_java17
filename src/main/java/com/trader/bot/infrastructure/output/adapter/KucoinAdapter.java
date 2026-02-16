package com.trader.bot.infrastructure.output.adapter;

import com.trader.bot.domain.model.Ticker;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class KucoinAdapter {

    public Ticker toTicker(JSONObject data)
    {
        return new Ticker(
                (String) data.get("price"),
                (String) data.get("bestBid"),
                (String) data.get("bestBidSize"),
                (String) data.get("bestAsk"),
                (String) data.get("bestAskSize")
        );
    }
}

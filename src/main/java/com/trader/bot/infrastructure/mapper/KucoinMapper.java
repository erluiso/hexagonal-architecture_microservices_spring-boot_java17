package com.trader.bot.infrastructure.mapper;

import com.trader.bot.domain.model.Ticker;
import org.json.JSONObject;

public class KucoinMapper {

    public static Ticker fromKucoinObjectToTicker(JSONObject object) {
        return new Ticker(
                (String) object.get("price"),
                (String) object.get("bestBid"),
                (String) object.get("bestBidSize"),
                (String) object.get("bestAsk"),
                (String) object.get("bestAskSize")
        );
    }
}

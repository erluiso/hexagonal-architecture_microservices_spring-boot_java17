package com.trader.bot.infrastructure.client;

import com.squareup.okhttp.*;
import com.trader.bot.domain.model.Ticker;
import com.trader.bot.domain.port.TickerPort;
import com.trader.bot.infrastructure.mapper.KucoinMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KucoinApi implements TickerPort {

    public Ticker getTicker(String symbol) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.kucoin.com/api/v1/market/orderbook/level1?symbol=" + symbol + "-USDT")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {

                JSONObject resJson = new JSONObject(response.body().string());

                if (!resJson.get("code").equals("200000"))
                    throw new Exception("Kucoin error code: " + resJson.get("code"));

                if (resJson.isNull("data"))
                    throw new Exception("No data for the symbol: " + symbol);

                System.out.println("Returning ticker for " + symbol + " symbol => [" + resJson.get("data").toString() + "]");

                return KucoinMapper.fromKucoinObjectToTicker(new JSONObject(resJson.get("data").toString()));
            } else {
                throw new Exception("Error connecting with Kucoin API");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new Ticker();
        }
    }
}

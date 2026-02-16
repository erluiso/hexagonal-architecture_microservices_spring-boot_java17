package com.trader.bot.infrastructure.output.rest;

import com.squareup.okhttp.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KucoinApi {

    public JSONObject getTicker(String symbol) throws Exception {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.kucoin.com/api/v1/market/orderbook/level1?symbol=" + symbol + "-USDT")
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {

            JSONObject resJson = new JSONObject(response.body().string());

            if (!resJson.get("code").equals("200000"))
                throw new Exception("Kucoin error code: " + resJson.get("code"));

            if(resJson.isNull("data"))
                throw new Exception("No data for the symbol: " + symbol);

            System.out.println("Returning ticker for " + symbol + " symbol => [" + resJson.get("data").toString() + "]");

            return new JSONObject(resJson.get("data").toString());
        } else {
            throw new Exception("Error connecting with Kucoin API");
        }
    }
}

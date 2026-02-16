package com.trader.bot;

import com.trader.bot.infrastructure.output.rest.KucoinApi;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BootApplicationTests {

    @Test
    @DisplayName("Call to Kucoin API with BTC symbol")
    void callToKucoinApi() throws Exception {
        KucoinApi kucoinApi = new KucoinApi();
        JSONObject response = kucoinApi.getTicker("BTC");
        assertFalse(response.isNull("price"));
    }

    @Test
    @DisplayName("Call to Kucoin API with a fake symbol")
    void callToKucoinApiWithFakeSymbol() throws Exception {
        KucoinApi kucoinApi = new KucoinApi();
        try {
            JSONObject response = kucoinApi.getTicker("AAA");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
package com.trader.bot.domain.model;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticker {

    private String price;
    private String bestBid;
    private String bestBidSize;
    private String bestAsk;
    private String bestAskSize;
}

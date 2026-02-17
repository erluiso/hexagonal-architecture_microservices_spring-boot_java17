package com.trader.bot.common;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TickerDto {

    private String price;
    private String bestBid;
    private String bestBidSize;
    private String bestAsk;
    private String bestAskSize;
}

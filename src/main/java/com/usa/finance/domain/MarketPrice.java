package com.usa.finance.domain;

import lombok.Data;

@Data
public class MarketPrice {

    private String market;

    private String candleDateTimeUtc;

    private String candleDateTimeKst;

    private Double opening_price;

    private Double high_price;

    private Double low_price;

    private Double trade_price;

    private Long timestamp;

    private Double candle_acc_trade_price;

    private Double candle_acc_trade_volume;

    private Double prev_closing_price;

    private Double change_price;

    private Double change_rate;

    private Double converted_trade_price;

}

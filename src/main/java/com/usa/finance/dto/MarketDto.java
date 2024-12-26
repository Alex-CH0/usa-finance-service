package com.usa.finance.dto;

import lombok.Getter;

@Getter
public class MarketDto {

    private Long marketId;

    private String market;

    private String koreanName;

    private String englishName;

    private String marketWarning;

    public MarketDto(String market, String koreanName, String englishName, String marketWarning) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.marketWarning = marketWarning;
    }
}

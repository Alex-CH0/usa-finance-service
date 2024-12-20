package com.usa.finance.client;

import com.usa.finance.domain.Market;
import com.usa.finance.domain.MarketPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bithumb", url = "api.bithumb.com/v1")
public interface BithumbServiceClient {

    @GetMapping("/market/all")
    List<Market> getAllMarket();


    @GetMapping("/candles/minutes")
    List<MarketPrice> getCandlesMin();


    @GetMapping("/candles/days")
    List<MarketPrice> getCandlesDay();


    @GetMapping("/candles/weeks")
    List<MarketPrice> getCandlesWeek();


    @GetMapping("/candles/months")
    List<MarketPrice> getCandlesMonth();

}

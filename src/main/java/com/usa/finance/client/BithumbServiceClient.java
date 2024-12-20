package com.usa.finance.client;

import com.usa.finance.domain.Market;
import com.usa.finance.domain.MarketCurrentPrice;
import com.usa.finance.domain.MarketPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "bithumb", url = "https://api.bithumb.com/v1")
public interface BithumbServiceClient {

    @GetMapping("/market/all")
    List<Market> getAllMarket();


    @GetMapping("/candles/minutes/{unit}")
    List<MarketPrice> getCandlesMin(
            @PathVariable int unit,
            @RequestParam String market,
            @RequestParam String to,
            @RequestParam int count
    );


    @GetMapping("/candles/days")
    List<MarketPrice> getCandlesDay(
            @SpringQueryMap Map<String, Object> queryParameters
    );


    @GetMapping("/candles/weeks")
    List<MarketPrice> getCandlesWeek(
            @RequestParam String market,
            @RequestParam String to,
            @RequestParam int count
    );


    @GetMapping("/candles/months")
    List<MarketPrice> getCandlesMonth(
            @RequestParam String market,
            @RequestParam String to,
            @RequestParam int count
    );

    @GetMapping("/ticker")
    List<MarketCurrentPrice> getCurrentPrice(
            @RequestParam String markets
    );
}

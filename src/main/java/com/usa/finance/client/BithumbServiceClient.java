package com.usa.finance.client;

import com.usa.finance.domain.Market;
import com.usa.finance.domain.MarketCurrentPrice;
import com.usa.finance.domain.MarketCandle;
import com.usa.finance.dto.MarketCandleDto;
import com.usa.finance.dto.MarketCurrentPriceDto;
import com.usa.finance.dto.MarketDto;
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
    List<MarketDto> getAllMarket();


    @GetMapping("/candles/minutes/{unit}")
    List<MarketCandleDto> getCandlesMin(
            @PathVariable int unit,
            @RequestParam String market,
            @RequestParam String to,
            @RequestParam int count
    );


    @GetMapping("/candles/days")
    List<MarketCandleDto> getCandlesDay(
            @SpringQueryMap Map<String, Object> queryParameters
    );


    @GetMapping("/candles/weeks")
    List<MarketCandleDto> getCandlesWeek(
            @RequestParam String market,
            @RequestParam String to,
            @RequestParam int count
    );


    @GetMapping("/candles/months")
    List<MarketCandleDto> getCandlesMonth(
            @RequestParam String market,
            @RequestParam String to,
            @RequestParam int count
    );

    @GetMapping("/ticker")
    List<MarketCurrentPriceDto> getCurrentPrice(
            @RequestParam String markets
    );
}

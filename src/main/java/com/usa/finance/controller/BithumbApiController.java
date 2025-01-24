package com.usa.finance.controller;

import com.usa.finance.client.BithumbServiceClient;
import com.usa.finance.dto.MarketCandleDto;
import com.usa.finance.dto.MarketCurrentPriceDto;
import com.usa.finance.dto.MarketDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BithumbApiController {

    private final BithumbServiceClient bithumbServiceClient;

    @GetMapping("/market")
    public List<MarketDto> getMarket() {
        return bithumbServiceClient.getAllMarket();
    }

    @GetMapping("/candle/{market}")
    public List<MarketCandleDto> getCandles(@PathVariable String market, @RequestParam int count) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("market", market);
        queryParam.put("count", count);
        return bithumbServiceClient.getCandlesDay(queryParam);
    }

    @GetMapping("/current/{market}")
    public List<MarketCurrentPriceDto> getCurrentPrice(@PathVariable String markets) {
        return bithumbServiceClient.getCurrentPrice(markets);
    }
}

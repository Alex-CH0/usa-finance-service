package com.usa.finance.service;

import com.usa.finance.domain.Market;
import com.usa.finance.dto.MarketDto;
import com.usa.finance.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;

    public Long save(MarketDto marketDto) {

        return marketRepository.save(Market.builder()
                .market(marketDto.getMarket())
                .korean_name(marketDto.getKorean_name())
                .english_name(marketDto.getEnglish_name())
                .market_warning(marketDto.getMarket_warning()).build()).getMarketId();
    }


}

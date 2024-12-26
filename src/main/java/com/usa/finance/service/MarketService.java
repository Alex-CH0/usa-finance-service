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
                .korean_name(marketDto.getKoreanName())
                .english_name(marketDto.getEnglishName())
                .market_warning(marketDto.getMarketWarning()).build()).getMarketId();
    }

    public Market findById(Long marketId) {
        return marketRepository.findByMarketId(marketId)
                .orElseThrow(() -> new IllegalArgumentException("Market Not Found"));
    }

    public Market findByEnglishName(String marketEng) {
        return marketRepository.findByEnglishName(marketEng)
                .orElseThrow(() -> new IllegalArgumentException("Market Not Found"));
    }

    public Market findByKoreanName(String marketKor) {
        return marketRepository.findByKoreanName(marketKor)
                .orElseThrow(() -> new IllegalArgumentException("Market Not Found"));
    }


}

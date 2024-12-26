package com.usa.finance.repository;

import com.usa.finance.domain.Market;
import com.usa.finance.dto.MarketDto;
import com.usa.finance.service.MarketService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private MarketService marketService;


    @Test
    @DisplayName("정상 종목 조회 케이스")
    @Transactional
    void saveMarket() {
        // given
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MarketDto marketDto = new MarketDto("BTC-KRW", "비트코인", "Bitcoin", "NONE");
        Market market = mapper.map(marketDto, Market.class);

        // when
        Market savedMarket = marketRepository.save(market);


        // then
        Assertions.assertThat(market).isSameAs(savedMarket);

        Assertions.assertThat(market.getMarket()).isEqualTo(savedMarket.getMarket());
        Assertions.assertThat(market.getEnglishName()).isEqualTo(savedMarket.getEnglishName());
        Assertions.assertThat(market.getKoreanName()).isEqualTo(savedMarket.getKoreanName());
        Assertions.assertThat(market.isMarketWarning()).isEqualTo(savedMarket.isMarketWarning());

        Assertions.assertThat(savedMarket.getMarketId()).isNotNull();
        Assertions.assertThat(marketRepository.count()).isEqualTo(1);

        // FIXME 수정필요

    }

}

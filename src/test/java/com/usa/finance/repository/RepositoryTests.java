package com.usa.finance.repository;

import com.usa.finance.domain.Market;
import com.usa.finance.dto.MarketDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {

    @Autowired
    private MarketRepository marketRepository;

    @Test
    @DisplayName("정상 종목 저장 및 조회 케이스")
    void saveMarket() {
        // given
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MarketDto marketDto = new MarketDto("BTC-KRW", "비트코인", "Bitcoin", "NONE");
        Market market = Market.builder()
                .market(marketDto.getMarket())
                .korean_name(marketDto.getKoreanName())
                .english_name(marketDto.getKoreanName())
                .market_warning(marketDto.getMarketWarning())
                .build();

        // when
        Market savedMarket = marketRepository.save(market);

        // then
        Assertions.assertThat(savedMarket).isNotNull();
        Assertions.assertThat(savedMarket.getMarketId()).isNotNull();
        Assertions.assertThat(savedMarket.getMarket()).isEqualTo(market.getMarket());
        Assertions.assertThat(savedMarket.getEnglishName()).isEqualTo(market.getEnglishName());
        Assertions.assertThat(savedMarket.getKoreanName()).isEqualTo(market.getKoreanName());
        Assertions.assertThat(savedMarket.isMarketWarning()).isEqualTo(market.isMarketWarning());
        Assertions.assertThat(marketRepository.count()).isEqualTo(1);
    }
    @Test
    @DisplayName("중복된 시장 정보 저장 시도")
    void saveDuplicateMarket() {
        // given
        Market market1 = Market.builder()
                .market("BTC-KRW")
                .korean_name("비트코인")
                .english_name("Bitcoin")
                .market_warning("NONE")
                .build();

        Market market2 = Market.builder()
                .market("BTC-KRW")
                .korean_name("비트코인")
                .english_name("Bitcoin")
                .market_warning("NONE")
                .build();

        // when
        marketRepository.save(market1);
        Exception exception = (Exception) Assertions.catchThrowable(() -> marketRepository.save(market2));

        // then
        Assertions.assertThat(exception).isInstanceOf(Exception.class);
    }

    @Test
    @DisplayName("존재하지 않는 시장 정보 조회")
    void findNonExistentMarket() {
        // when
        Market market = marketRepository.findByMarketId(999L).orElse(null);

        // then
        Assertions.assertThat(market).isNull();
    }

    @Test
    @DisplayName("시장 정보 삭제")
    void deleteMarket() {
        // given
        Market market = Market.builder()
                .market("BTC-KRW")
                .korean_name("비트코인")
                .english_name("Bitcoin")
                .market_warning("NONE")
                .build();
        Market savedMarket = marketRepository.save(market);

        // when
        marketRepository.delete(savedMarket);
        Market deletedMarket = marketRepository.findByMarketId(savedMarket.getMarketId()).orElse(null);

        // then
        Assertions.assertThat(deletedMarket).isNull();
    }

}

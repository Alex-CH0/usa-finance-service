package com.usa.finance.repository;

import com.usa.finance.domain.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, Integer> {
    Optional<Market> findByMarketId(Long id);

    Optional<Market> findByEnglishName(String englishName);

    Optional<Market> findByKoreanName(String koreanName);
}

package com.usa.finance.repository;

import com.usa.finance.domain.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Integer> {
    Market findByMarketId(Integer id);
}

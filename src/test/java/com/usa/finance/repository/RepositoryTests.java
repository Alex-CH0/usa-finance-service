package com.usa.finance.repository;

import com.usa.finance.dto.MarketDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTests {


    @Test
    @DisplayName("정상 종목 조회 케이스")
    @Transactional
    void saveMarket() {


        MarketDto marketDto = new MarketDto();
    }

}

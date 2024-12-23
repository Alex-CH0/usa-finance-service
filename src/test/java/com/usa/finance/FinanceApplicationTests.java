package com.usa.finance;

import com.usa.finance.client.BithumbServiceClient;
import com.usa.finance.domain.Market;
import com.usa.finance.dto.MarketDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FinanceApplicationTests {


	@Test
	@DisplayName("정상 종목 조회 케이스")
	@Transactional
	void saveMarket(){



		MarketDto marketDto = new MarketDto();
	}

}

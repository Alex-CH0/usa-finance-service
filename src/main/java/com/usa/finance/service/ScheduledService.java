package com.usa.finance.service;

import com.usa.finance.domain.Market;
import com.usa.finance.dto.MarketDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class ScheduledService {

    public void updateDailyPrice(){

    }

}

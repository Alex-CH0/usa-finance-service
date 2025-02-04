package com.usa.finance.service;

import com.usa.finance.client.BithumbServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BithumbService {

    private final BithumbServiceClient bithumbServiceClient;

    // TODO 3. Scheduled 로 ticker 조회 및 저장.
    // TODO 4.

}

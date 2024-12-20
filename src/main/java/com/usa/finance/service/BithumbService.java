package com.usa.finance.service;

import com.usa.finance.client.BithumbServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BithumbService {

    private final BithumbServiceClient bithumbServiceClient;


}

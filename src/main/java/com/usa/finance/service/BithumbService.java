package com.usa.finance.service;

import com.usa.finance.client.BithumbServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BithumbService {

    private final BithumbServiceClient bithumbServiceClient;

    // TODO jpa 연결하고, DB 구축 후 DB에 데이터 넣을 생각 해보자....
    // TODO 1. DB 로컬에서 띄우기.
    // TODO 2. JPA 및 repository 생성
    // TODO 3. Scheduled 로 ticker 조회 및 저장.
    // TODO 4.

}

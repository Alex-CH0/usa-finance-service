package com.usa.finance.controller;

import com.usa.finance.service.BithumbService;
import com.usa.order.domain.Order;
import com.usa.order.dto.OrderDto;
import com.usa.order.kafka.KafkaProducer;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BithumbApiController {

    private final BithumbService bithumbService;

/*    @GetMapping("/market")
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {


        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);

    }*/
}

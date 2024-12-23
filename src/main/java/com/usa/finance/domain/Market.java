package com.usa.finance.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "market", schema = "finance")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_id")
    private Long marketId;

    @Comment("빗썸에서 제공중인 시장 정보")
    @Column(unique = true, nullable = false)
    private String market;

    @Comment("거래 대상 디지털 자산 한글명")
    @Column(nullable = false)
    private String korean_name;

    @Comment("거래 대상 디지털 자산 영문명")
    @Column(nullable = false)
    private String english_name;

    @Comment("유의 종목 여부: NONE or CAUTION")
    @Column(nullable = false)
    private String market_warning;

}

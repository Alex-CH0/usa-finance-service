package com.usa.finance.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Entity
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
    private String koreanName;

    @Comment("거래 대상 디지털 자산 영문명")
    @Column(nullable = false)
    private String englishName;

    @Comment("유의 종목 여부: NONE or CAUTION")
    @Column(columnDefinition = "boolean default false")
    private boolean marketWarning;

    @Builder
    public Market(String market_warning, String english_name, String korean_name, String market) {

        this.marketWarning = market_warning.equals("CAUTION");
        this.englishName = english_name;
        this.koreanName = korean_name;
        this.market = market;
    }
}

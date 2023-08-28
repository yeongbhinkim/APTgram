package com.project.apt.realestate.vo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
public class TradeHistoryVO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tradeHistoryId;   // 실거래기록 번호
    private String accYear;       // 접수연도
    private String sggCd;         // 자치구코드
    private String sggNm;         // 자치구명
    private String bjdongCd;      // 법정동코드
    private String bjdongNm;      // 법정동명
    private String landGbn;       // 지번구분
    private String landGbnMm;     // 지번구분명
    private String bonbeon;       // 본번
    private String bubeon;        // 부번
    private String bldgNm;        // 건물명
    private String dealYmd;       // 계약일
    private String objAmt;        // 물건금액(만원)
    private String bldgArea;      // 건물면적(m₂)
    private String totArea;       // 토지면적(m₂)
    private String floor;         // 층
    private String rightGbn;      // 권리구분
    private String cntlYmd;       // 취소일
    private String buildYear;     // 건축연도
    private String houseType;     // 건물용도
    private String reqGbn;        // 신고구분
    private String rdealerLawDnm; // 신고한 공인중개사 시군구명
}

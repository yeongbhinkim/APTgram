package com.project.apt.realestate.vo;

import com.project.apt.realestate.dto.TradeHistoryResponseDto.TbLnOpendataRtmsV.InnerRow;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TradeHistoryVO extends BaseVO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tradeHistoryId;   // 실거래기록 번호
    private String accYear;       // 접수연도
    private String sggCd;         // 자치구코드
    private String sggNm;         // 자치구명
    private String bjdongCd;      // 법정동코드
    private String bjdongNm;      // 법정동명
    private String landGbn;       // 지번구분
    private String landGbnNm;     // 지번구분명
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
    private String rdealerLawdnm; // 신고한 공인중개사 시군구명

    public static TradeHistoryVO createFromJson(InnerRow innerRow) {
        return TradeHistoryVO
                .builder()
                .accYear(innerRow.getAccYear())
                .sggCd(innerRow.getSggCd())
                .sggNm(innerRow.getSggNm())
                .bjdongCd(innerRow.getBjdongCd())
                .bjdongNm(innerRow.getBjdongNm())
                .landGbn(innerRow.getLandGbn())
                .landGbnNm(innerRow.getLandGbnNm())
                .bonbeon(innerRow.getBonbeon())
                .bubeon(innerRow.getBubeon())
                .bldgNm(innerRow.getBldgNm())
                .dealYmd(innerRow.getDealYmd())
                .objAmt(innerRow.getObjAmt())
                .bldgArea(innerRow.getBldgArea())
                .totArea(innerRow.getTotArea())
                .floor(innerRow.getFloor())
                .rightGbn(innerRow.getRightGbn())
                .cntlYmd(innerRow.getCntlYmd())
                .buildYear(innerRow.getBuildYear())
                .houseType(innerRow.getHouseType())
                .reqGbn(innerRow.getReqGbn())
                .rdealerLawdnm(innerRow.getRdealerLawdnm())
                .build();
    }
}

package com.project.apt.realestate.vo;

import com.project.apt.realestate.dto.LeaseHistoryResponseDto.TbLnOpendataRentV.InnerRow;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "LEASE_HISTORY")
@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LeaseHistoryVO extends BaseVO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leasehistoryId;         // 전월세기록 번호
    private String accYear;           // 접수연도
    private String sggCd;             // 자치구코드
    private String sggNm;             // 자치구명
    private String bjdongCd;          // 법정동코드
    private String bjdongNm;          // 법정동명
    private String landGbn;           // 지번구분
    private String landGbnNm;         // 지번구분명
    private String bobn;              // 본번
    private String bubn;              // 부번
    private String flrNo;             // 층
    private String cntrctDe;          // 계약일
    private String rentGbn;           // 전월세구분
    private String rentArea;          // 임대면적
    private String rentGtn;           // 보증금(만원)
    private String rentFee;           // 임대료(만원)
    private String bldgNm;            // 건물명
    private String buildYear;         // 건축연도
    private String houseGbnNm;        // 건물용도
    private String cntrctPrd;         // 계약기간
    private String newRonSecd;        // 신규갱신여부
    private String beforeGrntyAmount; // 종전보증금
    private String beforeMtRentChrge; // 종전임대료

    public static LeaseHistoryVO createFromJson(InnerRow innerRow) {
        return LeaseHistoryVO
                .builder()
                .accYear(innerRow.getAccYear())
                .sggCd(innerRow.getSggCd())
                .sggNm(innerRow.getSggNm())
                .bjdongCd(innerRow.getBjdongCd())
                .bjdongNm(innerRow.getBjdongNm())
                .landGbn(innerRow.getLandGbn())
                .landGbnNm(innerRow.getLandGbnNm())
                .bobn(innerRow.getBobn())
                .bubn(innerRow.getBubn())
                .flrNo(innerRow.getFlrNo())
                .cntrctDe(innerRow.getCntrctDe())
                .rentGbn(innerRow.getRentGbn())
                .rentArea(innerRow.getRentArea())
                .rentGtn(innerRow.getRentGtn())
                .rentFee(innerRow.getRentFee())
                .bldgNm(innerRow.getBldgNm())
                .buildYear(innerRow.getBuildYear())
                .houseGbnNm(innerRow.getHouseGbnNm())
                .cntrctPrd(innerRow.getCntrctPrd())
                .newRonSecd(innerRow.getNewRonSecd())
                .beforeGrntyAmount(innerRow.getBeforeGrntyAmount())
                .beforeMtRentChrge(innerRow.getBeforeMtRentChrge())
                .build();
    }
}

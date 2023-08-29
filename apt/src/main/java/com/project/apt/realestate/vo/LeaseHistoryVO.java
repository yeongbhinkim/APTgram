package com.project.apt.realestate.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
public class LeaseHistoryVO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int LEASEHISTORY_ID;         // 전월세기록 번호
    private String ACC_YEAR;             // 접수연도
    private String SGG_CD;               // 자치구코드
    private String SGG_NM;               // 자치구명
    private String BJDONG_CD;            // 법정동코드
    private String BJDONG_NM;            // 법정동명
    private String LAND_GBN;             // 지번구분
    private String LAND_GBN_NM;          // 지번구분명
    private String BOBN;                 // 본번
    private String BUBN;                 // 부번
    private String FLR_NO;               // 층
    private String CNTRCT_DE;            // 계약일
    private String RENT_GBN;             // 전월세구분
    private String RENT_AREA;            // 임대면적
    private String RENT_GTN;             // 보증금(만원)
    private String RENT_FEE;             // 임대료(만원)
    private String BLDG_NM;              // 건물명
    private String BUILD_YEAR;           // 건축연도
    private String HOUSE_GBN_NM;         // 건물용도
    private String CNTRCT_PRD;           // 계약기간
    private String NEW_RON_SECD;         // 신규갱신여부
    private String BEFORE_GRNTY_AMOUNT;  // 종전보증금
    private String BEFORE_MT_RENT_CHRGE; // 종전임대료
}

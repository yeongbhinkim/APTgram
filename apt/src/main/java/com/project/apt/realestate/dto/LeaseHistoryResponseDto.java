package com.project.apt.realestate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 서울시 실거래가 데이터 응답받는 Dto
 */
@Data
public class LeaseHistoryResponseDto {
    private TbLnOpendataRentV tbLnOpendataRentV;

    /**
     * 내부클래스를 이용해 JSON 파싱
     */
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TbLnOpendataRentV {
        @JsonProperty("list_total_count")
        private String listTotalCount;
        @JsonProperty("RESULT")
        private InnerResult result;
        private InnerRow[] row;


        /**
         * 내부클래스를 이용해 JSON 파싱
         */
        @Data
        public static class InnerResult {
            @JsonProperty("CODE")
            private String code;
            @JsonProperty("MESSAGE")
            private String message;
        }

        /**
         * 내부클래스를 이용해 JSON 파싱
         */
        @Data
        public static class InnerRow {
            @JsonProperty("ACC_YEAR")
            private String accYear;           // 접수연도
            @JsonProperty("SGG_CD")
            private String sggCd;             // 자치구코드
            @JsonProperty("SGG_NM")
            private String sggNm;             // 자치구명
            @JsonProperty("BJDONG_CD")
            private String bjdongCd;          // 법정동코드
            @JsonProperty("BJDONG_NM")
            private String bjdongNm;          // 법정동명
            @JsonProperty("LAND_GBN")
            private String landGbn;           // 지번구분
            @JsonProperty("LAND_GBN_NM")
            private String landGbnNm;         // 지번구분명
            @JsonProperty("BOBN")
            private String bobn;              // 본번
            @JsonProperty("BUBN")
            private String bubn;              // 부번
            @JsonProperty("FLR_NO")
            private String flrNo;             // 층
            @JsonProperty("CNTRCT_DE")
            private String cntrctDe;          // 계약일
            @JsonProperty("RENT_GBN")
            private String rentGbn;           // 전월세구분
            @JsonProperty("RENT_AREA")
            private String rentArea;          // 임대면적
            @JsonProperty("RENT_GTN")
            private String rentGtn;           // 보증금(만원)
            @JsonProperty("RENT_FEE")
            private String rentFee;           // 임대료(만원)
            @JsonProperty("BLDG_NM")
            private String bldgNm;            // 건물명
            @JsonProperty("BUILD_YEAR")
            private String buildYear;         // 건축연도
            @JsonProperty("HOUSE_GBN_NM")
            private String houseGbnNm;        // 건물용도
            @JsonProperty("CNTRCT_PRD")
            private String cntrctPrd;         // 계약기간
            @JsonProperty("NEW_RON_SECD")
            private String newRonSecd;        // 신규갱신여부
            @JsonProperty("BEFORE_GRNTY_AMOUNT")
            private String beforeGrntyAmount; // 종전보증금
            @JsonProperty("BEFORE_MT_RENT_CHRGE")
            private String beforeMtRentChrge; // 종전임대료
        }
    }
}




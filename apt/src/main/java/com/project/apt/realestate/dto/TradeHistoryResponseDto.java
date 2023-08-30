package com.project.apt.realestate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 서울시 실거래가 데이터 응답받는 Dto
 */
@Data
public class TradeHistoryResponseDto {
    private TbLnOpendataRtmsV tbLnOpendataRtmsV;

    /**
     * 내부클래스를 이용해 JSON 파싱
     */
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TbLnOpendataRtmsV {
        private InnerRow[] row;

        /**
         * 내부클래스를 이용해 JSON 파싱
         */
        @Data
        public static class InnerRow {
            @JsonProperty("ACC_YEAR")
            private String accYear;       // 접수연도
            @JsonProperty("SGG_CD")
            private String sggCd;         // 자치구코드
            @JsonProperty("SGG_NM")
            private String sggNm;         // 자치구명
            @JsonProperty("BJDONG_CD")
            private String bjdongCd;      // 법정동코드
            @JsonProperty("BJDONG_NM")
            private String bjdongNm;      // 법정동명
            @JsonProperty("LAND_GBN")
            private String landGbn;       // 지번구분
            @JsonProperty("LAND_GBN_NM")
            private String landGbnNm;     // 지번구분명
            @JsonProperty("BONBEON")
            private String bonbeon;       // 본번
            @JsonProperty("BUBEON")
            private String bubeon;        // 부번
            @JsonProperty("BLDG_NM")
            private String bldgNm;        // 건물명
            @JsonProperty("DEAL_YMD")
            private String dealYmd;       // 계약일
            @JsonProperty("OBJ_AMT")
            private String objAmt;        // 물건금액(만원)
            @JsonProperty("BLDG_AREA")
            private String bldgArea;      // 건물면적(m₂)
            @JsonProperty("TOT_AREA")
            private String totArea;       // 토지면적(m₂)
            @JsonProperty("FLOOR")
            private String floor;         // 층
            @JsonProperty("RIGHT_GBN")
            private String rightGbn;      // 권리구분
            @JsonProperty("CNTL_YMD")
            private String cntlYmd;       // 취소일
            @JsonProperty("BUILD_YEAR")
            private String buildYear;     // 건축연도
            @JsonProperty("HOUSE_TYPE")
            private String houseType;     // 건물용도
            @JsonProperty("REQ_GBN")
            private String reqGbn;        // 신고구분
            @JsonProperty("RDEALER_LAWDNM")
            private String rdealerLawdnm; // 신고한 공인중개사 시군구명
        }
    }
}




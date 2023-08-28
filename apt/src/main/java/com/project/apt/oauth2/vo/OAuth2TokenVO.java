package com.project.apt.oauth2.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Class Name : com.project.apt.oauth2.Oauth2Vo.java
 * @Description : OAUTH2 로그인 인증
 * @Modification Information
 * @
 * @  수정일             수정자              수정내용
 * @ ----------   ---------   -------------------------------
 * @ 2023.08.26    김영빈       	  최초생성
 *
 * @author 김영빈
 * @since 2023.08.26
 * @version 1.0.0
 * @see
 *
 */

@Data
public class OAuth2TokenVO  {
    private int tokenId;            //토큰ID
    private int userId;             //유저ID
    private String accessToken;     //입장토큰
    private String refreshToken;    //재입장토큰
    private String tokenType;       //토큰타입
    private int expiresIn;          //만료
    private String scope;           //범위
    private Timestamp createdAt;    //생성일
}

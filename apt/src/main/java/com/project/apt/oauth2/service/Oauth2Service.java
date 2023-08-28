package com.project.apt.oauth2.service;

import com.project.apt.oauth2.vo.OAuth2TokenVO;

/**
 * @Class Name : com.project.apt.oauth2.Oauth2Service.java
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
public interface Oauth2Service {
    /**
     * 토큰 조회
     * @param tokenId
     * @return
     */
    OAuth2TokenVO getOauth2View(String tokenId);

    /**
     * 토큰 생성,업데이트
     * @param oauth2TokenVO
     */
    void setOauth2Into(OAuth2TokenVO oauth2TokenVO);

    /**
     * 토큰 삭제
     * @param oauth2TokenVO
     */
    void removeOauth2Info(OAuth2TokenVO oauth2TokenVO);
}

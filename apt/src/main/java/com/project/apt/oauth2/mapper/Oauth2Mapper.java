package com.project.apt.oauth2.mapper;

import com.project.apt.oauth2.vo.OAuth2TokenVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Class Name : com.project.apt.oauth2.Oauth2Mapper.java
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
@Mapper
public interface Oauth2Mapper {
    /**
     * 토큰 조회
     * @param tokenId
     * @return
     */
    OAuth2TokenVO selectOauth2View(String tokenId);

    /**
     * 토큰 생성,업데이트
     * @param oauth2TokenVO
     */
    void mergeOAuth2Info(OAuth2TokenVO oauth2TokenVO);

    /**
     * 토큰 삭제
     * @param oauth2TokenVO
     */
    void deleteOauth2Info(OAuth2TokenVO oauth2TokenVO);


}

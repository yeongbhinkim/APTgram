package com.project.apt.oauth2.controller;

import com.project.apt.oauth2.vo.OAuth2TokenVO;
import com.project.apt.oauth2.service.Oauth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @Class Name : com.project.apt.oauth2.Oauth2Controller.java
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth2")
public class Oauth2Controller {

    /**
     * 토큰 서비스
     */
    private final Oauth2Service oauth2Service;


    /**
     * 토큰 조회
     * @param tokenId
     * @return
     */
    @GetMapping("/get/{tokenId}")
    public OAuth2TokenVO getUser(@PathVariable String tokenId) {
        return oauth2Service.getOauth2View(tokenId);
    }

    /**
     * 토큰 생성,업데이트
     * @param oauth2TokenVO
     */
    @PostMapping("/set")
    public void saveUser(@RequestBody OAuth2TokenVO oauth2TokenVO) {
        oauth2Service.setOauth2Into(oauth2TokenVO);
    }

    /**
     * 토큰 삭제
     * @param tokenId
     */
    @DeleteMapping("/remove/{tokenId}")
    public void removeOauth2Info(@PathVariable String tokenId) {
        OAuth2TokenVO oauth2TokenVO = new OAuth2TokenVO();
        oauth2TokenVO.setTokenId(Integer.parseInt(tokenId));
        oauth2Service.removeOauth2Info(oauth2TokenVO);

    }

}

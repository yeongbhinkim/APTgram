package com.project.apt.oauth2.service.impl;


import com.project.apt.oauth2.vo.OAuth2TokenVO;
import com.project.apt.oauth2.mapper.Oauth2Mapper;
import com.project.apt.oauth2.service.Oauth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Oauth2ServiceImpl implements Oauth2Service {

    /**
     * 토큰 맵퍼
     */
    @Autowired
    private Oauth2Mapper oauth2Mapper;

    /**
     * 토큰 조회
     * @param tokenId
     * @return
     */
    @Override
    public OAuth2TokenVO getOauth2View(String tokenId) {
        return oauth2Mapper.selectOauth2View(tokenId);
    }

    /**
     * 토큰 생성,업데이트
     * @param oauth2TokenVO
     */
    @Override
    public void setOauth2Into(OAuth2TokenVO oauth2TokenVO) {
        oauth2Mapper.mergeOAuth2Info(oauth2TokenVO);
    }

    /**
     * 토큰 삭제
     * @param oauth2TokenVO
     */
    @Override
    public void removeOauth2Info(OAuth2TokenVO oauth2TokenVO) {
        oauth2Mapper.deleteOauth2Info(oauth2TokenVO);
    }
}

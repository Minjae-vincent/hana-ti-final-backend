package kr.ac.kopo.travel_home.domain.oauth.service;

import kr.ac.kopo.travel_home.domain.oauth.domain.kakao.KakaoAuthVO;
import kr.ac.kopo.travel_home.domain.oauth.domain.kakao.KakaoUserVO;
import kr.ac.kopo.travel_home.global.feign.KakaoAuth;
import kr.ac.kopo.travel_home.global.feign.KakaoUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthService {
    private final KakaoAuth kakaoFeignClient;
    private final KakaoUser kakaoAuthClient;

    public KakaoUserVO getUserInfo(String code) {

        ResponseEntity<KakaoAuthVO> kakaoAuth = kakaoFeignClient.getAccessToken(
                "authorization_code",
                "15b6f9d7154890e2195a6c7ddcf716cb",
                "http://localhost:5173/register-redirect",
                code
        );

        ResponseEntity<KakaoUserVO> kakaoUser = kakaoAuthClient.getUserInfo(
                "Bearer " + kakaoAuth.getBody().getAccessToken()
        );

        //TODO: 사용자가 이미 가입되어 있는지 확인하는 로직 추가

        return kakaoUser.getBody();
    }
}

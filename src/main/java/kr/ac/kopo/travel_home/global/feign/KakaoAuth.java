package kr.ac.kopo.travel_home.global.feign;

import kr.ac.kopo.travel_home.domain.oauth.domain.kakao.KakaoAuthVO;
import kr.ac.kopo.travel_home.global.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name = "KakaoAuth", url = "https://kauth.kakao.com/", configuration = FeignConfig.class)
public interface KakaoAuth {

    @PostMapping(value = "oauth/token")
    ResponseEntity<KakaoAuthVO> getAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code
    );
}

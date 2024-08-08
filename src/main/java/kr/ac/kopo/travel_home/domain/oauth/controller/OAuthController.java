package kr.ac.kopo.travel_home.domain.oauth.controller;

import kr.ac.kopo.travel_home.domain.oauth.domain.kakao.KakaoAuthVO;
import kr.ac.kopo.travel_home.domain.oauth.domain.kakao.KakaoUserVO;
import kr.ac.kopo.travel_home.domain.oauth.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class OAuthController {
    private final OAuthService oAuthService;

    @GetMapping("/kakao/callback")
    public ResponseEntity<KakaoUserVO> callback(@QueryParam("code") String code) {
        return ResponseEntity.ok(oAuthService.getUserInfo(code));
    }
}

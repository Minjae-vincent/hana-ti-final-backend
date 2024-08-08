package kr.ac.kopo.travel_home.domain.initDB.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.kopo.travel_home.domain.initDB.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {
    private final TestService testService;

    @RequestMapping("/hello")
    public List<String> hello() {
        return testService.getDBConnectionTest();
    }

    @RequestMapping("/hello2")
    public void initialExchangeRate() throws JsonProcessingException {
        testService.initialExchangeRate();
    }
}

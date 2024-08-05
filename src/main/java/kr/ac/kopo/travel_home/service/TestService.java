package kr.ac.kopo.travel_home.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.kopo.travel_home.ExchangeRate;
import kr.ac.kopo.travel_home.global.config.TemplateConfig;
import kr.ac.kopo.travel_home.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {
    private final TestMapper testMapper;
    private final TemplateConfig templateConfig;

    public List<String> getDBConnectionTest() {
        return testMapper.getDBConnectionTest();
    }

    public void initialExchangeRate() throws JsonProcessingException {
        final String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=P0wYGCRVcy3hdlRQBQ007dHCQub91iPl&searchdate={0}&data=AP01";

        // get exchange rate for the last 500 days
        for(int i = 1; i < 500; i++) {
            String date = LocalDate.now().minusDays(i).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String exchangeRate = templateConfig.restTemplate().getForObject(url, String.class, date);
            log.info("date: {}", date);

            List<ExchangeRate> exchangeRateList = new ObjectMapper().readValue(exchangeRate, new TypeReference<List<ExchangeRate>>(){});
            for(ExchangeRate exchangeRate1 : exchangeRateList) {
                if(exchangeRate1.getCur_unit().equals("KRW")) {
                    continue;
                }

                exchangeRate1.setCur_unit(exchangeRate1.getCur_unit().substring(0, 3));
                exchangeRate1.setDate(date);
                testMapper.insertExchangeRate(exchangeRate1);
            }
        }

    }
}

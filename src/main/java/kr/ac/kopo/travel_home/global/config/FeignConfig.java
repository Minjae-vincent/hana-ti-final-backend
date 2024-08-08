package kr.ac.kopo.travel_home.global.config;

import feign.Logger;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
@Slf4j
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {
        private final ErrorDecoder defaultErrorDecoder = new Default();

        @Override
        public Exception decode(String methodKey, Response response) {
            if (response.body() != null) {
                try {
                    String body = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                    log.error("Feign error response body: {}", body);
                } catch (IOException e) {
                    log.error("Failed to read Feign error response body", e);
                }
            }
            return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}

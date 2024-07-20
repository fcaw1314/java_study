package org.example.captchademo.model;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/20 17:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Session session;
    @Data
    public static class Session {
        private String key;
        private String date;
    }
}

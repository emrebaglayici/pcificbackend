package com.pcific.pcificbackend.Spring;
import com.pcific.pcificbackend.Security.ActiveUserStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // beans
    @Bean
    public ActiveUserStore activeUserStore() {
        return new ActiveUserStore();
    }

}
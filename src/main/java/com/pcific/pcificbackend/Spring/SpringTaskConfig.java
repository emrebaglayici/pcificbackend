package com.pcific.pcificbackend.Spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan({ "com.pcific.pcificbackend.Web" })
public class SpringTaskConfig {

}

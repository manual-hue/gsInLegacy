package org.team.g2.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@ComponentScan(basePackages = {"org.team.g2.security.controller"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
// WebConfig의 getServletConfigClasses()에 연결
public class SecurityServletConfig {
}

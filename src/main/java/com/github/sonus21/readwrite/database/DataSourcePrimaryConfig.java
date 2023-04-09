package com.github.sonus21.readwrite.database;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.datasource-primary")
public class DataSourcePrimaryConfig extends HikariConfig {
}

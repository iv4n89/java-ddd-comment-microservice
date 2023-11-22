package com.films.system.comments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = {"com.films.system.comments.infrastructure"})
@EntityScan(basePackages = {"com.films.system.comments.infrastructure"})
@SpringBootApplication(scanBasePackages = "com.films.system")
public class CommentsServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(CommentsServiceApplication.class, args);
  }
}

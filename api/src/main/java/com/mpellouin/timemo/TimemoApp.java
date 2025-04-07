package com.mpellouin.timemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import com.mpellouin.timemo.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;

@SpringBootApplication
@ExcludeFromGeneratedCodeCoverage(reason = "Not testing logs")
public class TimemoApp {

  private static final Logger log = LoggerFactory.getLogger(TimemoApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(TimemoApp.class, args).getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}

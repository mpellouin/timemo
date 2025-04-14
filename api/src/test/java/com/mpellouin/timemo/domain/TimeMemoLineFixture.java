package com.mpellouin.timemo.domain;

import java.time.LocalTime;
import java.util.UUID;

public class TimeMemoLineFixture {

  public static final String HELLO_WORLD_ID = "f3f59861-1b2c-4904-a0a3-32728e43bfef";
  public static final String JOHN_DOE_ID = "033fb79a-f04c-4f99-9d69-7b1dff29fa70";

  public static TimeMemoLine helloWorld() {
    return TimeMemoLine
      .builder()
      .time(LocalTime.MIDNIGHT)
      .text("Hello World")
      .id(UUID.fromString(HELLO_WORLD_ID))
      .build();
  }

  public static TimeMemoLine johnDoe() {
    return TimeMemoLine
      .builder()
      .time(LocalTime.NOON)
      .text("John Doe")
      .id(UUID.fromString(JOHN_DOE_ID))
      .build();
  }
}

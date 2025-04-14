package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.domain.TimeMemo.TimeMemoBuilder;

public class TimeMemoFixture {

  private static final String TITLE = "TimeMemo";

  public static TimeMemo emptyTimeMemo() {
    return TimeMemo
      .builder()
      .title(TITLE)
      .build();
  }

  public static TimeMemoBuilder emptyTimeMemoBuilder() {
    return TimeMemo
      .builder()
      .title(TITLE);
  }
}

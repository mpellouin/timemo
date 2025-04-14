package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

import java.time.LocalTime;

public record TimeMemoLineTime(LocalTime value) {
  public TimeMemoLineTime {
    Assert.notNull("value", value);
  }
}

package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

import java.util.List;

public record TimeMemoLines(List<TimeMemoLine> value) {
  public TimeMemoLines {
    Assert.notNull("value", value);
  }
}

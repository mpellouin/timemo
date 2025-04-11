package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

public record TimeMemoTitle(String value) {
  public TimeMemoTitle {
    Assert.notNull("value", value);
  }
}

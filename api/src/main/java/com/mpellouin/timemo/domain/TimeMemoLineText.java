package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

public record TimeMemoLineText(String value) {
  public TimeMemoLineText {
    Assert.notNull("value", value);
  }
}

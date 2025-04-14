package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

import java.util.UUID;

public record TimeMemoLineId(UUID value) {
  public TimeMemoLineId {
    Assert.notNull("value", value);
  }

  public static TimeMemoLineId newId() {
    return new TimeMemoLineId(UUID.randomUUID());
  }
}

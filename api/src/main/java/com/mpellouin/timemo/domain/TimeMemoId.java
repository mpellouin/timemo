package com.mpellouin.timemo.domain;

import java.util.UUID;

public record TimeMemoId(UUID value) {
  public static TimeMemoId newId() {
    return new TimeMemoId(UUID.randomUUID());
  }
}

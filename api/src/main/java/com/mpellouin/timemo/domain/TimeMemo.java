package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

import java.util.UUID;

public class TimeMemo {
  private final TimeMemoTitle title;
  private final TimeMemoId id;

  private TimeMemo(TimeMemoBuilder builder) {
    Assert.notNull("title", builder.title);

    title = new TimeMemoTitle(builder.title);

    if (builder.id != null) {
      id = new TimeMemoId(builder.id);
    } else {
      id = TimeMemoId.newId();
    }
  }

  public static TimeMemoBuilder builder() {
    return new TimeMemoBuilder();
  }

  public TimeMemoTitle title() {
    return title;
  }

  public TimeMemoId id() {
    return id;
  }

  public static class TimeMemoBuilder {
    public String title;
    private UUID id;

    public TimeMemo build() {
       return new TimeMemo(this);
    }

    public TimeMemoBuilder title(String title) {
      this.title = title;
      return this;
    }

    public TimeMemoBuilder id(UUID id) {
      this.id = id;
      return this;
    }
  }
}

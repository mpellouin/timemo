package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

import java.time.LocalTime;
import java.util.UUID;

public class TimeMemoLine {
  private final TimeMemoLineText text;
  private final TimeMemoLineTime time;
  private final TimeMemoLineId id;

  public TimeMemoLine(TimeMemoLineBuilder builder) {
    Assert.notNull("text", builder.text);
    Assert.notNull("time", builder.time);

    text = new TimeMemoLineText(builder.text);
    time = new TimeMemoLineTime(builder.time);
    if (builder.id != null) {
      id = new TimeMemoLineId(builder.id);
    } else {
      id = TimeMemoLineId.newId();
    }
  }

  public static TimeMemoLineBuilder builder() {
    return new TimeMemoLineBuilder();
  }

  public TimeMemoLineTime time() {
    return time;
  }

  public TimeMemoLineText text() {
    return text;
  }

  public TimeMemoLineId id() {
    return id;
  }

  public static class TimeMemoLineBuilder {
    private LocalTime time;
    private String text;
    private UUID id;

    public TimeMemoLine build() {
      return new TimeMemoLine(this);
    }

    public TimeMemoLineBuilder text(String text) {
      this.text = text;
      return this;
    }

    public TimeMemoLineBuilder time(LocalTime time) {
      this.time = time;
      return this;
    }

    public TimeMemoLineBuilder id(UUID id) {
      this.id = id;
      return this;
    }
  }
}

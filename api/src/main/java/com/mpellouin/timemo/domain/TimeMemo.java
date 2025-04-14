package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TimeMemo {
  private final TimeMemoTitle title;
  private final TimeMemoId id;
  private final TimeMemoLines lines;

  private TimeMemo(TimeMemoBuilder builder) {
    Assert.notNull("title", builder.title);
    Assert.notNull("lines", builder.lines);

    title = new TimeMemoTitle(builder.title);
    lines = new TimeMemoLines(builder.lines);

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

  public TimeMemoLines lines() {
    return lines;
  }

  public TimeMemo addLine(TimeMemoLine timeMemoLine) {
    List<TimeMemoLine> timeMemoLines = new ArrayList<>(lines.value());
    timeMemoLines.add(timeMemoLine);

    return TimeMemo
      .builder()
      .id(id.value())
      .title(title.value())
      .lines(timeMemoLines)
      .build();
  }

  public TimeMemo eraseLastLine() {
    if (lines.value().isEmpty()) {
      throw new NoTimeMemoLineToDeleteException();
    }

    List<TimeMemoLine> timeMemoLines = new ArrayList<>(lines.value());
    timeMemoLines.removeLast();
    return TimeMemo
      .builder()
      .id(id.value())
      .title(title.value())
      .lines(timeMemoLines)
      .build();
  }

  public static class TimeMemoBuilder {
    private String title;
    private List<TimeMemoLine> lines = List.of();
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

    public TimeMemoBuilder lines(List<TimeMemoLine> lines) {
      this.lines = lines;
      return this;
    }
  }
}

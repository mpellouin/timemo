package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.MissingMandatoryValueException;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static com.mpellouin.timemo.domain.TimeMemoFixture.emptyTimeMemo;
import static com.mpellouin.timemo.domain.TimeMemoFixture.emptyTimeMemoBuilder;
import static com.mpellouin.timemo.domain.TimeMemoLineFixture.helloWorld;
import static com.mpellouin.timemo.domain.TimeMemoLineFixture.johnDoe;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TimeMemoTest {
  private final UUID ID = UUID.fromString("4d9394d9-27f7-49d0-a1e3-39d9d9310fc0");
  private final String TITLE = "TimeMemo";

  @Test
  public void shouldThrowIfCreatingATimeMemoWithoutATitle() {
    assertThatThrownBy(() -> TimeMemo.builder().build())
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("title");
  }

  @Test
  public void shouldThrowIfCreatingATimeMemoWithANullTitle() {
    assertThatThrownBy(() -> TimeMemo.builder().title(null).build())
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("title");
  }

  @Test
  public void shouldBeAbleToSpecifyAnId() {
    TimeMemo timeMemo = emptyTimeMemoBuilder().id(ID).build();

    assertThat(timeMemo).isNotNull();
    assertThat(timeMemo.title().value()).isEqualTo(TITLE);
    assertThat(timeMemo.id().value()).isEqualTo(ID);
  }

  @Test
  public void shouldGenerateRandomTimeMemoIdIfNotSpecified() {
    TimeMemo timeMemo = emptyTimeMemo();

    assertThat(timeMemo).isNotNull();
    assertThat(timeMemo.title().value()).isEqualTo(TITLE);
    assertThat(timeMemo.id().value()).isNotNull();
    assertThat(timeMemo.id().value()).isNotEqualTo(ID);
  }

  @Test
  public void shouldBeAbleToGetTimeMemoLines() {
    TimeMemo timeMemo = emptyTimeMemo();

    assertThat(timeMemo.lines()).isInstanceOf(TimeMemoLines.class);
    assertThat(timeMemo.lines().value()).isEqualTo(List.of());
  }

  @Test
  public void shouldBeAbleToSpecifyTimeMemoLines() {
    List<TimeMemoLine> lines = List.of(helloWorld(), johnDoe());

    TimeMemo timeMemo = emptyTimeMemoBuilder().lines(lines).build();

    assertThat(timeMemo.lines().value()).hasSize(2);
    assertThat(timeMemo.lines().value()).isEqualTo(lines);
  }

  @Test
  public void shouldBeAbleToAddATimeMemoLine() {
    TimeMemo timeMemo = emptyTimeMemo();
    TimeMemoLine timeMemoLine = helloWorld();

    timeMemo = timeMemo.addLine(timeMemoLine);

    assertThat(timeMemo.lines().value()).hasSize(1);
    assertThat(timeMemo.lines().value()).isEqualTo(List.of(timeMemoLine));
    assertThat(timeMemo.title().value()).isEqualTo(TITLE);
  }

  @Test
  public void shouldThrowIfDeletingLineFromEmptyTimeMemo() {
    TimeMemo timeMemo = emptyTimeMemo();

    assertThatThrownBy(timeMemo::eraseLastLine)
      .isInstanceOf(NoTimeMemoLineToDeleteException.class)
      .hasMessageContaining("Cannot delete line from empty time memo");
  }

  @Test
  public void shouldBeAbleToDeleteALineFromATimeMemo() {
    TimeMemoLine firstLine = helloWorld();
    List<TimeMemoLine> lines = List.of(firstLine, johnDoe());
    TimeMemo timeMemo = emptyTimeMemoBuilder().lines(lines).build();

    timeMemo = timeMemo.eraseLastLine();

    assertThat(timeMemo.lines().value()).hasSize(1);
    assertThat(timeMemo.lines().value()).isEqualTo(List.of(firstLine));
  }

}

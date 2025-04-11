package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.MissingMandatoryValueException;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TimeMemoTest {
  private final UUID TIMEMEMO_ID = UUID.fromString("4d9394d9-27f7-49d0-a1e3-39d9d9310fc0");
  private final String TIMEMEMO_TITLE = "TimeMemo";

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
  public void shouldBuildATimeMemo() {
    TimeMemo timeMemo = TimeMemo.builder().title(TIMEMEMO_TITLE).build();

    assertThat(timeMemo).isNotNull();
    assertThat(timeMemo.title().value()).isEqualTo(TIMEMEMO_TITLE);
  }

  @Test
  public void shouldBeAbleToSpecifyAnId() {
    TimeMemo timeMemo = TimeMemo.builder().title(TIMEMEMO_TITLE).id(TIMEMEMO_ID).build();
    assertThat(timeMemo).isNotNull();
    assertThat(timeMemo.title().value()).isEqualTo(TIMEMEMO_TITLE);
    assertThat(timeMemo.id().value()).isEqualTo(TIMEMEMO_ID);
  }

  @Test
  public void shouldGenerateRandomTimeMemoIdIfNotSpecified() {
    TimeMemo timeMemo = TimeMemo.builder().title(TIMEMEMO_TITLE).build();

    assertThat(timeMemo).isNotNull();
    assertThat(timeMemo.title().value()).isEqualTo(TIMEMEMO_TITLE);
    assertThat(timeMemo.id().value()).isNotNull();
    assertThat(timeMemo.id().value()).isNotEqualTo(TIMEMEMO_ID);

  }

}

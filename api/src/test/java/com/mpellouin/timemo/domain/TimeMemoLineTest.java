package com.mpellouin.timemo.domain;

import com.mpellouin.timemo.shared.error.domain.MissingMandatoryValueException;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TimeMemoLineTest {

  private static final LocalTime TIME = LocalTime.of(8, 0);
  private static final String ID_STRING = "4d9394d9-27f7-49d0-a1e3-39d9d9310fc0";
  private static final UUID ID = UUID.fromString(ID_STRING);

  @Test
  public void shouldNotBuildWithoutText() {
    assertThatThrownBy(() -> TimeMemoLine.builder().build())
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("text");
  }

  @Test
  public void shouldNotBuildWithoutTimestamp() {
    assertThatThrownBy(() -> TimeMemoLine.builder().text("timememo").build())
      .isInstanceOf(MissingMandatoryValueException.class)
      .hasMessageContaining("time");
  }

  @Test
  public void shouldBuildCorrectlyIfWellFilled() {
    TimeMemoLine timeMemoLine = TimeMemoLine.builder().text("timememo").time(TIME).build();

    assertThat(timeMemoLine).isNotNull();
    assertThat(timeMemoLine.time().value()).isEqualTo(TIME);
    assertThat(timeMemoLine.text().value()).isEqualTo("timememo");
  }

  @Test
  public void shouldBeAbleToSpecifyId() {
    TimeMemoLine timeMemoLine = TimeMemoLine.builder().text("timememo").time(TIME).id(ID).build();

    assertThat(timeMemoLine).isNotNull();
    assertThat(timeMemoLine.time().value()).isEqualTo(TIME);
    assertThat(timeMemoLine.text().value()).isEqualTo("timememo");
    assertThat(timeMemoLine.id().value()).isEqualTo(ID);
  }

  @Test
  public void shouldGenerateRandomIdIfNotSpecified() {
    TimeMemoLine timeMemoLine = TimeMemoLine.builder().text("timememo").time(TIME).build();

    assertThat(timeMemoLine).isNotNull();
    assertThat(timeMemoLine.time().value()).isEqualTo(TIME);
    assertThat(timeMemoLine.text().value()).isEqualTo("timememo");
    assertThat(timeMemoLine.id().value()).isNotEqualTo(ID).isNotNull();
  }
}

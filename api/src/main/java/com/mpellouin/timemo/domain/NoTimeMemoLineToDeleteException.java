package com.mpellouin.timemo.domain;

public class NoTimeMemoLineToDeleteException extends RuntimeException {
  public NoTimeMemoLineToDeleteException() {
    super("Cannot delete line from empty time memo");
  }
}

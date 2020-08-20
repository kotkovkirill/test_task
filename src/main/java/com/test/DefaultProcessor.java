package com.test;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.Map;
import javax.annotation.Nonnull;

public abstract class DefaultProcessor implements Processor {

  public void initialize(@Nonnull Map<String, String> configuration) {
    checkNotNull(configuration, "configuration must not be null");
  }

  public void process(@Nonnull Map<String, Object> jsonDocument) {
    checkState(jsonDocument != null,  "json document must not be null");
  }
}

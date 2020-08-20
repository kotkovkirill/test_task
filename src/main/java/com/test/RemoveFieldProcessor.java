package com.test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.Map;
import javax.annotation.Nonnull;

public class RemoveFieldProcessor extends DefaultProcessor {

  static final String NAME = "RemoveField";

  private static final String FIELD_NAME_KEY = "fieldName";

  private String fieldName = null;

  @Override
  public void initialize(@Nonnull Map<String, String> configuration) {
    super.initialize(configuration);
    checkArgument(configuration.containsKey(FIELD_NAME_KEY), "configuration must contain key " + FIELD_NAME_KEY);
    fieldName = configuration.get(FIELD_NAME_KEY);
  }

  /**
   * This removes the configured field name if it exist in the the given json document
   * @param jsonDocument jsonDocument to work with
   */
  @Override
  public void process(@Nonnull Map<String, Object> jsonDocument) {
    super.process(jsonDocument);
    checkState(fieldName != null, "processor must be initialized");
    jsonDocument.remove(fieldName);
  }
}

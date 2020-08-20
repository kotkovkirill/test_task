package com.test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.Map;
import javax.annotation.Nonnull;

public class AddFieldProcessor extends DefaultProcessor {

  static final String NAME = "AddField";

  private static final String FIELD_NAME_KEY = "fieldName";
  private static final String FIELD_VALUE_KEY = "fieldValue";

  private String fieldName = null;
  private String fieldValue = null;

  @Override
  public void initialize(@Nonnull Map<String, String> configuration) {
    super.initialize(configuration);
    checkArgument(configuration.containsKey(FIELD_NAME_KEY), "configuration must contain key " + FIELD_NAME_KEY);
    checkArgument(configuration.containsKey(FIELD_VALUE_KEY), "configuration must contain key " + FIELD_VALUE_KEY);
    fieldName = configuration.get(FIELD_NAME_KEY);
    fieldValue = configuration.get(FIELD_VALUE_KEY);

  }

  /**
   * This adds or replace configured field name and value to jsonDocument
   * @param jsonDocument jsonDocument to work with
   */
  @Override
  public void process(@Nonnull Map<String, Object> jsonDocument) {
    super.process(jsonDocument);
    checkState(fieldName != null && fieldValue != null, "processor must be initialized");
    jsonDocument.put(fieldName, fieldValue);
  }
}

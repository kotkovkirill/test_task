package com.test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.util.Map;
import javax.annotation.Nonnull;

public class CountNumberOfFieldsProcessor extends DefaultProcessor {

  static final String NAME = "CountNumOfFields";

  private static final String TARGET_FIELD_NAME_KEY = "targetFieldName";

  private String targetFieldName = null;

  @Override
  public void initialize(@Nonnull Map<String, String> configuration) {
    super.initialize(configuration);
    checkArgument(configuration.containsKey(TARGET_FIELD_NAME_KEY), "configuration must contain key " + TARGET_FIELD_NAME_KEY);
    targetFieldName = configuration.get(TARGET_FIELD_NAME_KEY);
  }

  /**
   * This counts the number of entries in the document and writes that value to targetFieldName key
   * @param jsonDocument jsonDocument to work with
   */
  @Override
  public void process(@Nonnull Map<String, Object> jsonDocument) {
    super.process(jsonDocument);
    checkState(targetFieldName != null, "processor must be initialized");
    jsonDocument.put(targetFieldName, jsonDocument.keySet().size());
  }
}

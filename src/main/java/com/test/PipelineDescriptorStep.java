package com.test;

import java.util.Map;

public class PipelineDescriptorStep {

  public PipelineDescriptorStep() {

  }

  public PipelineDescriptorStep(String processor,
      Map<String, String> configuration) {
    this.processor = processor;
    this.configuration = configuration;
  }

  private String processor;
  private Map<String, String> configuration;

  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public Map<String, String> getConfiguration() {
    return configuration;
  }

  public void setConfiguration(Map<String, String> configuration) {
    this.configuration = configuration;
  }
}

package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class PipelineDescriptorFactory {

  private ObjectMapper mapper = new ObjectMapper();

  public PipelineDescriptor fromSteps(
      Collection<PipelineDescriptorStep> steps
  ) {
    return new PipelineDescriptor(steps);
  }

  public PipelineDescriptor fromJson(
      InputStream is
  ) {
    try {
      return mapper.readValue(is, PipelineDescriptor.class);
    } catch (Exception e) {
      throw new RuntimeException("Could not deserialize pipeline descriptor", e);
    }
  }
}

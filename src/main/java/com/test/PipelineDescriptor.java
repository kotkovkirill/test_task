package com.test;

import java.util.Collection;

public class PipelineDescriptor {

  public PipelineDescriptor() {

  }

  public PipelineDescriptor(Collection<PipelineDescriptorStep> steps) {
    this.steps = steps;
  }

  private Collection<PipelineDescriptorStep> steps;

  public Collection<PipelineDescriptorStep> getSteps() {
    return steps;
  }
}

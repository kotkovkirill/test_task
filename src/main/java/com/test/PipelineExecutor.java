package com.test;

import java.util.Map;

public class PipelineExecutor {

  private ProcessorFactory processorFactory = new DefaultProcessorFactory();

  public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument){
    for(PipelineDescriptorStep step : pipelineDescriptor.getSteps()) {
      Processor processor = processorFactory.create(step.getProcessor());
      processor.initialize(step.getConfiguration());
      processor.process(jsonDocument);
    }
  }
}

package com.test;

public class DefaultProcessorFactory implements ProcessorFactory {

  //TODO there are multiple ways to improve this
  public Processor create(String processorName) {

    if(AddFieldProcessor.NAME.equals(processorName)) {
      return new AddFieldProcessor();
    } else if(RemoveFieldProcessor.NAME.equals(processorName)) {
      return new RemoveFieldProcessor();
    } else if(CountNumberOfFieldsProcessor.NAME.equals(processorName)) {
      return new CountNumberOfFieldsProcessor();
    } else {
      throw new RuntimeException("Invalid processorName : " + processorName);
    }
  }
}

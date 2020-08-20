package com.test;

import static com.test.TestFixture.FIELD_NAME_1;
import static com.test.TestFixture.FIELD_NAME_2;
import static com.test.TestFixture.FIELD_NAME_3;
import static com.test.TestFixture.FIELD_VALUE_1;
import static com.test.TestFixture.FIELD_VALUE_2;
import static com.test.TestFixture.FIELD_VALUE_3;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class PipelineExecutorTest {

  private PipelineExecutor pipelineExecutor;
  private Map<String, Object> jsonDocument;


  @Before
  public void setup() {
    pipelineExecutor = new PipelineExecutor();
    jsonDocument = new HashMap<String, Object>();
    jsonDocument.put(FIELD_NAME_1, FIELD_VALUE_1);
    jsonDocument.put(FIELD_NAME_2, FIELD_VALUE_2);
    jsonDocument.put(FIELD_NAME_3, FIELD_VALUE_3);
  }

  @Test
  public void testPipelineExecutorFromPojo() {
    PipelineDescriptor pipelineDescriptor = new PipelineDescriptorFactory().fromSteps(
        ImmutableList.of(
            new PipelineDescriptorStep(
                AddFieldProcessor.NAME,
                ImmutableMap.of(
                    "fieldName", "firstName",
                    "fieldValue", "George"
                )
            ),
            new PipelineDescriptorStep(
                CountNumberOfFieldsProcessor.NAME,
                ImmutableMap.of(
                    "targetFieldName", "numOfFields"
                )
            )
        )
    );

    pipelineExecutor.transform(pipelineDescriptor, jsonDocument);

    checkResult(jsonDocument);
  }

  @Test
  public void testPipelineExecutorFromJson() {
    PipelineDescriptor pipelineDescriptor = new PipelineDescriptorFactory().fromJson(
        this.getClass().getClassLoader().getResourceAsStream("pipeline.json")
    );

    pipelineExecutor.transform(pipelineDescriptor, jsonDocument);

    checkResult(jsonDocument);
  }

  private void checkResult(Map<String, Object> jsonDocument) {
    assertNotNull(jsonDocument);
    assertEquals(jsonDocument.size(), 5);
    assertEquals(FIELD_VALUE_1, jsonDocument.get(FIELD_NAME_1));
    assertEquals(FIELD_VALUE_2, jsonDocument.get(FIELD_NAME_2));
    assertEquals(FIELD_VALUE_3, jsonDocument.get(FIELD_NAME_3));
    assertEquals("George", jsonDocument.get("firstName"));
    assertEquals(4, jsonDocument.get("numOfFields"));
  }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.llm.textvectorisation.model;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;
import java.util.List;

public class ExceptionThrowingEmbeddingModel implements EmbeddingModel {

  @Override
  public Response<Embedding> embed(String text) {
    throw new RuntimeException("Failed to vectorise");
  }

  @Override
  public Response<Embedding> embed(TextSegment textSegment) {
    throw new RuntimeException("Failed to vectorise");
  }

  @Override
  public Response<List<Embedding>> embedAll(List<TextSegment> textSegments) {
    throw new RuntimeException("Failed to vectorise");
  }

  public static ExceptionThrowingEmbeddingModel.ExceptionThrowingEmbeddingModelBuilder builder() {
    return new ExceptionThrowingEmbeddingModel.ExceptionThrowingEmbeddingModelBuilder();
  }

  public static class ExceptionThrowingEmbeddingModelBuilder {

    public ExceptionThrowingEmbeddingModelBuilder() {}

    public ExceptionThrowingEmbeddingModel build() {
      return new ExceptionThrowingEmbeddingModel();
    }
  }
}

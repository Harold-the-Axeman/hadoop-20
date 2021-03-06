/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.storageservice;

import com.google.common.util.concurrent.AbstractCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.IOException;

/** Carries all information about NameNode's response to single Request */
public class Response<T> extends AbstractCheckedFuture<T, IOException> {
  public Response(ListenableFuture<T> delegate) {
    super(delegate);
  }

  @Override
  protected IOException mapException(Exception e) {
    if (e instanceof IOException) {
      return (IOException) e;
    }
    return new IOException("Exception while processing request: ", e);
  }
}

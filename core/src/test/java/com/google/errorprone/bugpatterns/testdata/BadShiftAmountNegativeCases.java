/*
 * Copyright 2013 The Error Prone Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns.testdata;

/**
 * @author Bill Pugh (bill.pugh@gmail.com)
 */
public class BadShiftAmountNegativeCases {

  public void foo() {
    int x = 0;
    long result = 0;

    result += (long) x >> 3;
    result += x << 3;
    result += x >>> 3;
    result += (long) (x & 0xff) >> 40;
  }
}

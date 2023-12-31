/*
 * Copyright 2017 The Error Prone Authors.
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
 * @author sulku@google.com (Marsela Sulku)
 */
public class MultipleUnaryOperatorsInMethodCallNegativeCases {
  public static void tests(int a, int b, int[] xs) {
    testMethod(a, b);
    testMethod(a + 1, b);
    testMethod(b, a + 1);
    testMethod(a++, b);
    testMethod(--a, b);
    testMethod(a, b--);
    testMethod(a, ++b);
    testMethod(xs[0]++, xs[0]++);
  }

  public static void testMethod(int one, int two) {}
}

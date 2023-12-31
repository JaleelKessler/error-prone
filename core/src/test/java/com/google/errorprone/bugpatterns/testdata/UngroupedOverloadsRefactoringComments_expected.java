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
 * @author hanuszczak@google.com (Łukasz Hanuszczak)
 */
class UngroupedOverloadsRefactoringComments {

  private void bar() {}

  // Something about `bar`.
  /** Does something. */
  public void bar(int x) {}

  // Something about this `bar`.
  public void bar(int x, int y) {}

  // More stuff about `bar`.
  public void bar(int x, int y, int z) {
    // Some internal comments too.
  }

  public void bar(String s) {}

  public static final String FOO = "foo"; // This is super-important comment for `foo`.

  // Something about `baz`.
  public static final String BAZ = "baz"; // Stuff about `baz` continues.

  public void quux() {}
}

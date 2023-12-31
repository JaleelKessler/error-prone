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

import junit.framework.TestCase;

/**
 * @author rburny@google.com (Radoslaw Burny)
 */
public class JUnit3TestNotRunPositiveCases extends TestCase {
  // BUG: Diagnostic contains: JUnit3TestNotRun
  public static void tesNameStatic() {}

  // These names are trickier to correct, but we should still indicate the bug
  // BUG: Diagnostic contains: JUnit3TestNotRun
  public void tetsName() {}

  // BUG: Diagnostic contains: JUnit3TestNotRun
  public void tesstName() {}

  // BUG: Diagnostic contains: JUnit3TestNotRun
  public void tesetName() {}

  // BUG: Diagnostic contains: JUnit3TestNotRun
  public void tesgName() {}

  // tentative - can cause false positives
  // BUG: Diagnostic contains: JUnit3TestNotRun
  public void textName() {}
}

/*
 * Copyright 2014 The Error Prone Authors.
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

import static com.google.errorprone.bugpatterns.testdata.ChainingConstructorIgnoresParameterPositiveCases.Location.TEST_TARGET;

/**
 * @author cpovirk@google.com (Chris Povirk)
 */
public class ChainingConstructorIgnoresParameterPositiveCases {
  static class MissileLauncher {
    MissileLauncher(Location target, boolean askForConfirmation) {}

    MissileLauncher(Location target) {
      this(target, false);
    }

    MissileLauncher(boolean askForConfirmation) {
      // BUG: Diagnostic contains: this(TEST_TARGET, askForConfirmation)
      this(TEST_TARGET, false);
    }
  }

  static class ClassRatherThanPrimitive {
    ClassRatherThanPrimitive(String foo, boolean bar) {}

    ClassRatherThanPrimitive(String foo) {
      // BUG: Diagnostic contains: this(foo, false)
      this("default", false);
    }
  }

  static class CallerBeforeCallee {
    CallerBeforeCallee(String foo) {
      // BUG: Diagnostic contains: this(foo, false)
      this("default", false);
    }

    CallerBeforeCallee(String foo, boolean bar) {}
  }

  static class AssignableButNotEqual {
    AssignableButNotEqual(Object foo, boolean bar) {}

    AssignableButNotEqual(String foo) {
      // BUG: Diagnostic contains: this(foo, false)
      this("default", false);
    }
  }

  static class HasNestedClassCallerFirst {
    HasNestedClassCallerFirst(String foo) {
      // BUG: Diagnostic contains: this(foo, false)
      this("somethingElse", false);
    }

    static class NestedClass {}

    HasNestedClassCallerFirst(String foo, boolean bar) {}
  }

  static class HasNestedClassCalleeFirst {
    HasNestedClassCalleeFirst(String foo, boolean bar) {}

    static class NestedClass {}

    HasNestedClassCalleeFirst(String foo) {
      // BUG: Diagnostic contains: this(foo, false)
      this("somethingElse", false);
    }
  }

  static class MultipleQueuedErrors {
    MultipleQueuedErrors(Location target) {
      // BUG: Diagnostic contains: this(target, false)
      this(TEST_TARGET, false);
    }

    MultipleQueuedErrors(boolean askForConfirmation) {
      // BUG: Diagnostic contains: this(TEST_TARGET, askForConfirmation)
      this(TEST_TARGET, false);
    }

    MultipleQueuedErrors(Location target, boolean askForConfirmation) {}
  }

  enum Location {
    TEST_TARGET
  }
}

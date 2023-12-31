/*
 * Copyright 2013 The Error Prone Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.refaster;

import static org.junit.Assert.assertThrows;

import com.google.common.testing.EqualsTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link Bindings}.
 *
 * @author lowasser@google.com (Louis Wasserman)
 */
@RunWith(JUnit4.class)
public class BindingsTest {
  private static class Key extends Bindings.Key<String> {
    Key(String identifier) {
      super(identifier);
    }
  }

  private static class OtherKey extends Bindings.Key<String> {
    OtherKey(String identifier) {
      super(identifier);
    }
  }

  @Test
  public void putRestricts() {
    assertThrows(ClassCastException.class, () -> Bindings.create().put(new Key("foo"), 3));
  }

  @Test
  public void keyClassesDistinct() {
    new EqualsTester()
        .addEqualityGroup(new Key("foo"))
        .addEqualityGroup(new Key("bar"))
        .addEqualityGroup(new OtherKey("foo"))
        .testEquals();
  }
}

/*
 * Copyright 2015 The Error Prone Authors.
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

package com.google.errorprone.predicates;

import static com.google.errorprone.suppliers.Suppliers.fromStrings;

import com.google.errorprone.predicates.type.Array;
import com.google.errorprone.predicates.type.DescendantOf;
import com.google.errorprone.predicates.type.DescendantOfAny;
import com.google.errorprone.predicates.type.Exact;
import com.google.errorprone.predicates.type.ExactAny;
import com.google.errorprone.suppliers.Supplier;
import com.google.errorprone.suppliers.Suppliers;
import com.sun.tools.javac.code.Type;

/** A collection of {@link TypePredicate}s. */
public final class TypePredicates {

  /** Matches nothing (always {@code false}). */
  public static TypePredicate nothing() {
    return (type, state) -> false;
  }

  /** Matches everything (always {@code true}). */
  public static TypePredicate anything() {
    return (type, state) -> true;
  }

  /** Match arrays. */
  public static TypePredicate isArray() {
    return Array.INSTANCE;
  }

  /** Match types that are exactly equal. */
  public static TypePredicate isExactType(String type) {
    return isExactType(Suppliers.typeFromString(type));
  }

  /** Match types that are exactly equal. */
  public static TypePredicate isExactType(Supplier<Type> type) {
    return new Exact(type);
  }

  /** Match types that are exactly equal to any of the given types. */
  public static TypePredicate isExactTypeAny(Iterable<String> types) {
    return new ExactAny(fromStrings(types));
  }

  /** Match sub-types of the given type. */
  public static TypePredicate isDescendantOf(Supplier<Type> type) {
    return new DescendantOf(type);
  }

  /** Match sub-types of the given type. */
  public static TypePredicate isDescendantOf(String type) {
    return isDescendantOf(Suppliers.typeFromString(type));
  }

  /** Match types that are a sub-type of one of the given types. */
  public static TypePredicate isDescendantOfAny(Iterable<String> types) {
    return new DescendantOfAny(fromStrings(types));
  }

  public static TypePredicate allOf(TypePredicate... predicates) {
    return (type, state) -> {
      for (TypePredicate predicate : predicates) {
        if (!predicate.apply(type, state)) {
          return false;
        }
      }
      return true;
    };
  }

  public static TypePredicate anyOf(TypePredicate... predicates) {
    return (type, state) -> {
      for (TypePredicate predicate : predicates) {
        if (predicate.apply(type, state)) {
          return true;
        }
      }
      return false;
    };
  }

  public static TypePredicate not(TypePredicate predicate) {
    return (type, state) -> !predicate.apply(type, state);
  }

  private TypePredicates() {}
}

/*
 * MIT License
 *
 * Copyright (c) 2020-2022 Bruno Andrade
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.artsman;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

class Person {
	private String firstName;
  private String lastName;
  private String fullName;

  Person(String firstName, String lastName) {
    requireNonNull(firstName, "firstName is required");
    requireNonNull(lastName, "lastName is required");
    this.firstName = firstName;
    this.lastName = lastName;
    this.fullName = firstName + " " + lastName;
  }

  String firstName() {
    return this.firstName;
  }

  String lastName() {
    return this.lastName;
  }

  String fullName() {
    return this.fullName;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    var person = (Person) object;
    return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}

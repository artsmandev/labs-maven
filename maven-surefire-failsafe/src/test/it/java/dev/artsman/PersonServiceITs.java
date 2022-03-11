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

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonServiceITs extends Assertions {
  @DisplayName("Should return an empty set when there is no Person instead null")
  @Test
  void shouldReturnAnEmptySetWhenThereIsNoPersonInsteadNull() {
    var service = new PersonServiceImpl(new DatabaseWithoutPersonStub());
    assertTrue(service.allRegistered().isEmpty());
  }

  @DisplayName("Should return bruce and oswald")
  @Test
  void shouldReturnBruceAndOswald() {
    var service = new PersonServiceImpl(new DatabaseWithPersonStub());
    var allRegistered = service.allRegistered();
    assertEquals(2, service.allRegistered().size());
    assertTrue(allRegistered.contains(new Person("bruce", "wayne")));
    assertTrue(allRegistered.contains(new Person("oswald", "cobblepot")));
    assertFalse(allRegistered.contains(new Person("peter", "parker")));
  }

  class DatabaseWithoutPersonStub implements Database {
    @Override
    public Set<Person> findAll() {
      return null;
    }
  }

  class DatabaseWithPersonStub implements Database {
    @Override
    public Set<Person> findAll() {
      return Set.of(
        new Person("bruce", "wayne"),
        new Person("oswald", "cobblepot")
      );
    }
  }
}

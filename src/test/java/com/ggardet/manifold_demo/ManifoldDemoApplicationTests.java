package com.ggardet.manifold_demo;

import manifold.ext.rt.api.auto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManifoldDemoApplicationTests {

	@Test
	void properties() {
		final var person = new Person("John", "Doe", 42);
		person.firstName = "Jane";
		Assertions.assertEquals("Jane", person.firstName);
	}

	@Test
	void defaultArgs() {
		final var person = new Person();
		Assertions.assertEquals(99, person.age);
		Assertions.assertEquals("unknown", person.firstName);
		Assertions.assertEquals("unknown", person.lastName);
	}

	@Test
	void namedArgs() {
		final var firstPerson = new Person(firstName: "Gilles");
		Assertions.assertEquals(99, firstPerson.age);
		Assertions.assertEquals("Gilles", firstPerson.firstName);
		Assertions.assertEquals("unknown", firstPerson.lastName);
		final var secondPerson = new Person(age: 55, lastName: "Georges");
		Assertions.assertEquals(55, secondPerson.age);
		Assertions.assertEquals("Georges", secondPerson.lastName);
	}

	@Test
	void tuples() {
		final var person = new Person("Gilles", "Gardet", 39);
		auto tuple = (person.firstName, lastName: "Gardet", age: person.age);
		Assertions.assertEquals("Gilles", tuple.firstName);
		Assertions.assertEquals("Gardet", tuple.lastName);
		Assertions.assertEquals(39, tuple.age);
	}

	@Test
	void stringTemplate() {
		final var person = new Person("Gilles", "Gardet", 39);
		final var text = "${person.firstName} ${person.lastName} is ${person.age} years old.";
		Assertions.assertEquals("Gilles Gardet is 39 years old.", text);
	}
}

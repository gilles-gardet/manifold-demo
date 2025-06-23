package com.ggardet.manifold_demo;

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
}

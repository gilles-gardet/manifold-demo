# Manifold Demo Project

This project demonstrates some of the cool features provided by the [Manifold](https://github.com/manifold-systems/manifold) framework, which extends Java with modern language features without requiring a new language or compiler.

## Features Demonstrated

### 1. Properties (`@var` annotation)
Manifold's `@var` annotation eliminates the need for boilerplate getters and setters, allowing direct field access while maintaining encapsulation.

In the Person class, we use `@var` annotations on fields:
```java
public class Person {
    @var
    final String firstName;
    // other fields...
}
```

This allows direct property access in code, as shown in the tests.

### 2. Default Parameters
Manifold allows you to specify default values for method and constructor parameters:

```java
public Person(
    final String firstName="unknown", 
    final String lastName="unknown", 
    final int age=99, 
    final String phone
) {
    // constructor body
}
```

This enables creating objects without specifying all parameters:
```java
// Create a person with default values
final var person = new Person(phone: "555-1234");
// firstName will be "unknown", lastName will be "unknown", age will be 99
```

### 3. Named Arguments
Manifold enables named arguments, making code more readable and allowing you to specify only the parameters you need:

```java
// Only specify firstName, use defaults for other parameters
final var person1 = new Person(firstName: "Gilles", phone: "555-1234");

// Specify multiple parameters in any order
final var person2 = new Person(
    age: 55, 
    lastName: "Georges",
    phone: "555-9876"
);
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven

### Running the Project
1. Clone this repository
2. Build the project:
   ```
   mvn clean install
   ```
3. Run the application:
   ```
   mvn spring-boot:run
   ```

### Running the Tests
The tests demonstrate each of the Manifold features in action:
```
mvn test
```

## How It Works

Manifold uses Java's annotation processor and compiler plugin systems to extend the language. The project is configured with:

1. Manifold compiler plugin in the Maven configuration
2. Manifold dependencies for the specific features (properties, parameters)

Check the `pom.xml` file to see how Manifold is integrated into the build process.

## Learn More

- [Manifold GitHub Repository](https://github.com/manifold-systems/manifold)
- [Manifold Documentation](https://github.com/manifold-systems/manifold/tree/master/manifold-core-parent/manifold/src/main/resources/docs)
- [Properties Extension](https://github.com/manifold-systems/manifold/tree/master/manifold-deps-parent/manifold-props)
- [Parameters Extension](https://github.com/manifold-systems/manifold/tree/master/manifold-deps-parent/manifold-params)

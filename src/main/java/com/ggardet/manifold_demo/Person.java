package com.ggardet.manifold_demo;

import manifold.ext.props.rt.api.var;

public class Person {
    @var
    final String firstName;
    @var
    final String lastName;
    @var
    final int age;

    public Person(String firstName="unknown", String lastName="unknown", int age=99) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

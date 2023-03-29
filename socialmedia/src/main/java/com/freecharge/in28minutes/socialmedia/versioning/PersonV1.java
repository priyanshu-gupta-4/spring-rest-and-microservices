package com.freecharge.in28minutes.socialmedia.versioning;

public class PersonV1 {
    String name;
    PersonV1(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}

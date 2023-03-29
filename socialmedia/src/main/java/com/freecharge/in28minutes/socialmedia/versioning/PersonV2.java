package com.freecharge.in28minutes.socialmedia.versioning;

public class PersonV2 {
    String firstName,lastName;
    PersonV2(String firstName,String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                '}';
    }
}

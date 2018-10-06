package com.vineyardsOfApan;
/*
* This class is used to logically map the person
*
 */
public class Person {
    String nameOfPerson = null;

    private Person() {

    }

    public Person(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    @Override
    public String toString() {
        return ("Person Name : " + nameOfPerson);
    }

    @Override
    public int hashCode() {
        return this.nameOfPerson.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return this.hashCode()==object.hashCode();
    }
}

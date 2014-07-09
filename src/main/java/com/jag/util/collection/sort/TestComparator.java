package com.jag.util.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
    public static void main(String args[]) {
        List<Person> listPerson = new ArrayList<Person>();
        Person person1 = new Person(34, "lavasoft");
        Person person2 = new Person(12, "lavasoft");
        Person person3 = new Person(23, "leizhimin");
        Person person4 = new Person(13, "sdg");
        listPerson.add(person1);
        listPerson.add(person2);
        listPerson.add(person3);
        listPerson.add(person4);

        System.out.println("before sort:");
        System.out.println(listPerson);
        System.out.println();
        
        Comparator<Person> ascComparator = new PersonComparator();
        System.out.println("sort ascend:");
        Collections.sort(listPerson, ascComparator);
        System.out.println(listPerson);
        System.out.println();
        
        System.out.println("sort descend:");
        Collections.sort(listPerson, Collections.reverseOrder(ascComparator));
        System.out.println(listPerson);
        System.out.println();
    }

    static class PersonComparator implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}

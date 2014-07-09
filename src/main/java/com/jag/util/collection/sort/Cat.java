package com.jag.util.collection.sort;

public class Cat implements Comparable<Cat> {
    private int age;
    private String name;

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Cat o) {
        return this.getAge() - o.getAge();
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.age);
    }
}

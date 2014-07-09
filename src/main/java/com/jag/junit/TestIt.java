package com.jag.junit;

import junit.framework.TestCase;

public class TestIt extends TestCase { 
    public TestIt(String name) { 
        super(name); 
    } 

    public void testGetMethod() { 
        Student student = new Student("B83503124", "Justin", 100); 
        assertEquals("B83503124", student.getNumber()); 
        assertEquals("Justin", student.getName()); 
        assertEquals(100, student.getScore()); 
    } 

    public void testSetMethod() { 
        Student student = new Student(); 
        student.setNumber("B83503124"); 
        student.setName("Justin"); 
        student.setScore(100); 
        assertEquals("B83503124", student.getNumber()); 
        assertEquals("Justin", student.getName()); 
        assertEquals(10, student.getScore()); 
    } 
}
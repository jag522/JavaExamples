package com.jag.junit;

public class Student {
    private String _number; 
    private String _name; 
    private int _score; 
                                                                                                
    public Student() { 
        _number = null; 
        _name = null; 
        _score = 0; 
    } 
                                                                                                
    public Student(String num, String name, int score) { 
        _number = num; 
        _name = name; 
        _score = score; 
    } 
                                                                                                
    public String getNumber() { 
        return _number; 
    } 
                                                                                                
    public String getName() { 
        return _name; 
    } 
                                                                                                
    public int getScore() { 
        return _score; 
    } 
                                                                                                
    public void setNumber(String num) { 
        _number = num; 
    } 
                                                                                                
    public void setName(String name) { 
        _name = name; 
    } 
                                                                                                
    public void setScore(int score) { 
        _score = score; 
    } 

}

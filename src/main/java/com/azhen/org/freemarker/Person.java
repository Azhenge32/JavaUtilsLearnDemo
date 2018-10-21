package com.azhen.org.freemarker;

import java.util.List;

/**
*  @author Azhen
*/
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private List<String> hobby;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return this.age;
    }
    public void setHobby(List<String> hobby){
        this.hobby = hobby;
    }
    public List<String> getHobby(){
        return this.hobby;
    }
}
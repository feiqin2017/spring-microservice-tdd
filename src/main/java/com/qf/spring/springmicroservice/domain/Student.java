package com.qf.spring.springmicroservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue
    @Id
    private  Long id;
    private  String name;
    private  int age;
    private  String professionel;

    public Student(String name, int age, String professionel) {
        this.name = name;
        this.age = age;
        this.professionel = professionel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfessionel() {
        return professionel;
    }

    public void setProfessionel(String professionel) {
        this.professionel = professionel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(professionel, student.professionel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, professionel);
    }
}

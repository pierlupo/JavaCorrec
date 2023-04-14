package org.example.stream;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;

    private List<Course> courses;

    private int age;

    public Student(int id, String name,  int age) {
        this.id = id;
        this.name = name;

        this.courses = new ArrayList<>();
        this.age = age;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public int getAge() {
        return this.age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setAge(int age) {
        this.age = age;
    }
// getters and setters
}

package com.example.demo.model.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddStudentInput {
    private String name;
    private long id;
    private LinkedHashMap<String,Float> courseMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Float> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(LinkedHashMap<String, Float> courseMap) {
        this.courseMap = courseMap;
    }
}

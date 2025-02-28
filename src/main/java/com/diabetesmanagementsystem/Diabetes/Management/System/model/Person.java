package com.diabetesmanagementsystem.Diabetes.Management.System.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Person {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String location;
    @JsonProperty("health_metrics")
    private Map<String, Object> healthMetrics;
}
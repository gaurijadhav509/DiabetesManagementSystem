package com.diabetesmanagementsystem.Diabetes.Management.System.controllers;

import com.diabetesmanagementsystem.Diabetes.Management.System.model.Person;
import com.diabetesmanagementsystem.Diabetes.Management.System.services.HealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @Autowired
    private HealthDataService healthDataService;

    @GetMapping("/person/{name}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String name) {
        Person person = healthDataService.findPersonByName(name);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}